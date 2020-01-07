package dit092;

/*
 * A representation of a task with ID, name and both planned/actual start/end weeks
 *TODO comparable interface
 *TODO fix estimated hours from attribute to calculation
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
     * @param id
     * @param taskName
     * @param plannedStartWeek
     * @param actualStartWeek
     * @param plannedEndWeek
     * @param actualEndWeek
     * @param estimatedHours
     * @param actualHours
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
    
    public double calculateTotalPlannedHours() {
    	double totalHours = estimatedHours * this.calculateTotalPlannedWeeks();
    	return totalHours;
    }

    public int calculateTotalPlannedWeeks() {
    	int totalWeeks = (plannedEndWeek - plannedStartWeek) + 1;
    	return totalWeeks;
    }
    
    //TODO Rewrite method
    public double calculatePlannedCost() {
    /*
    	int teamSize = teamMembersWorked.size();
    	double plannedCost = teamSize * TeamMember.HOURLY_RATE;
    	
    	return plannedCost;
    */
    return 0.0;
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

	/**
	 *TODO toString()
	 */
	@Override
	public String toString() {
		return "ID: " + getID() + " Task: " + getTaskName() + " Start week: "
				+ getPlannedStartWeek() + " End week: " + getPlannedEndWeek();
	}

	@Override
	public int compareTo(Task otherTask) {
		return this.getID().compareTo(otherTask.getID());
	}
    
    

}
