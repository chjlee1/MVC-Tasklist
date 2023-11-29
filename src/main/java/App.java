import controller.Controller;
import controller.ControllerImpl;
import model.Model;
import model.ModelImpl;
import model.Task;
import java.util.List;

import view.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    @Override
    public void start(Stage stage) {
        // Model
        List<Task> tasks = InitialTasklist.create();
        Model model = new ModelImpl(tasks);

        // Controller
        Controller controller = new ControllerImpl(model);

        // View
        View view = new View(controller);

        // Make scene
        Scene scene = new Scene(view.render());
        scene.getStylesheets().add("main.css");
        stage.setScene(scene);

        // Refresh view when model changes
        model.addObserver((Model m) -> {
            scene.setRoot(view.render());
            stage.sizeToScene();
        });

        // Show the stage
        stage.setTitle("Tasklist View Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
