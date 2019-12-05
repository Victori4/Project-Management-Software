package dit092;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public int showStartMenu() {
        System.out.println("MENU\nPlease press 2 to see EV for week 1-2 or 0 to exit");
        return scanner.nextInt();
    }

    public int showEarnedValue(double ev) {
        System.out.print(ev);

        return scanner.nextInt();
    }

    public void showDefault() {
        System.out.println("Please try again!");
    }

}
