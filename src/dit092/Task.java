package dit092;

import java.util.Objects;

/**
 * A representation of a task with ID, name and both planned/actual start/end weeks
 */
public class Task implements Comparable<Task> {
    private String ID;
    private String taskName;
    private int plannedStartWeek;
    private int actualStartWeek;
    private int plannedEndWeek;
    private int actualEndWeek;
    private double estimatedHours; //Estimated/budgeted hours
    private double actualHours; //Actual hours spent on this task

    /**
     * Creates a task
     * @param ID The ID of the task
     * @param taskName A name/short descriptor of the task
     * @param plannedStartWeek The week the task was planned to start
     * @param actualStartWeek The actual week the task was started
     * @param plannedEndWeek The week the task was planned to be done
     * @param actualEndWeek The actual week the task was completed
     * @param estimatedHours The total amount of estimated/scheduled hours for the task
     * @param actualHours The actual amount of hours the task took to complete
     */
    public Task(String ID, String taskName, int plannedStartWeek, int actualStartWeek, int plannedEndWeek,
                int actualEndWeek, double estimatedHours, double actualHours) {
        setID(ID);
        setTaskName(taskName);
        setPlannedStartWeek(plannedStartWeek);
        setActualStartWeek(actualStartWeek);
        setPlannedEndWeek(plannedEndWeek);
        setActualEndWeek(actualEndWeek);
        setEstimatedHours(estimatedHours);
        setActualHours(actualHours);
    }

    /**
     * Calculates the planned cost of the task, based on a Team Members salary
     */
    public double calculatePlannedCost() {
    	double plannedCost = estimatedHours * TeamMember.HOURLY_RATE;
    	return plannedCost;
    }

    /**
     * Calculates the actual cost of the task, based on a Team Members salary
     */
    public double calculateActualCost() {
        double actualCost = actualHours * TeamMember.HOURLY_RATE;
        return actualCost;
    }
    
    public String getID() {
        return ID;
    }
    
    public void setID(String ID) {
    	this.ID = ID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getPlannedStartWeek() {
        return plannedStartWeek;
    }

    public void setPlannedStartWeek(int plannedStartWeek) {
        this.plannedStartWeek = plannedStartWeek;
    }

    public int getActualStartWeek() {
        return actualStartWeek;
    }

    public void setActualStartWeek(int actualStartWeek) {
        this.actualStartWeek = actualStartWeek;
    }

    public int getPlannedEndWeek() {
        return plannedEndWeek;
    }

    public void setPlannedEndWeek(int plannedEndWeek) {
        this.plannedEndWeek = plannedEndWeek;
    }

    public int getActualEndWeek() {
        return actualEndWeek;
    }

    public void setActualEndWeek(int actualEndWeek) {
        this.actualEndWeek = actualEndWeek;
    }

    public double getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(double estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public double getActualHours() {
        return actualHours;
    }

    public void setActualHours(double actualHours) {
        this.actualHours = actualHours;
    }

	@Override
	public String toString() {
		return  "Start week: " + getPlannedStartWeek() + " End week: " + getPlannedEndWeek() + "    ID: " + getID() + " Task: " + getTaskName();
	}

	@Override
	public int compareTo(Task otherTask) {
		return this.getID().compareTo(otherTask.getID());
	}

    /**
     * A task is considered equal to another task when they have the same ID
     * @param o The object to compare to
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return ID.equals(task.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
