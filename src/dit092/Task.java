package dit092;

public class Task {
    private int startWeek;
    private int endWeek;
    private double percentageDone; //% completed, needed for EV
    private double estimatedHours; //Estimated/budgeted hours
    private double hoursSpentOn; //Actual work spent on this task
    private double anticipatedBudget;

    public Task(int startWeek, int endWeek, double percentageDone, double estimatedHours, double hoursSpentOn, double anticipatedBudget) {
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.percentageDone = percentageDone;
        this.estimatedHours = estimatedHours;
        this.hoursSpentOn = hoursSpentOn;
        this.anticipatedBudget = anticipatedBudget;
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
