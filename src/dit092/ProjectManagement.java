package dit092;

public class ProjectManagement {

    private UI view;

    public ProjectManagement(UI view) {
        this.view = view;
    }

    public void run() {
        //Main menu
    }

    public static void main(String[] args) {
        UI view = new UI();
        ProjectManagement controller = new ProjectManagement(view);

        controller.run();
    }
}
