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
	 * Returns the budgeted cost of work performed, for the week specified in the params, by adding up all estimated/
	 * budgeted hours for each task that is started before that week (the week specified is included).
	 *
     * @return double Earned Value
     */
    public double calculateEarnedValue(int week) {
        double totalEstimatedHours = 0;

        for (Task task : tasks) {
        	//If statement needs testing to see if it includes the correct weeks.
			//Should be all tasks started before the week and the actual week and all tasks completed before that week
			//and during that week
            if (task.getActualStartWeek() <= week && task.getActualEndWeek() <= week) {
				totalEstimatedHours = totalEstimatedHours + task.getEstimatedHours();
            }
        }

        return totalEstimatedHours * TeamMember.HOURLY_RATE;
    }

    //According to a website, actual cost is just how much has been spent until that certain point.
    //Leaving it as this for now because I cannot figure out how to finish it...
    public double calculateActualCost () {
    	double actualCost = 0.0;
    	
    	for (Task task : tasks) {
    		actualCost = task.getActualHours() * TeamMember.HOURLY_RATE;
    	}
    	return actualCost;
    }

	public double calculateBudgetAtCompletion() {

		double budgetAtCompletion = 0.0;
		for (Task task : tasks) {
			budgetAtCompletion = budgetAtCompletion + (task.getEstimatedHours() * TeamMember.HOURLY_RATE);
		}
		return budgetAtCompletion;
	}

	public double calculateCostPerformanceIndex (int week) {
		double cPI = calculateEarnedValue(week)/calculateActualCost();
		return cPI;
	}
	
	public double calculateCostVariance(int week) {
		double cv = calculateEarnedValue(week) - calculateActualCost();
		return cv;		
	}
	
	public double calculateScheduleVariance (int week) {
		double sv = calculateEarnedValue(week) - calculatePlannedValue(week);

		return sv;
	}
	
	//I don't know if this is the right thing to but I put down what I have so far

	public double calculateSchedulePerformanceIndex(int week) {
		double sPI = calculateEarnedValue(week) / calculatePlannedValue(week);
		return sPI;
	}
 
}
