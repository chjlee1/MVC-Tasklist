package model;

public class TaskImpl implements Task {
    private String title;
    private String source;
    private int rating;

    public TaskImpl(String title, String source, int rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Difficulty must be in the range [0, 5]");
        }
        this.title = title;
        this.source = source;
        this.rating = rating;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public int getRating() {
        return rating;
    }
}

