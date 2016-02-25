class ManagerAgent {
	public static int TotalActions = 1000; // or something.
	NeutralAgent[] ActiveAgents;
	File[] ExistingFiles;
	
public static void ProcessSendRequest(NeutralAgent Sender, File File, NeutralAgent Target) {
	// values for Sender, File and Target are sent from SendRequest method in Sender Agent.
	System.out.println(Sender.getAgentName() + " wants " + File.getFileName() + " from " + Target.getAgentName() +"."); // This will be replaced by UI display
	++TotalActions;
	// Checks list of active agents
	// if Target exists then run:
	ProcessRecieveRequest(Sender, File, Target);
	// Else return some sort of notification
}

public static void ProcessRecieveRequest(NeutralAgent Sender, File File, NeutralAgent Target) {
	// values for Sender, File and Target are sent from RecieveRequest method in Target Agent.
	System.out.println(Target.getAgentName() + " recieved request for " + File.getFileName() + " from " + Sender.getAgentName() +"."); // This will be replaced by UI display
	++TotalActions;
	Target.RecieveRequest(File, Sender);
}

public static void ProcessAccept(NeutralAgent Sender, File File, NeutralAgent Target) {
	System.out.println(Target.getAgentName() + " has " + File.getFileName() + " and will send it to " + Sender.getAgentName() +"."); // This will be replaced by UI display
	// Run SendFile method in Target
	// Then run RecieveFile method in Sender
	++TotalActions;
}

public static void ProcessReject(NeutralAgent Sender, File File, NeutralAgent Target) {
	System.out.println(Target.getAgentName() + " does not have " + File.getFileName() + " for " + Sender.getAgentName() +"."); // This will be replaced by UI display
	// Run SendRejection method in Target
	// Then run RecieveRejection method in Sender
	++TotalActions;
}
public static void UnSubscribe(NeutralAgent Agent) {
	++TotalActions;
	System.out.println(Agent.getAgentName() + " is no longer satisfied with the system."); // This will be replaced by UI display
	int vengeful = (int) (Math.random()*100);
	if (vengeful > 50){
		System.out.println(Agent.getAgentName() + " has become a Police Agent."); // This will be replaced by UI display
		// Make the Neutral Agent a Police Agent using magic or something.
	}
	else {
		// Remove Agent from list of active Agents.
		System.out.println(Agent.getAgentName() + " has left the system"); // This will be replaced by UI display
	}
}