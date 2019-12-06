package dit092;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProjectManagement {

    private UserInterface view;
    private DataAccessLayer data;
    private Project project;

    //Menu options, do we need options for total Salary and total time spent as well?
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

    public ProjectManagement() {
        this.view = new UserInterface();
        this.data = new DataAccessLayer(); //Send file path in here?

        ArrayList<Task> testTasks = new ArrayList<Task>();
        ArrayList<TeamMember> testTeamMembers = new ArrayList<TeamMember>();
        Task task1 = new Task(1, "One", 1, 1, 1,
                2, 2, 10, 10, testTeamMembers);
        Task task2 = new Task(2, "Two",1, 2, 2,
                2,2, 5, 5, testTeamMembers);
        Task task3 = new Task(3, "Three",1, 3, 3,
                4, 4, 5, 5, testTeamMembers);
        testTasks.add(task1);
        testTasks.add(task2);
        testTasks.add(task3);
        this.project = new Project(testTasks, new Team(1, testTeamMembers));
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
                    //Obviously get the weeks some other way, perhaps getEarnedValue() which could return a string?
                    userInput = view.showEarnedValue(project.calculateEarnedValue(1,2));
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
