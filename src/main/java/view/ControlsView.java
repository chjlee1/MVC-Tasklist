package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class ControlsView implements FXComponent {
    private final Controller controller;

    public ControlsView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        HBox layout = new HBox();
        layout.getStyleClass().add("controls-layout");

        Button shuffleButton = new Button("Shuffle");
        shuffleButton.setOnAction((ActionEvent event) -> {
            controller.shuffleTasks();
        });
        layout.getChildren().add(shuffleButton);

        Button sortAlphabetButton = new Button("Sort Alphabetically");
        sortAlphabetButton.setOnAction((ActionEvent event) -> {
            controller.sortTasksAlphabet();
        });
        layout.getChildren().add(sortAlphabetButton);

        Button sortPriorityButton = new Button("Sort by Priority");
        sortPriorityButton.setOnAction((ActionEvent event) -> {
            controller.sortTasksRating();
        });
        layout.getChildren().add(sortPriorityButton);

        return layout;
    }
}
