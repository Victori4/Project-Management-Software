package dit092;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProjectManagement {

    private UserInterface view;
    private DataAccessLayer data;
    private Project project;

    //Menu option
    //Added Total Salary and total time spent as well as team variable to ensure it works. If we do not want, can remove all.

    private static final int EXIT = 0;
    private static final int START = 1;
    private static final int EV = 2;
    private static final int SV = 3;
    private static final int CV = 4;
    private static final int PV = 5;
    private static final int AC = 6;
    private static final int BAC = 7;
    private static final int CPI = 8;
    private static final int SPI = 9;
    private static final int RISK_MATRIX = 10;
    private static final int PROJECT_SCHEDULE = 11;
    private static final int SEARCH_TEAM_MEMBER_HOURS_BY_ID = 12;
    private static final int SEARCH_TEAM_MEMBER_ACTIVITIES_BY_ID = 13;
    private static final int TOTAL_SALARY = 14;
    private static final int TOTAL_TIME = 15;

    public ProjectManagement() {
        this.view = new UserInterface();
        this.data = new DataAccessLayer(); //Send file path in here?

        //this.project = data.loadProject(); ?
    }

    public void run() {
        int userInput = view.showStartMenu();

        do {
            switch (userInput) {
            
                case START:
                    userInput = view.showStartMenu();
                    break;
                    
                case EV:
                    userInput = view.showEarnedValue(project.calculateEarnedValue(2));
                    break;
                    
                case SV:
                	userInput = 0;
                    break;
                   
                case CV:
                	userInput = 0;
                    break;
                    
                case PV:
                	userInput = 0;
                    break;
                    
                case AC:
                	userInput = 0;
                    break;
                    
                case BAC:
                	userInput = 0;
                    break;
                    
                case CPI:
                	userInput = view.showCostPerformanceIndex(project.calculateCostPerformanceIndex(2));
                	break;
                	
                case SPI:
                	userInput = 0;
                    break;
                	
                case RISK_MATRIX:
                	userInput = 0;
                    break;
                    
                case PROJECT_SCHEDULE:
                	userInput = 0;
                    break;
                    
                case SEARCH_TEAM_MEMBER_HOURS_BY_ID:
                	userInput = 0;
                    break;
                    
                case SEARCH_TEAM_MEMBER_ACTIVITIES_BY_ID:
                	userInput = 0;
                    break;
                    
                case TOTAL_SALARY:
                	userInput = view.showTotalTeamSalary(project.getTeam().calculateTotalTeamSalary(project.getTeam().getMembers()));
                	break;
                	
                case TOTAL_TIME:
                	userInput = view.showTotalTeamTime(project.getTeam().calculateTotalTeamTimeSpent(project.getTeam().getMembers()));
                	break;
                	
                case EXIT:
                    userInput = 0;
                    break;
                    
                default:
                    view.showDefault();
                    break;
            }
        } while (userInput != EXIT);
    }

    public static void main(String[] args) {
        ProjectManagement controller = new ProjectManagement();

        controller.run();
    }
}
