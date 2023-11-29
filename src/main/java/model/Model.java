package model;

public interface Model {
    Task getTask(int index);
    void addTask(Task task);
    void removeTask(int index);
    void moveTask(int oldIndex, int newIndex);
    void shuffleTasks();

    void sortTasksAlphabet();

    void sortTasksRating();

    int getNumTasks();

    void addObserver(ModelObserver observer);
    void removeObserver(ModelObserver observer);
}
