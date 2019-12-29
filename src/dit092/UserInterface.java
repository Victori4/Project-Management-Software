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
    	System.out.println(" Choose an option below: ");
    	System.out.println(" ");
    	System.out.println(" 1.  ");
    	System.out.println(" 2. Get Earned Value calculations");
    	System.out.println(" 3. Calculate Schedule Variance. ");
    	System.out.println(" 4. Calculate Cost Variance. ");
    	System.out.println(" 5. ");
     	System.out.println(" 6. Calculate actual cost. ");
    	System.out.println(" 7. Calculate Budget At Completion. ");
    	System.out.println(" 8. Calculate Cost Performance Index. ");
    	System.out.println(" 9. Calculate Schedule Performance Index. ");
    	System.out.println(" 10.  ");
    	System.out.println(" 11. ");
    	System.out.println(" 12. Search team member by ID to see time spent. ");
    	System.out.println(" 13. Search team member by ID to see which tasks the member has worked on. ");
    	System.out.println(" 14. Show Total Team Salary. ");
    	System.out.println(" 15. Show Total Time Spent on project. ");
    	System.out.println(" 16. Show time spent by all members. ");
    	

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
  		

	public int promptUserInputInt() {
		System.out.print("Please input an ID: ");
		return scanner.nextInt();
	}	
}
