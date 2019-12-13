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
     * @return double Planned Value
     * TODO Ella
     */
    public double calculatePlannedValue(int week) {
    	double plannedValue = 0;
    	
    	/* ArrayList<Task> plannedTasks = new ArrayList<Task>();
    	ArrayList<Task> unfinishedTasks = new ArrayList<Task>();
    	ArrayList<Task> finishedTasks = new ArrayList<Task>();
        
    	//Collects all the tasks that are planned to be started at  param week
    	for (Task task : tasks) {
        	if (task.getPlannedStartWeek() <= week) {
        		plannedTasks.add(task);
        	}
        }
    	*/
    	
    	//Collects all the tasks that are planned to be finished by param week
    	for (Task task : tasks) {
    		if (task.getPlannedEndWeek() <= week) {
    			plannedValue = plannedValue + task.calculatePlannedCost();
    		}
    	}
    	
    	return plannedValue;
    }

    /**
	 * Returns the budgeted cost of work performed, for the weeks specified in the params, by adding up all estimated/
	 * budgeted hours for each task that is started within the specified weeks.
	 *
     * @return double Earned Value
     */
    public double calculateEarnedValue(int firstWeekToCompare, int lastWeekToCompare) {
        double totalEstimatedHours = 0;

        for (Task task : tasks) {
        	//Perhaps remove the last = depending on if we want the last week to be included or not
            if (task.getActualStartWeek() >= firstWeekToCompare && task.getActualStartWeek() <= lastWeekToCompare) {
				totalEstimatedHours = totalEstimatedHours + task.getEstimatedHours();
            }
        }

        return totalEstimatedHours * TeamMember.getHOURLY_RATE();
    }

    //According to a website, actual cost is just how much has been spent until that certain point.
    //Leaving it as this for now because I cannot figure out how to finish it...
    public double calculateActualCost () {
    	double actualCost = 0.0;
    	
    	for (Task task : tasks) {
    		actualCost = task.getActualHours() * TeamMember.getHOURLY_RATE();
    	}
    	return actualCost;
    }

	public double calculateBudgetAtCompletion() {

		double budgetAtCompletion = 0.0;
		for (Task task : tasks) {
			budgetAtCompletion = budgetAtCompletion + (task.getEstimatedHours() * TeamMember.getHOURLY_RATE());
		}
		return budgetAtCompletion;
	}

	public double calculateCostPerformanceIndex (int firstWeekToCompare, int lastWeekToCompare) {
		double cPI = calculateEarnedValue(firstWeekToCompare, lastWeekToCompare)/calculateActualCost();
		return cPI;
	}
	
	public double calculateCostVariance(int firstWeekToCompare, int lastWeekToCompare) {
		double cv = calculateEarnedValue(firstWeekToCompare, lastWeekToCompare) - calculateActualCost();
		return cv;		
	}
	
	public double calculateScheduleVariance (int firstWeekToCompare, int lastWeekToCompare) {
		double sv = calculateEarnedValue(firstWeekToCompare, lastWeekToCompare) - calculatePlannedValue(lastWeekToCompare);
		return sv;
	}
	
	//I don't know if this is the right thing to but I put down what I have so far
	public double calculateSchedulePerformanceIndex(int startWeek, int endWeek) {
		double sPI = calculateEarnedValue(startWeek, endWeek) / calculatePlannedValue(endWeek);
		return sPI;
	}
 
}
