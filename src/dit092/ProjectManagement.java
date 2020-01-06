package dit092;

import java.util.ArrayList;

public class ProjectManagement {

    private UserInterface view;
    private DataAccessLayer data;
    private Project project;

    //Menu options
    private static final int EXIT = 0;
    private static final int EV = 1;
    private static final int SV = 2;
    private static final int CV = 3;
    private static final int PV = 4;
    private static final int AC = 5;
    private static final int BAC = 6;
    private static final int CPI = 7;
    private static final int SPI = 8;
    private static final int RISK_MATRIX = 9;
    private static final int PROJECT_SCHEDULE = 10;
    private static final int SEARCH_TEAM_MEMBER_HOURS_BY_ID = 11;
    private static final int SEARCH_TEAM_MEMBER_ACTIVITIES_BY_ID = 12;
    private static final int TOTAL_SALARY = 13;
    private static final int TOTAL_TIME = 14;
    private static final int SHOW_TIME_SPENT_ALL_MEMBERS = 15;
    private static final int SHOW_SALARY_ALL_MEMBERS = 16;
    private static final int START = 17;

    /**
     * TODO handle "null" from loadProject()
     */
    public ProjectManagement() {
        this.view = new UserInterface();
        this.data = new DataAccessLayer();
        this.project = data.loadProject(); //Loads in the project data from JSON file
    }

    /**
     * Calls the UI to print the EV interval calculations for every 2 weeks.
     * Uses weekToStartIntervalFrom to handle even/odd weeks differently.
     * TODO fix the +1?
     */
    private void showEarnedValue() {
        view.showEarnedValueHeader();
        int startWeek = weekToStartIntervalFrom();

        for (int i = startWeek; i < project.getEndWeek(); i++) {
            view.showEarnedValue(i+1, project.calculateEarnedValue(i+1));
            i++;
        }
    }

    /**
     * Calls the UI to print the SV interval calculations for every 2 weeks.
     * Uses weekToStartIntervalFrom to handle even/odd weeks differently.
     * TODO fix the +1?
     */
    private void showScheduleVariance() {
        view.showScheduleVarianceHeader();
        int startWeek = weekToStartIntervalFrom();

        for (int i = startWeek; i < project.getEndWeek(); i++) {
            view.showScheduleVariance(i+1, project.calculateScheduleVariance(i+1));
            i++;
        }
    }

    /**
     * Calls the UI to print the CV interval calculations for every 2 weeks.
     * Uses weekToStartIntervalFrom to handle even/odd weeks differently.
     * TODO fix the +1?
     */
    private void showCostVariance() {
        view.showCostVarianceHeader();
        int startWeek = weekToStartIntervalFrom();

        for (int i = startWeek; i < project.getEndWeek(); i++) {
            view.showCostVariance(i+1, project.calculateCostVariance(i+1));
            i++;
        }
    }

    /**
     * Calls the UI to print the PV interval calculations for every 2 weeks.
     * Uses weekToStartIntervalFrom to handle even/odd weeks differently.
     * TODO fix the +1?
     */
    private void showPlannedValue() {
        view.showPlannedValueHeader();
        int startWeek = weekToStartIntervalFrom();

        for (int i = startWeek; i < project.getEndWeek(); i++) {
            view.showPlannedValue(i+1, project.calculatePlannedValue(i+1));
            i++;
        }
    }

    /**
     * Calls the UI to print the CPI interval calculations for every 2 weeks.
     * Uses weekToStartIntervalFrom to handle even/odd weeks differently.
     * TODO fix the +1?
     */
    private void showCostPerformanceIndex() {
        view.showCostPerformanceIndexHeader();
        int startWeek = weekToStartIntervalFrom();

        for (int i = startWeek; i < project.getEndWeek(); i++) {
            view.showCostPerformanceIndex(i+1, project.calculateCostPerformanceIndex(i+1));
            i++;
        }
    }

    /**
     * Calls the UI to print the SPI interval calculations for every 2 weeks.
     * Uses weekToStartIntervalFrom to handle even/odd weeks differently.
     * TODO fix the +1?
     */
    private void showSchedulePerformanceIndex() {
        view.showSchedulePerformanceIndexHeader();
        int startWeek = weekToStartIntervalFrom();

        for (int i = startWeek; i < project.getEndWeek(); i++) {
            view.showSchedulePerformanceIndex(i+1, project.calculateSchedulePerformanceIndex(i+1));
            i++;
        }
    }

