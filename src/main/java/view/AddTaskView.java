package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
public class AddTaskView implements FXComponent {
    private final Controller controller;
    private HBox layout;

    public AddTaskView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        if (layout != null) {
            return layout;
        }

        layout = new HBox();
        layout.getStyleClass().add("add-task-layout");

        // Title
        TextField titleInput = new TextField();
        layout.getChildren().add(new Label("Task:"));
        layout.getChildren().add(titleInput);

        // Artist
        TextField sourceInput = new TextField();
        layout.getChildren().add(new Label("Source:"));
        layout.getChildren().add(sourceInput);

        // Rating
        Slider ratingSlider = new Slider(0, 5, 5);
        ratingSlider.getStyleClass().add("add-task-slider");
        layout.getChildren().add(new Label("Priority:"));
        layout.getChildren().add(ratingSlider);

        // Add button
        Button addButton = new Button("\uff0b");
        addButton.setOnAction((ActionEvent event) -> {
            String title = titleInput.getText();
            String source = sourceInput.getText();
            int rating = (int) ratingSlider.getValue();
            controller.addTask(title, source, rating);
            titleInput.setText("");
            sourceInput.setText("");
        });
        layout.getChildren().add(addButton);

        return layout;
    }

}
