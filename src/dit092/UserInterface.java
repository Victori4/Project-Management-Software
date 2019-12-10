package dit092;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public int showStartMenu() {
        System.out.println(" === Welcome to The Project Management System === ");
    	System.out.println(" Choose an option below: ");
    	System.out.println(" ");
    	System.out.println(" 1.  ");
    	System.out.println(" 2. EV for week 1-2. ");
    	System.out.println(" 3.  ");
    	System.out.println(" 4.  ");
    	System.out.println(" 5. ");
     	System.out.println(" 6. Calculate actual cost. ");
    	System.out.println(" 7. Calculate Budget At Completion. ");
    	System.out.println(" 8. Calculate Cost Performance Index. ");
    	System.out.println(" 9. Caculate Schedule Performance Index. ");
    	System.out.println(" 10.  ");
    	System.out.println(" 11. ");
    	System.out.println(" 12. Search team member by ID to see time spent. ");
    	System.out.println(" 13. Search team member by ID to see which tasks the member has worked on. ");
    	System.out.println(" 14. Calculate Total Salary. ");
    	System.out.println(" 15. Calculate Total Time Spent. ");

    	System.out.println(" 0. Quit this program. ");
        return scanner.nextInt();
    }
    

    public int showEarnedValue(double ev) {
        System.out.print("EV: " + ev + " SEK.");

        return scanner.nextInt();
    }

    public void showDefault() {
        System.out.println("Please try again!");
    }
    
    public int showCostPerformanceIndex(double CPI) {
    	System.out.print("Cost Performance Index: " + CPI);
    	return scanner.nextInt();
    }
    
    
    //Added below in case we wanted to print total salary and total time? Can delete if we do not want
      public int showTotalSalary (double totalSal) {
    	System.out.print("Total Salary: " + totalSal);
    	return scanner.nextInt();
    }
    
    public int showTotalTime (double totalTime) {
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

    public int showTeamMemberHoursById(int id) {
    	System.out.println("Team member " + toString()); //not sure if correct, uncertain about the toString in Team class
    	return scanner.nextInt();
    }
    
    public int showTeamMemberActivitiesById(int id) {
    	System.out.println("Team member " + toString()); //not sure if correct, uncertain about the toString in Team class
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
}
