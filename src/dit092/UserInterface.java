package dit092;

import java.util.ArrayList;
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
    	System.out.println(" Please choose from options 1-17 below: ");
    	System.out.println(" ");
    	System.out.println(" 1. Calculate the earned value for 2-week intervals");
    	System.out.println(" 2. Calculate the schedule variance for 2-week intervals");
    	System.out.println(" 3. Calculate the cost variance for 2-week intervals");
    	System.out.println(" 4. Calculate the planned value for 2-week intervals");
     	System.out.println(" 5. Calculate the actual cost of the project ");
    	System.out.println(" 6. Calculate the budget at completion for the project ");
    	System.out.println(" 7. Calculate the cost performance index ");
    	System.out.println(" 8. Calculate the schedule performance index ");
    	System.out.println(" 9. View the risk matrix for the project ");
    	System.out.println(" 10. View the project schedule");
    	System.out.println(" 11. Search for a team member by their ID to see their time spent on the project ");
    	System.out.println(" 12. Search for team member by their ID to see which tasks they worked on ");
    	System.out.println(" 13. View the total team salary ");
    	System.out.println(" 14. View the total time spent on the project ");
    	System.out.println(" 15. View the time spent on the project by all team members ");
    	System.out.println(" 16. View all team members' salaries ");

    	System.out.println(" 0. Quit this program. ");
		System.out.println();
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
        System.out.println("Week: " + week + "        EV: " + ev + " SEK.");
    }

    public void showDefault() {
        System.out.println("Please try again!");
    }
//prints the Cost Performance Index    
    public int showCostPerformanceIndex(double CPI) {
    	System.out.print("Cost Performance Index: " + CPI);
    	return scanner.nextInt();
    }
//prints total team salary
    public int showTotalTeamSalary (double totalSal) {
    	System.out.print("Total Salary: " + totalSal);
    	return scanner.nextInt();
    }
//prints the total time spent on project
    public int showTotalTeamTime (double totalTime) {
    	System.out.print("Total time spent: " + totalTime);
    	return scanner.nextInt();
    }
    
    public int showSchedulePerformanceIndex(double spi) {
    	System.out.print("Schedule Performance Index: " + spi);
    	return scanner.nextInt();
    }
    
    public int showBudgetAtCompletion(double bac) {
    	System.out.print("Budget at completion: " + bac);
    	return scanner.nextInt();
    }

    /**
     * Prints which tasks a certain member has worked on
     * @param team
     * @param id
     * @return
     */
	public int showTeamMemberActivitiesById(Team team, int id) {
		System.out.println(id + ": " + team.getTasks()); 
		return scanner.nextInt();
	}
	
//prints time spent on project by certain member
	public int showMemberTimeById(Team team, int id) {
		System.out.println(id + ": " + team.findMemberTimeById(id));
	  	return scanner.nextInt();
		}


    public int showActualCost(double ac) {
    	System.out.println("Actual cost: " + ac);
    	return scanner.nextInt();
    }

    /**
	 * Prints SV header.
     */
	public void showScheduleVarianceHeader() {
		System.out.println(" === Schedule Variance for 2-week intervals === ");
	}

	/**
	 * Prints SV for a specific week.
	 * @param sv double
	 */
    public void showScheduleVariance(int week, double sv) {
		System.out.println("Week: " + week + "        SV: " + sv + " SEK.");
    }

	/**
	 * Print CV header.
	 */
	public void showCostVarianceHeader() {
		System.out.println(" === Cost Variance for 2-week intervals === ");
	}

	/**
	 * Prints CV for a specific week.
	 * @param cv double
	 */
	public void showCostVariance(int week, double cv) {
		System.out.println("Week: " + week + "        CV: " + cv + " SEK.");
	}

	/**
	 * Print PV header.
	 */
	public void showPlannedValueHeader() {
		System.out.println(" === Planned Value for 2-week intervals === ");
	}

	/**
	 * Prints PV for a specific week.
	 * @param pv double
	 */
	public void showPlannedValue(int week, double pv) {
		System.out.println("Week: " + week + "        PV: " + pv + " SEK.");
	}
    
//prints time spent on project per team member 
  	public int showTimeSpentAllMembers (ArrayList<TeamMember> members) {
  		for (TeamMember member : members) {
  		System.out.println(member + ": " + member.retrieveTimeSpent() + System.lineSeparator());
  		}
  		return scanner.nextInt();
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
  			System.out.println(member.getName() + ": " + member.calculateSalary() + " SEK. " + System.lineSeparator());
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
	 * Shows a goodbye message to be displayed when exiting the software.
	 */
	public void showExitMessage() {
		System.out.println("Thank you for using the Project Management Software, bye!");
	}
}
