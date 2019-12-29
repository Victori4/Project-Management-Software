package dit092;

import java.util.ArrayList;

public class ProjectManagement {

    private UserInterface view;
    private DataAccessLayer data;
    private Project project;

    //Menu options
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
    private static final int SHOW_TIME_SPENT_ALL_MEMBERS = 16;

    /**
     * TODO handle "null" from loadProject()
     */
    public ProjectManagement() {
        this.view = new UserInterface();
        this.data = new DataAccessLayer();
        this.project = data.loadProject(); //Loads in the project data from JSON file
    }

    private void showEarnedValue() {
        view.showEarnedValueHeader();

        for (int i = project.getStartWeek(); i < project.getEndWeek(); i++) {
            view.showEarnedValue(i+1, project.calculateEarnedValue(i+1));
            i++;
        }
    }

    /**
     * Decides which view to show the user based on their input and connects view with business logic/model.
     */
    public void run() {
        int userInput = view.showStartMenu();

        do {
            switch (userInput) {
                case START:
                    userInput = view.showStartMenu();
                    break;
                    
                case EV:
                    showEarnedValue();
                    userInput = 1; //Takes user back to main menu, not sure if needed..?
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
                	userInput = view.showActualCost(project.calculateActualCost());
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

                case SEARCH_TEAM_MEMBER_ACTIVITIES_BY_ID:
                    int memberId = view.promptUserInputInt();
                    TeamMember member = project.getTeam().findTeamMember(memberId);
                	userInput = view.showTeamMemberActivitiesById(project.getTeam(), memberId);
                    break;

                case SEARCH_TEAM_MEMBER_HOURS_BY_ID:
                	int id = view.promptUserInputInt();
                	userInput = view.showMemberTimeById(project.getTeam(),id);
                    break;

                case SHOW_TIME_SPENT_ALL_MEMBERS:
                	ArrayList<TeamMember> members = project.getTeam().getMembers();
                	userInput = view.showTimeSpentAllMembers(members);
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
                    view.showDefault(); //Prompts user to input a valid menu option
                    break;
            }
        } while (userInput != EXIT);
    }

    public static void main(String[] args) {
        ProjectManagement controller = new ProjectManagement();
        controller.run();
    }
}
