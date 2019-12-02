package dit092;

	import java.util.ArrayList;

	public class Team {
		private int id;
		private ArrayList <TeamMember> members;
		
		
		public Team (int id, ArrayList<TeamMember> members) {
			this.id = id;
			this.members = members;
		}
		
		

//total salary of all members on this team using enhanced for loop
		public double totalSalary (ArrayList <TeamMember> members) {
		double sum = 0;
		for (TeamMember member : members) {
		sum = sum + member.calculateSalary(member.getTimeSpent());
		}
		return sum;
		}
		

//total time spent of all members using enhanced for loop
		public double totalTimeSpent() {
			double totalTime = 0;
			for (TeamMember member : members) {
				totalTime = totalTime + member.getTimeSpent();
			}
			return totalTime;
		}
		
		
		//Finding a team member by iterating through the arraylist with an enhanced for-loop to find the one with the correct ID. 
		//Tried with a try/catch-block but I am not sure if it actually works...
		public TeamMember findTeamMember(int id) {
			for (TeamMember oneMember : members) {
				if (oneMember.getId() == id) {
					return oneMember;
				}
			}
			return null;
		}	
		
		//to string
		
		public int getId() {
			return id;
		}


		public ArrayList<TeamMember> getMembers() {
			return members;
		}

		public void setMembers(ArrayList<TeamMember> members) {
			this.members = members;
		}
	
	}

