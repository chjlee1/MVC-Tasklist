import model.Task;
import model.TaskImpl;

import java.util.ArrayList;
import java.util.List;

public class InitialTasklist {
    private static List<Task> tasklist;

    public static List<Task> create() {
        if (tasklist == null) {
            tasklist = new ArrayList<>();
            tasklist.add(new TaskImpl("Write Essay", "ENGL 113", 2));
            tasklist.add(new TaskImpl("Complete Assignment 17.5", "MATH 233", 3));
            tasklist.add(new TaskImpl("Complete Assignment 09", "COMP 301", 5));
            tasklist.add(new TaskImpl("Study for Vocab Quiz", "KOR 101", 3));
            tasklist.add(new TaskImpl("Finish Event Planning Form", "UNC AASA", 4));
            tasklist.add(new TaskImpl("Write Practice", "UNC Swim Club", 1));
            tasklist.add(new TaskImpl("Call parents TODAY", "Love and Support", 5));
        }
        return tasklist;
    }
}
