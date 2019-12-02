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
		
		/*total salary of all members on this team using classic for loop in case enhanced does not work
		public double totalSalary (ArrayList <TeamMember> members) {
			double sum = 0;
			for (int i =0; i < members.size(); i++) {
				sum = sum + members.get(i).calculateSalary(members.get(i).getTimeSpent());
			}
			return sum;
		}
		*/
		
//total time spent of all members using enhanced for loop
		public double totalTimeSpent() {
			double totalTime = 0;
			for (TeamMember member : members) {
				totalTime = totalTime + member.getTimeSpent();
			}
			return totalTime;
		}
		
		/*Total time spent by whole team on project using classic for loop in case enhanced does not work
		public double totalTimeSpent() {
			double totalTime = 0;
			for (int i =0; i < members.size(); i++) {
				totalTime = totalTime + members.get(i).getTimeSpent();
			}
			return totalTime;
		}*/
		
		//Finding a team member by iterating through the arraylist with an enhanced for-loop to find the one with the correct ID. 
		//Tried with a try/catch-block but I am not sure if it actually works...
		public TeamMember findTeamMember(int id) {
			for (TeamMember oneMember : members) {
				try {
				if (oneMember.getId() == id) {
					return oneMember;
				}
				}
				catch (Exception e) {
					System.out.println("A member with ID " + id + " does not exist."); 
				}
			}
			return null;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public ArrayList<TeamMember> getMembers() {
			return members;
		}

		public void setMembers(ArrayList<TeamMember> members) {
			this.members = members;
		}
		
	}

