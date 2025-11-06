package model;


public class Goal {
    private int id;
    private String title;
    private String description;
    private boolean completed;

    public Goal(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public int getId() { 
        return id; 
        }
    public String getTitle() { 
        return title;
        }
    public String getDescription() {
        return description;
        }
    public boolean isCompleted() { 
        return completed; 
        }

    public void markCompleted() { 
        this.completed = true; 
        }

    @Override
    public String toString() {
        return "Goal{id=" + id + ", title='" + title + "', completed=" + completed + "}";
    }
}
