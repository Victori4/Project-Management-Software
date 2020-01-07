package dit092;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

	/**
	 * Prints all of the menu options and reads the users choice.
	 * @return int
	 */
	public int showStartMenu() {
		System.out.println();
        System.out.println(" === Welcome to The Project Management System === ");
    	System.out.println(" Please choose from options 0-16 below: ");
    	System.out.println(" ");
    	System.out.println(" 1. Calculate the earned value for 2-week intervals");
    	System.out.println(" 2. Calculate the schedule variance for 2-week intervals");
    	System.out.println(" 3. Calculate the cost variance for 2-week intervals");
    	System.out.println(" 4. Calculate the planned value for 2-week intervals");
     	System.out.println(" 5. Calculate the actual cost of the project");
    	System.out.println(" 6. Calculate the budget at completion for the project");
    	System.out.println(" 7. Calculate the cost performance index");
    	System.out.println(" 8. Calculate the schedule performance index");
    	System.out.println(" 9. View the risk matrix for the project");
    	System.out.println(" 10. View the project schedule");
    	System.out.println(" 11. Search for a team member by their ID to see their time spent on the project");
    	System.out.println(" 12. Search for a team member by their ID to see which tasks they worked on");
    	System.out.println(" 13. View the total team salary");
    	System.out.println(" 14. View the total time spent on the project");
    	System.out.println(" 15. View each team members' time spent on the project");
    	System.out.println(" 16. View all team members' salaries");

    	System.out.println(" 0. Quit this program. ");
		System.out.println("\nOption number: ");
        return scanner.nextInt();
    }

	/**
	 * Prints EV header.
	 */
	public void showEarnedValueHeader() {
		System.out.println(" === Earned Value for 2-week intervals === ");
	}

	/**
	 * Prints EV for a specific week.
	 * @param week int
	 * @param ev double in SEK
	 */
    public void showEarnedValue(int week, double ev) {
        if (week > 9) {
        	System.out.println("Week: " + week + "       EV: " + String.format(Locale.ROOT, "%.2f", ev) + " SEK.");
        }
        else {
        	System.out.println("Week: " + week + "        EV: " + String.format(Locale.ROOT, "%.2f", ev) + " SEK.");
        }
    }

    public void showDefault() {
        System.out.println("Please try again!");
    }

	/**
	 * Print CPI header.
	 */
	public void showCostPerformanceIndexHeader() {
		System.out.println(" === Cost Performance Index for 2-week intervals === ");
	}

	/**
	 * Prints CPI for a specific week.
	 * @param cpi double
	 * @param week int
	 */
	//Go rid of % since CPI and SPI are ratios, not percentages.
	public void showCostPerformanceIndex(int week, double cpi) {
		if (week > 9) {
			System.out.println("Week: " + week + "       CPI: " + cpi);
		}
		else {
			System.out.println("Week: " + week + "        CPI: " + cpi);
		}
	}

//prints total team salary
    public void showTotalTeamSalary (double totalSal) {
    	System.out.print("Total Salary: " + String.format(Locale.ROOT, "%.2f", totalSal) + " SEK");
    }
    
//prints the total time spent on project
    public void showTotalTeamTime (double totalTime) {
    	System.out.print("Total time spent: " + totalTime + " hrs");
    }

	/**
	 * Print SPI header.
	 */
	public void showSchedulePerformanceIndexHeader() {
		System.out.println(" === Schedule Performance Index for 2-week intervals === ");
	}

	/**
	 * Prints SPI for a specific week.
	 * @param spi double
	 * @param week int
	 */
	public void showSchedulePerformanceIndex(int week, double spi) {
		if (week > 9) {
			System.out.println("Week: " + week + "       SPI: " + spi);
		}
		else {
			System.out.println("Week: " + week + "        SPI: " + spi);
		}
	}
    
    public void showBudgetAtCompletion(double bac) {
    	System.out.print("Budget at completion: " + String.format(Locale.ROOT, "%.2f", bac) + " SEK");
    }

    /**
     * Prints which tasks a certain member has worked on
     * @param member TeamMember
     */
	public void showTeamMemberActivitiesById(TeamMember member) {
		//CHANGED: added a header
		System.out.println(" === Activities worked on by " + member.getName() + " === ");

		//CHANGED: added a loop which loops through members tasks to print them nicely
		for (Task task : member.getTasks()) {
			System.out.println(task); //Uses the toString() method in Task
		}
	}
	
