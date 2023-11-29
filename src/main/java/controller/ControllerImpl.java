package controller;

import model.Model;
import model.Task;
import model.TaskImpl;

public class ControllerImpl implements Controller {
    private Model model;

    public ControllerImpl(Model model) {
        this.model = model;
    }
    @Override
    public Task getTask(int index) {
        return model.getTask(index);
    }

    @Override
    public int getNumTasks() {
        return model.getNumTasks();
    }

    @Override
    public void moveTaskUp(int index) {
        if (index > 0) {
            model.moveTask(index, index - 1);
        }
    }

    @Override
    public void moveTaskDown(int index) {
        if (index + 1 < model.getNumTasks()) {
            model.moveTask(index, index + 1);
        }
    }

    @Override
    public void addTask(String title, String source, int rating) {
        if (rating >= 0 && rating <= 5) {
            model.addTask(new TaskImpl(title, source, rating));
        }
    }

    @Override
    public void removeTask(int index) {
        if (index >= 0 && index < model.getNumTasks()) {
            model.removeTask(index);
        }
    }

    @Override
    public void shuffleTasks() {
        model.shuffleTasks();
    }

    @Override
    public void sortTasksAlphabet() {
        model.sortTasksAlphabet();
    }

    @Override
    public void sortTasksRating() {
        model.sortTasksRating();
    }
}
