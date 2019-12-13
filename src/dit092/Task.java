package dit092;

import java.util.ArrayList;

public class Task {
    private String id;
    private String taskName;
    private int weekSaved; //Stats for the week, do we need this?
    private int plannedStartWeek;
    private int actualStartWeek;
    private int plannedEndWeek;
    private int actualEndWeek;
    private double estimatedHours; //Estimated/budgeted hours
    private double actualHours; //Actual work spent on this task
    private ArrayList<TeamMember> teamMembersWorked;

    public Task(String id, String taskName, int weekSaved, int plannedStartWeek, int actualStartWeek, int plannedEndWeek,
                int actualEndWeek, double estimatedHours, double actualHours, ArrayList<TeamMember> teamMembersWorked) {
        this.id = id;
        setTaskName(taskName);
        setWeekSaved(weekSaved);
        setPlannedStartWeek(plannedStartWeek);
        setActualStartWeek(actualStartWeek);
        setPlannedEndWeek(plannedEndWeek);
        setActualEndWeek(actualEndWeek);
        setEstimatedHours(estimatedHours);
        setActualHours(actualHours);
        setTeamMembersWorked(teamMembersWorked);
    }

    public String getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getWeekSaved() {
        return weekSaved;
    }

    public void setWeekSaved(int weekSaved) {
        this.weekSaved = weekSaved;
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

    public ArrayList<TeamMember> getTeamMembersWorked() {
        return teamMembersWorked;
    }

    public void setTeamMembersWorked(ArrayList<TeamMember> teamMembersWorked) {
        this.teamMembersWorked = teamMembersWorked;
    }
    
    public double calculateTotalPlannedHours() {
    	double totalHours = estimatedHours * this.calculateTotalPlannedWeeks();
    	return totalHours;
    }

    public int calculateTotalPlannedWeeks() {
    	int totalWeeks = (plannedEndWeek + plannedStartWeek) + 1;
    	return totalWeeks;
    }
    
    public double calculatePlannedCost() {
    	int teamSize = teamMembersWorked.size();
    	double plannedCost = teamSize * TeamMember.getHOURLY_RATE();
    	
    	return plannedCost;
    }
}
