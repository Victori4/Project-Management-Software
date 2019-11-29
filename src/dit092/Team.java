package dit092;

	import java.util.ArrayList;

	public class Team {
		private int id;
		private ArrayList <TeamMember> members;
		
		
		public Team (int id, ArrayList<TeamMember> members) {
			this.id = id;
			this.members = members;
		}
		
		
		//total salary of all members on this team using classic for loop
		public double totalSalary (ArrayList <TeamMember> members) {
			double sum = 0;
			for (int i =0; i < members.size(); i++) {
				sum = sum + members.get(i).calculateSalary(members.get(i).getTimeSpent());
			}
			return sum;
		}
		
		//Total time spent by whole team on project using classic for loop
		public double totalTimeSpent() {
			double totalTime = 0;
			for (int i =0; i < members.size(); i++) {
				totalTime = totalTime + members.get(i).getTimeSpent();
			}
			return totalTime;
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

