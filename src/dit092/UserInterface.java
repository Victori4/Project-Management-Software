package dit092;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public int showStartMenu() {
        System.out.println("MENU\nPlease press 2 to see EV for week 1-2 or 0 to exit: ");
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

}
