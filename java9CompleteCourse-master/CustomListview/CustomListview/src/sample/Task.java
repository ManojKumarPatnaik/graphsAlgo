package sample;

public class Task {
    private String task;
    private String dateCreated;
    private String description;


    public Task() {
    }

    public Task(String task, String dateCreated, String description) {
        this.task = task;
        this.dateCreated = dateCreated;
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
