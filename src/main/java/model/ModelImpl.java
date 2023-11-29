package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ModelImpl implements Model {
    private List<Task> tasks;
    private List<ModelObserver> observers;

    public ModelImpl(List<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
        this.observers = new ArrayList<>();
    }

    public ModelImpl() {
        this.tasks = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    @Override
    public Task getTask(int index) {
        return tasks.get(index);
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void removeTask(int index) {
        tasks.remove(index);
        notifyObservers();
    }

    @Override
    public void moveTask(int oldIndex, int newIndex) {
        Task task = tasks.remove(oldIndex);
        tasks.add(newIndex, task);
        notifyObservers();
    }

    @Override
    public void shuffleTasks() {
        Collections.shuffle(tasks);
        notifyObservers();
    }

    @Override
    public void sortTasksAlphabet() {
        tasks.sort(Comparator.comparing(Task::getTitle));
        notifyObservers();
    }

    @Override
    public void sortTasksRating() {
        tasks.sort((t1, t2) -> {
            return (t2.getRating() - t1.getRating());
        });
        notifyObservers();
    }

    @Override
    public int getNumTasks() {
        return tasks.size();
    }

    @Override
    public void addObserver(ModelObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ModelObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (ModelObserver observer : observers) {
            observer.update(this);
        }
    }
}
