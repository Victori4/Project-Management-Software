package dit092;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public int showStartMenu() {
		System.out.println();
        System.out.println(" === Welcome to The Project Management System === ");
    	System.out.println(" Please choose from options 1-17 below: ");
    	System.out.println(" ");
    	System.out.println(" 1.  "); // this appears to be redundant. We need to do something with it/about it.
    	System.out.println(" 2. See earned value calculations");
    	System.out.println(" 3. Calculate the schedule variance of the project ");
    	System.out.println(" 4. Calculate the cost variance of the project ");
    	System.out.println(" 5. Calculate the planned value for 2-week intervals");
     	System.out.println(" 6. Calculate the actual cost of the project ");
    	System.out.println(" 7. Calculate the budget at completion for the project ");
    	System.out.println(" 8. Calculate the cost performance index ");
    	System.out.println(" 9. Calculate the schedule performance index ");
    	System.out.println(" 10. View the risk matrix for the project ");
    	System.out.println(" 11. View the project schedule");
    	System.out.println(" 12. Search for a team member by their ID to see their time spent on the project ");
    	System.out.println(" 13. Search for team member by their ID to see which tasks they worked on ");
    	System.out.println(" 14. View the total team salary ");
    	System.out.println(" 15. View the total time spent on the project ");
    	System.out.println(" 16. View the time spent on the project by all team members ");
    	System.out.println(" 17. View all team members' salaries ");
    	

    	System.out.println(" 0. Quit this program. ");
		System.out.println();
        return scanner.nextInt();
    }

    public void showEarnedValueHeader() {
		System.out.println(" === Earned Value === ");
	}

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
    
    public int showScheduleVariance(double sv) {
    	System.out.println("Schedule variance: " + sv);
    	return scanner.nextInt();
    }
    
    public int showCostVariance(double cv) {
    	System.out.println("Cost variance: " + cv);
    	return scanner.nextInt();
    }
    
//prints time spent on project per team member 
  	public int showTimeSpentAllMembers (ArrayList<TeamMember> members) {
  		for (TeamMember member : members) {
  		System.out.println(member + ": " + member.retrieveTimeSpent() + System.lineSeparator());
  		}
  		return scanner.nextInt();
  	}
  	
  	//supposed to print all members' salaries. Don't know if this works!! Please change if you can see it's wrong. 
  	public int showSalaryAllMembers (ArrayList<TeamMember> teamMembers, double timeSpent) {
  		for (TeamMember member: teamMembers) {
  			System.out.println(member + ": " + member.calculateSalary(timeSpent) + System.lineSeparator());
  		}
  		return scanner.nextInt();
  	}
  		

	public int promptUserInputInt() {
		System.out.print("Please input an ID: ");
		return scanner.nextInt();
	}	
}
