package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.Task;

public class TaskView implements FXComponent {
    private final Controller controller;
    private final int taskIndex;

    public TaskView(Controller controller, int taskIndex) {
        this.controller = controller;
        this.taskIndex = taskIndex;
    }

    @Override
    public Parent render() {
        HBox layout = new HBox();
        layout.getStyleClass().add("task-layout");

        // Delete button
        Button deleteButton = new Button("\u274C");
        deleteButton.setOnAction((ActionEvent event) -> {
            controller.removeTask(taskIndex);
        });
        layout.getChildren().add(deleteButton);

        // Up button
        Button upButton = new Button("\u25B2");
        upButton.setOnAction((ActionEvent event) -> {
            controller.moveTaskUp(taskIndex);
        });
        layout.getChildren().add(upButton);

        // Down button
        Button downButton = new Button("\u25BC");
        downButton.setOnAction((ActionEvent event) -> {
            controller.moveTaskDown(taskIndex);
        });
        layout.getChildren().add(downButton);

        // Title
        Label title = new Label(makeLabelString());
        layout.getChildren().add(title);

        return layout;
    }

    private String makeLabelString() {
        Task task = controller.getTask(taskIndex);
        return task.getTitle() + " for " + task.getSource() + " (" + makeRating() + ")";
    }

    private String makeRating() {
        Task task = controller.getTask(taskIndex);
        int ratingInt = task.getRating();
        String ratingString = "";
        for (int i = 0; i < ratingInt; i++) {
            ratingString += "\u2605";
        }
        for (int i = ratingInt; i < 5; i++) {
            ratingString += "\u2606";
        }
        return ratingString;
    }
}
