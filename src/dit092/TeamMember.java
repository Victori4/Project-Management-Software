package dit092;

import java.util.ArrayList;

public class TeamMember {
	
	private int id;
	private String name;
	public static final double HOURLY_RATE = 250;
	private ArrayList<Task> tasks;
	
	public TeamMember(int id, String name, ArrayList<Task> tasks) {
		this.id = id;
		this.name = name;
		this.tasks = tasks;
	}

	/** 
	 * method for calculating the team members' salaries
	 *@param timeSpent
	 *@return salary
	 */
	public double calculateSalary(double timeSpent) {
		double salary = timeSpent * HOURLY_RATE;
		return salary;
	}

	/**
	 * Validate parameters for the set methods & throw exceptions where needed
	 */
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}
	
	/**
	 * method for retrieving the time spent to be used in calculateSalary
	 *@return timeSpent
	 */
	public double retrieveTimeSpent() {
		double timeSpent = 0.0;
		
		for (Task task : tasks) {
			timeSpent = timeSpent + task.getActualHours();
		}
		return timeSpent;
	}
	
	public String getTaskString() {
		String allTasks = "";
		for (Task task : tasks) {
			allTasks = allTasks + task.getTaskName() + "\n";
		}
		return allTasks;
	}
	
	public String toString() {
		return "ID: " + getId() + "\nName: " + getName() + "\nHours worked: " + retrieveTimeSpent() + 
				"\nActivities worked on:" + getTaskString();
	}
}
