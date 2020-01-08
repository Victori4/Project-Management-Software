package dit092;

import java.util.ArrayList;

public class Project {

    private Team team;
    private RiskMatrix matrix;

    public Project(Team team, RiskMatrix matrix) {
        this.team = team;
        this.matrix = matrix;
    }

	/**
	 * Gets the last week of the project tasks
	 * @return int endWeek
	 */
	public int getEndWeek() {
    	int endWeek = 0;
    	ArrayList<Task> tasks = team.getTasks();

    	for(Task task : tasks) {
    		if (task.getActualEndWeek() > endWeek) {
    			endWeek = task.getActualEndWeek();
			}
		}

    	return endWeek;
	}

	/**
	 * Gets the first week of the project tasks
	 * @return int startWeek
	 */
	public int getStartWeek() {
		int startWeek = 0;
		ArrayList<Task> tasks = team.getTasks();

		for(Task task : tasks) {
			if (task.getActualStartWeek() < startWeek || startWeek == 0) {
				startWeek = task.getActualStartWeek();
			}
		}

		return startWeek;
	}

	/**
	 * Calculates the total amount of weeks for the project based on the actual end week of tasks and actual start week
	 * @return int totalProjectWeeks
	 */
	public int getTotalProjectWeeks() {
		int totalProjectWeeks = getEndWeek() - getStartWeek() +1; //e.g. 11 - 2 + 1 = 10 weeks of project
		return totalProjectWeeks;
	}

    /**Calculates the planned value
     * @return double Planned Value
     */
    public double calculatePlannedValue(int week) {
    	double plannedValue = 0;
        ArrayList<Task> tasks = team.getTasks();
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
        ArrayList<Task> tasks = team.getTasks();
        
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

    /**
     * returns actual cost of project at a specified week
     * @return the actual cost of the work performed up until @param week
     */
    public double calculateActualCost(int week) {
    	double actualCost = 0.0;
        ArrayList<Task> tasks = team.getTasks();
        
    	for (Task task : tasks) {
    		if(task.getActualEndWeek() <= week) {
				actualCost = actualCost + task.calculateActualCost();
			}
    	}
    	return actualCost;
    }

    /**calculates the Budget at Completion
    * @return SEK Budget at Completion
    */
	public double calculateBudgetAtCompletion() {
		double budgetAtCompletion = 0.0;
        ArrayList<Task> tasks = team.getTasks();

		for (Task task : tasks) {
			budgetAtCompletion = budgetAtCompletion + (task.getEstimatedHours() * TeamMember.HOURLY_RATE);
		}
		return budgetAtCompletion;
	}

/**
 * returns cost performance index by multiplying the earned value with actual cost
 * @param week
 * @return ratio Cost Performance Index
 */
	public double calculateCostPerformanceIndex (int week) {
		double cPI = (calculateEarnedValue(week)/calculateActualCost(week));
		return cPI;
	}
/**
 * returns cost variance by subtracting actual cost from earned value 
 * @param week
 * @return SEK Cost Variance
 */
	public double calculateCostVariance(int week) {
		double cv = calculateEarnedValue(week) - calculateActualCost(week);
		return cv;		
	}
/**returns schedule variance by subtracting planned value from earned value
 * 
 * @param week
 * @return SEK Schedule variance
 */
	public double calculateScheduleVariance (int week) {
		double sv = calculateEarnedValue(week) - calculatePlannedValue(week);

		return sv;
	}
	
/**
 * returns schedule performance index by dividing earned value by planned value
 * @param week
 * @return ratio
 */
	public double calculateSchedulePerformanceIndex(int week) {
		double sPI = (calculateEarnedValue(week) / calculatePlannedValue(week));
		return sPI;
	}

	public Team getTeam() {
		return team;
	}

	public RiskMatrix getRiskMatrix() {
    	return matrix;
	}
 
}
