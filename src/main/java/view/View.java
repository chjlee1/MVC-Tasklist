package view;

import controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class View implements FXComponent {
    private final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        VBox layout = new VBox();

        // Controls view
        ControlsView controlsView = new ControlsView(controller);
        layout.getChildren().add(controlsView.render());

        // Playlist
        VBox playlist = new VBox();
        for (int i = 0; i < controller.getNumTasks(); i++) {
            TaskView taskView = new TaskView(controller, i);
            playlist.getChildren().add(taskView.render());
        }
        layout.getChildren().add(playlist);

        // Add song view
        AddTaskView addTaskView = new AddTaskView(controller);
        layout.getChildren().add(addTaskView.render());

        return layout;
    }
}