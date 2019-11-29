package dit092;

import java.util.ArrayList;

public class Project {
    private ArrayList<Task> tasks;

    public Project(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Making sure it compiles! Please feel free to finish the method and edit this comment!
     * @return
     */
    public double calculatePlannedValue() {
        return 0;
    }

    /**
     * Budgeted Cost of Work Performed.
     * Needs to calculate every 2 weeks: 3, 5, 7, 9, 11? Combine week 1 & 2?
     * Call it from somewhere where input is every 2 weeks for the entire project?
     * Also is it every 2 weeks EV or the EV for the entire project but every 2 weeks?
     *
     * @return double Earned Value
     */
    public double calculateEarnedValue(int firstWeekToCompare, int lastWeekToCompare) {
        double percentageDone = 0;
        int numberOfTasksStarted = 0;
        int numberOfTasksFinished = 0;

        for (Task task : tasks) {
            if (task.getStartWeek() >= firstWeekToCompare && task.getStartWeek() <= lastWeekToCompare) {
                numberOfTasksStarted++;

                //If it has an end week, it means that the task is finished??
                //Needs to have a way to check if a task is done so we can calculate the % of what's done
                if (task.getEndWeek() != 0) {
                    numberOfTasksFinished++;
                }
            }
        }

        //PlannedValue probably needs first/last week
        return calculatePlannedValue() * (numberOfTasksFinished/numberOfTasksStarted);
    }
}
