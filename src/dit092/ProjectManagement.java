package dit092;

public class ProjectManagement {

    private UserInterface view;

    public ProjectManagement(UserInterface view) {
        this.view = view;
    }

    public void run() {
        //Main menu
    }

    public static void main(String[] args) {
        UserInterface view = new UserInterface();
        ProjectManagement controller = new ProjectManagement(view);

        controller.run();
    }
}
