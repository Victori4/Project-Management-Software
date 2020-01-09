package dit092;

import java.util.ArrayList;

public class Team {
	private int id;
	private ArrayList <TeamMember> members;


	public Team (int id, ArrayList<TeamMember> members) {
		this.id = id;
		this.members = members;
	}

	/**
	* returns the total salary of all members on the team using an enhanced for loop
	* @param members
	* @return SEK total team salary
	*/
	public double calculateTotalTeamSalary (ArrayList <TeamMember> members) {
		double sum = 0;

		for (TeamMember member : members) {
			sum = sum + member.calculateSalary();
		}
		return sum;
	}

	/**
	* returns the total time spent on the project for every member of the team
	* @param members
	* @return hours total team time spent
	*/
	public double calculateTotalTeamTimeSpent(ArrayList <TeamMember> members) {
		double totalTime = 0;
		for (TeamMember member : members) {
			totalTime = totalTime + member.retrieveTimeSpent();
		}
		return totalTime;
	}

	/**
	* returns team member by iterating through the arraylist with an enhanced for-loop to find the one with the correct ID.
	* @param id
	* @return id
	* @throws Exception if ID does not exist
	*/
	public TeamMember findTeamMember(int id) throws Exception {
		for (TeamMember oneMember : members) {
			if (oneMember.getId() == id) {
				return oneMember;
			}
		}
		throw new Exception("Couldn't find team member of ID" + id);
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
	 * Returns all members' tasks.
	 * Allows duplicate tasks.
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