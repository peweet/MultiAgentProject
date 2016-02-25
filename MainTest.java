class MainTest{
	// This is to test the functionality of the system, which will be replaced by the GUI
	public static void main(String[] args)
	{
		ManagerAgent managerAgent = new ManagerAgent();
		boolean terminated = false;
		int coin = 2; // For flipping.
		String[] Filetypes = {"Movie, Game, MP3, Text"};
		Scanner input = new Scanner(System.in);
		// Files need to be made before Agents. Because I said so, that's why.
		
		System.out.print("Number of Files to be Generated: ");
		int TotalFiles = input.nextInt();
		for (int i=0; i<TotalFiles; i++) {
			File file = new File();
			int rand = (int)(Math.random()*Filetypes.length);
			file.Type = Filetypes[rand];
			file.FileName = file.Type + i;
			managerAgent.ExistingFiles[i] = file;
		}
		
		System.out.println("Number of Agents to be Generated: ");
		int TotalAgents = input.nextInt();
		for(int i=0; i<TotalAgents; i++) {
			int o = 0; // Position of next File in Own
			int t = 0; // Position of next File in Target
			NeutralAgent agent = new NeutralAgent();
			agent.AgentName = "Agent" + i;
			for(int j=0; j<TotalFiles; j++){
				int rand = ((int)Math.random()*coin);
				if(rand == 1){
					agent.Own[o] = managerAgent.ExistingFiles[j];
					o++;
				}
				else{
					agent.Target[t] = managerAgent.ExistingFiles[j];
					t++;
				}
			}
			managerAgent.ActiveAgents[i] = agent;
			
		}
		
		while(terminated  == false) {
			if (managerAgent.ActiveAgents.length != 0) {
				int rand = (int)(Math.random()*managerAgent.ActiveAgents.length);
				managerAgent.ActiveAgents[rand].SendRequest(managerAgent.ActiveAgents);
			}
			else {
				System.out.println("There are no more Agents on the system. Shutting Down...");
			}
			System.out.println("The Program is finished");
		}
		
	}
}