//prints time spent on project by certain member
	public void showMemberTimeById(Team team, int id) {
		System.out.println(id + ": " + team.findMemberTimeById(id) + " hrs");
		}


    public void showActualCost(double ac) {
    	System.out.println("Actual cost: " + String.format(Locale.ROOT, "%.2f", ac) + " SEK");
    }

    /**
	 * Prints SV header.
     */
	public void showScheduleVarianceHeader() {
		System.out.println(" === Schedule Variance for 2-week intervals === ");
	}

	/**
	 * Prints SV for a specific week.
	 * @param week int
	 * @param sv double
	 */
    public void showScheduleVariance(int week, double sv) {
		if (week > 9) {
			System.out.println("Week: " + week + "       SV: " + String.format(Locale.ROOT, "%.2f", sv) + " SEK.");
		}
		else {
			System.out.println("Week: " + week + "        SV: " + String.format(Locale.ROOT, "%.2f", sv) + " SEK.");
		}
    }

	/**
	 * Print CV header.
	 */
	public void showCostVarianceHeader() {
		System.out.println(" === Cost Variance for 2-week intervals === ");
	}

	/**
	 * Prints CV for a specific week.
	 * @param week int
	 * @param cv double
	 */
	public void showCostVariance(int week, double cv) {
		if (week > 9) {
			System.out.println("Week: " + week + "       CV: " + String.format(Locale.ROOT, "%.2f", cv) + " SEK.");
		}
		else {
			System.out.println("Week: " + week + "        CV: " + String.format(Locale.ROOT, "%.2f", cv) + " SEK.");
		}
	}

	/**
	 * Print PV header.
	 */
	public void showPlannedValueHeader() {
		System.out.println(" === Planned Value for 2-week intervals === ");
	}

	/**
	 * Prints PV for a specific week.
	 * @param week int
	 * @param pv double
	 */
	public void showPlannedValue(int week, double pv) {
		if (week > 9) {
			System.out.println("Week: " + week + "       PV: " + String.format(Locale.ROOT, "%.2f", pv) + " SEK.");
		}
		else {
			System.out.println("Week: " + week + "        PV: " + String.format(Locale.ROOT, "%.2f", pv) + " SEK.");
		}
	}
    
//prints time spent on project per team member 
  	public void showTimeSpentAllMembers (ArrayList<TeamMember> members) {
  		for (TeamMember member : members) {
  		System.out.println(member + ": " + member.retrieveTimeSpent() + " hrs" + System.lineSeparator());
  		}
  	}

	/**
	 * Takes a list of TeamMembers and prints their salaries.
	 * @param teamMembers ArrayList
	 */
	public void showSalaryAllMembers (ArrayList<TeamMember> teamMembers) {
		//Added this so we have a header for the method, EV has the same
		System.out.println(" === Team Members' Salaries === ");

  		for (TeamMember member: teamMembers) {
  			//CHANGES: member.getName() to get the name instead of the toString().
			//Changed the calculateSalary() method in TeamMember so it doesn't take timeSpent anymore.
			//Added SEK at the end for "style"..
  			System.out.println(member.getName() + ": " + String.format(Locale.ROOT, "%.2f", member.calculateSalary()) + " SEK. " + System.lineSeparator());
  		}
  	}

	/**
	 * Prompts user to input an ID.
	 * @return int
	 */
	public int promptUserInputInt() {
		System.out.print("Please input an ID: ");
		return scanner.nextInt();
	}

	/**
	 * Shows a message to be displayed when exiting the software.
	 */
	public void showExitMessage() {
		System.out.println("Thank you for using The Project Management System.");
	}
}
