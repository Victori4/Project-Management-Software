package dit092;

import java.util.ArrayList;

public class Task {
    private int startWeek;
    private int endWeek;
    private double percentageDone; //% completed, needed for EV
    private double estimatedHours; //Estimated/budgeted hours
    private double hoursSpentOn; //Actual work spent on this task
    private double anticipatedBudget;
    private int id;
    private String taskName;
    private ArrayList<TeamMember> teamMembersWorked;

    public Task(int startWeek, int endWeek, double percentageDone, double estimatedHours, double hoursSpentOn, double anticipatedBudget, int id, String taskName, ArrayList<TeamMember> teamMembersWorked) {
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.percentageDone = percentageDone;
        this.estimatedHours = estimatedHours;
        this.hoursSpentOn = hoursSpentOn;
        this.anticipatedBudget = anticipatedBudget;
        this.id = id;
        this.taskName = taskName;
        this.teamMembersWorked = teamMembersWorked; 
    }

    public int getStartWeek() {
        return startWeek;
    }

    public int getEndWeek() { return endWeek; }

    public double getPercentageDone() {
        return percentageDone;
    }

    public double getEstimatedHours() {
        return estimatedHours;
    }

    public double getHoursSpentOn() {
        return hoursSpentOn;
    }

    public double getAnticipatedBudget() {
    	return anticipatedBudget;
    }
}
