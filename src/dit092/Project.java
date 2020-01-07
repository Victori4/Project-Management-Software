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

    /**
     * Making sure it compiles! Please feel free to finish the method and edit this comment!
     * @return double Planned Value
     * TODO Ella
     */
    public double calculatePlannedValue(int week) {
    	double plannedValue = 0;
        ArrayList<Task> tasks = team.getTasks();

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
     * Calculates actual cost by finding all tasks, adding the actual hours spent for each task times each team member's hourly rate 
     * @return
     */
    public double calculateActualCost () {
    	double actualCost = 0.0;
        ArrayList<Task> tasks = team.getTasks();
        
    	for (Task task : tasks) {
    		actualCost = actualCost + (task.getActualHours() * TeamMember.HOURLY_RATE);
    	}
    	return actualCost;
    }

	public double calculateBudgetAtCompletion() {
		double budgetAtCompletion = 0.0;
        ArrayList<Task> tasks = team.getTasks();

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

	public Team getTeam() {
		return team;
	}
 
}
