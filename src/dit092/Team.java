package dit092;

	import java.util.ArrayList;

	public class Team {
		private int id;
		private ArrayList <TeamMember> members;
		
		
		public Team (int id, ArrayList<TeamMember> members) {
			this.id = id;
			this.members = members;
		}
		
		
	//Weak attempt at calculating time spent on project per team member - iterate through array and print every member with 
		//their corresponding time spent, don't think printing should be here?
		public void displayTimeSpentPerMember () {
			for (TeamMember member : members) {
			System.out.println(member + ": " + member.getTimeSpent() + System.lineSeparator());
			}
		}
		
//total salary of all members on this team using enhanced for loop
		public double calculateTotalSalary (ArrayList <TeamMember> members) {
		double sum = 0;
		for (TeamMember member : members) {
		sum = sum + member.calculateSalary(member.getTimeSpent());
		}
		return sum;
		}
		

//total time spent of all members using enhanced for loop
		public double calculateTotalTimeSpent(ArrayList <TeamMember> members) {
			double totalTime = 0;
			for (TeamMember member : members) {
				totalTime = totalTime + member.getTimeSpent();
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
		
		//method to allow searching for specific member and displaying their time spent
		public double findMemberTimeSpent(int id) {
			for (TeamMember oneMember : members) {
				if (oneMember.getId() == id) {
					return oneMember.getTimeSpent();
				}
			}
			return 0;
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
	
	}