    /**
     * Checks if the total project weeks is even or odd and returns the number to start the interval calculations from.
     * Assumes there are tasks that start week 1.
     * @return int week to start interval from
     */
    private int weekToStartIntervalFrom() {
        int totalProjectWeeks = project.getTotalProjectWeeks();

        if (totalProjectWeeks % 2 == 0) {
            return project.getStartWeek();
        } else {
            //Adds another week if it's uneven so it starts counting from week 3 instead of 2.
            //I.e. it "skips" the first week as discussed.
            return project.getStartWeek() +1;
        }
    }

    /**
     * Decides which view to show the user based on their input and connects view with business logic/model.
     */
    public void run() {
        int userInput = START;

        do {
            switch (userInput) {
                case START:
                    userInput = view.showStartMenu();
                    break;
                    
                case EV:
                    showEarnedValue();
                    userInput = START; //Prints main menu again
                    break;
                    
                case SV:
                    showScheduleVariance();
                    userInput = START; //Prints main menu again
                    break;
                   
                case CV:
                    showCostVariance();
                    userInput = START; //Prints main menu again
                    break;
                    
                case PV:
                    showPlannedValue();
                    userInput = START; //Prints main menu again
                    break;
                    
                case AC:
                	view.showActualCost(project.calculateActualCost());
                    userInput = START; //Prints main menu again
                    break;
                    
                case BAC:
                    view.showBudgetAtCompletion(project.calculateBudgetAtCompletion());
                    userInput = START; //Prints main menu again
                    break;
                    
                case CPI:
                    showCostPerformanceIndex();
                    userInput = START; //Prints main menu again
                	break;

                case SPI:
                    showSchedulePerformanceIndex();
                    userInput = START; //Prints main menu again
                    break;

                case RISK_MATRIX:
                    //ADD RISK MATRIX CODE
                    userInput = START; //Prints main menu again
                    break;

                case PROJECT_SCHEDULE:
                    //ADD PROJECT SCHEDULE CODE
                    userInput = START; //Prints main menu again
                    break;

                case SEARCH_TEAM_MEMBER_ACTIVITIES_BY_ID:
                    int memberId = view.promptUserInputInt();
                    //You get the member here but previously didn't use it
                    TeamMember member = project.getTeam().findTeamMember(memberId);
                    //Changed the return type of the UI.
                    //Sending in member in showTeamMemberActivitiesById()
                	view.showTeamMemberActivitiesById(member);
                	userInput = START; //Prints main menu again
                    break;

                case SEARCH_TEAM_MEMBER_HOURS_BY_ID:
                	int id = view.promptUserInputInt();
                	view.showMemberTimeById(project.getTeam(),id);
                    userInput = START; //Prints main menu again
                    break;

                case SHOW_TIME_SPENT_ALL_MEMBERS:
                	ArrayList<TeamMember> members = project.getTeam().getMembers();
                	view.showTimeSpentAllMembers(members);
                    userInput = START; //Prints main menu again
                	break;

                case TOTAL_SALARY:
                	view.showTotalTeamSalary(project.getTeam().calculateTotalTeamSalary(project.getTeam().getMembers()));
                    userInput = START; //Prints main menu again
                	break;

                case TOTAL_TIME:
                	view.showTotalTeamTime(project.getTeam().calculateTotalTeamTimeSpent(project.getTeam().getMembers()));
                    userInput = START; //Prints main menu again
                	break;

                case SHOW_SALARY_ALL_MEMBERS:
                	ArrayList<TeamMember> teamMembers = project.getTeam().getMembers();
                	view.showSalaryAllMembers(teamMembers); //Sends in the team to the UI
                    userInput = START;  //Makes sure the menu prints again after printing the salaries. There's a better
                                        //way of doing this but I won't fix this right now...
                	break;

                default:
                    view.showDefault(); //Prompts user to input a valid menu option
                    break;
            }
        } while (userInput != EXIT);

        view.showExitMessage();
    }

    public static void main(String[] args) {
        ProjectManagement controller = new ProjectManagement();
        controller.run();
    }
}
