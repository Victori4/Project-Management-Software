package dit092;

import java.util.ArrayList;

public class TeamMember {
	
	private int id;
	private String name;
	private double timeSpent;
	private static final double HOURLY_RATE = 250; //public?
	private ArrayList<Task> tasks;
	
	public TeamMember (int id, String name, double timeSpent, ArrayList<Task> tasks) {
		this.id = id;
		this.name = name;
		this.timeSpent = timeSpent;
		this.tasks = tasks;
	}

	public double calculateSalary(double timeSpent) {
		double salary = timeSpent * HOURLY_RATE;
		return salary;
	}

	/**
	 * Validate parameters for the set methods & throw exceptions where neeeded
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
	public double getTimeSpent() {
		return timeSpent;
	}
	public void setTimeSpent(double timeSpent) {
		this.timeSpent = timeSpent;
	}
	public static double getHOURLY_RATE() {
		return HOURLY_RATE;
	}
	
	public String getTaskString() {
		String allTasks = "";
		for (Task task : tasks) {
			allTasks = allTasks + task.getTaskName() + "\n";
		}
		return allTasks;
	}
	
	public String toString() {
		return "ID: " + getId() + "\nName: " + getName() + "\nHours worked: " + getTimeSpent() + 
				"\nActivities worked on:" + getTaskString();
	}
}
