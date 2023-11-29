package controller;

import model.Task;

public interface Controller {
    Task getTask(int index);

    int getNumTasks();

    void moveTaskUp(int index);

    void moveTaskDown(int index);

    void addTask(String title, String source, int rating);

    void removeTask(int index);

    void shuffleTasks();

    void sortTasksAlphabet();

    void sortTasksRating();
}

