class NeutralAgent {
	String AgentName;
	File[] Target;
	File[] Own;
	int Satisfaction = 10; // Or something, I don't know.
	
	public String getAgentName()
	{
		return this.AgentName;
	}
	
	public void setAgentName(String newAgentName)
	{
		this.AgentName = newAgentName;
	}
	
	public void SendRequest(NeutralAgent[] ExistingAgents) {
		int rand =  (int)(Math.random()*ExistingAgents.length);
		int rand2 = (int)(Math.random()*Target.length);
		NeutralAgent Agent = ExistingAgents[rand];
		ManagerAgent.ProcessSendRequest(NeutralAgent.this, Target[rand2], Agent);
	}
	
	public void RecieveRequest(File File, NeutralAgent Sender) {
		boolean exists = Arrays.asList(Own).contains(File);
		if (exists = true){
			ManagerAgent.ProcessAccept(Sender, File, NeutralAgent.this);
		}
		else {
			ManagerAgent.ProcessReject(Sender, File, NeutralAgent.this);
		}
	}

	public void RecieveAccept(File File) {
		File = Target[Target.length + 1];
		++Satisfaction;
	}
	
	public void RecieveReject() {
		--Satisfaction;
		if(Satisfaction < 0){
			TerminateAgent();
		}
	}
	public void TerminateAgent() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		ManagerAgent.UnSubscribe(this);
	}
}