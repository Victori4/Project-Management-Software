package dit092;

import java.util.ArrayList;

public class Project {

    private ArrayList<Task> tasks;
    private Team team;

    public Project(ArrayList<Task> tasks, Team team) {
        this.tasks = tasks;
        this.team = team;
    }

    /**
     * Making sure it compiles! Please feel free to finish the method and edit this comment!
     * @return
     */
    public double calculatePlannedValue() {
        return 0;
    }

    /**
     * Budgeted Cost of Work Performed.
     * Needs to calculate every 2 weeks: 3, 5, 7, 9, 11? Combine week 1 & 2?
     * Call it from somewhere where input is every 2 weeks for the entire project?
     * Also is it every 2 weeks EV or the EV for the entire project but every 2 weeks?
     *
     * @return double Earned Value
     */
    public double calculateEarnedValue(int firstWeekToCompare, int lastWeekToCompare) {
        double ev = 0;

        for (Task task : tasks) {
            //Not sure if this if statement is correct
            if (task.getStartWeek() >= firstWeekToCompare && task.getStartWeek() <= lastWeekToCompare) {
                ev = ev + (task.getPercentageDone() * (task.getEstimatedHours() * TeamMember.getHOURLY_RATE()));
            }
        }

        return ev;
    }

    //According to a website, actual cost is just how much has been spent until that certain point. 
    public double actualCost () {
    	
    	return 0;
    }

	public double calculateBudgetAtCompletion() {

		double budgetAtCompletion = 0.0;
		for (Task task : tasks) {
			budgetAtCompletion = budgetAtCompletion + task.getAnticipatedBudget();
		}
		return budgetAtCompletion;
	}


 
}
