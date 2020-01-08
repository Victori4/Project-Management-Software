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
		//CHANGED: removed timeSpent from calculateSalary() in TeamMember
		public double calculateTotalTeamSalary (ArrayList <TeamMember> members) {
			double sum = 0;

			for (TeamMember member : members) {
					sum = sum + member.calculateSalary();
				}
			return sum;
		}
		

//total time spent of all members using enhanced for loop
		public double calculateTotalTeamTimeSpent(ArrayList <TeamMember> members) {
			double totalTime = 0;
			for (TeamMember member : members) {
				totalTime = totalTime + member.retrieveTimeSpent();
			}
			return totalTime;
		}
		
		
		//Finding a team member by iterating through the arraylist with an enhanced for-loop to find the one with the correct ID. 
		public TeamMember findTeamMember(int id) {
			for (TeamMember oneMember : members) {
				if (oneMember.getId() == id) {
					return oneMember;
				}
			}
			return null;
		}	
		
		public int getId() {
			return id;
		}


		public ArrayList<TeamMember> getMembers() {
			return members;
		}

		public void setMembers(ArrayList<TeamMember> members) {
			this.members = members;
		}

		/**
		 * TODO TEST AND CLEANUP THIS ALLOWS DUPLICATE TASKS
		 * @return ArrayList Tasks
		 */
		public ArrayList<Task> getTasks() {
			ArrayList<Task> tasks = new ArrayList<Task>();

			for (TeamMember member : members) {
				tasks.addAll(member.getTasks());
			}

			return tasks;
		}
	
	}

