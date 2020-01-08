package dit092;

import java.util.ArrayList;

public class ProjectManagement {

    private UserInterface view;
    private DataAccessLayer data;
    private Project project;

    //Menu options
    private static final int EXIT = 0;
    private static final int BAC = 1;
    private static final int AC = 2;
    private static final int SHOW_SALARY_ALL_MEMBERS = 3;
    private static final int TOTAL_SALARY = 4;
    private static final int SEARCH_TEAM_MEMBER_ACTIVITIES_BY_ID = 5;
    private static final int SEARCH_TEAM_MEMBER_HOURS_BY_ID = 6;
    private static final int SHOW_TIME_SPENT_ALL_MEMBERS = 7;
    private static final int TOTAL_TIME = 8;
    private static final int PV = 9;
    private static final int EV = 10;
    private static final int SV = 11;
    private static final int CV = 12;
    private static final int SPI = 13;
    private static final int CPI = 14;
    private static final int PROJECT_SCHEDULE = 15;
    private static final int RISK_MATRIX = 16;
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
     * Shows salaries for all members.
     */
    private void showSalaryAllMembers() {
        ArrayList<TeamMember> teamMembers = project.getTeam().getMembers();
        view.showSalaryAllMembers(teamMembers);
    }

    /**
     * Show all activities for all team members by a specific ID.
     */
    private void showSearchTeamMemberActivitiesById() {
        int memberId = view.promptUserInputInt();
        Team team = project.getTeam();
        TeamMember member;
		try {
			member = team.findTeamMember(memberId);
			view.showTeamMemberActivitiesById(member);	
		} catch (Exception e) {
			view.showErrorMessageCouldNotFindMember();
		}
    }

    /**
     * Show all hours for a specific team member found by ID.
     */
    private void showSearchTeamMemberHoursById() {
        int id = view.promptUserInputInt();
        Team team = project.getTeam();
        TeamMember member; 
        try {
        member = team.findTeamMember(id);
        view.showMemberTimeById(member);
        } catch (Exception e) {
        	view.showErrorMessageCouldNotFindMember();
        }
    }

    /**
     * Show total team time.
     */
    private void showTotalTeamTime() {
        view.showTotalTeamTime(project.getTeam().calculateTotalTeamTimeSpent(project.getTeam().getMembers()));
    }

    /**
     * Show total salary for the whole team.
     */
    private void showTotalSalary() {
        view.showTotalTeamSalary(project.getTeam().calculateTotalTeamSalary(project.getTeam().getMembers()));
    }

    /**
     * Show time spent for all members.
     */
    private void showTimeSpentAllMembers() {
        ArrayList<TeamMember> members = project.getTeam().getMembers();
        view.showTimeSpentAllMembers(members);
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
                case BAC:
                    view.showBudgetAtCompletion(project.calculateBudgetAtCompletion());
                    userInput = START; //Prints main menu again
                    break;
                case AC:
                    view.showActualCost(project.calculateActualCost(project.getEndWeek()));
                    userInput = START; //Prints main menu again
                    break;
                case SHOW_SALARY_ALL_MEMBERS:
                    showSalaryAllMembers();
                    userInput = START; //Prints main menu again
                    break;
                case TOTAL_SALARY:
                    showTotalSalary();
                    userInput = START; //Prints main menu again
                    break;
                case SEARCH_TEAM_MEMBER_ACTIVITIES_BY_ID:
                    showSearchTeamMemberActivitiesById();
                    userInput = START; //Prints main menu again
                    break;
                case SEARCH_TEAM_MEMBER_HOURS_BY_ID:
                    showSearchTeamMemberHoursById();
                    userInput = START; //Prints main menu again
                    break;
                case SHOW_TIME_SPENT_ALL_MEMBERS:
                    showTimeSpentAllMembers();
                    userInput = START; //Prints main menu again
                    break;
                case TOTAL_TIME:
                    showTotalTeamTime();
                    userInput = START; //Prints main menu again
                    break;
                case PV:
                    showPlannedValue();
                    userInput = START; //Prints main menu again
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
                case SPI:
                    showSchedulePerformanceIndex();
                    userInput = START; //Prints main menu again
                    break;
                case CPI:
                    showCostPerformanceIndex();
                    userInput = START; //Prints main menu again
                	break;
                case PROJECT_SCHEDULE:
                    //ADD PROJECT SCHEDULE CODE
                    userInput = START; //Prints main menu again
                    break;
                case RISK_MATRIX:
                    view.showRiskMatrix(project.getRiskMatrix());
                    userInput = START; //Prints main menu again
                    break;
                default:
                    view.showDefault(); //Prompts user to input a valid menu option
                    userInput = START;
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
