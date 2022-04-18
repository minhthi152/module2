package model;

import java.util.Date;

public class Task {
    private int id;
    private String taskName;
    private String createDate;
    private String deadline;
    private User createdBy;
    private User updatedBy;
    private boolean status;
    private String description;

    public Task() {
    }

    public Task(String taskName, String deadline) {
        this.taskName = taskName;
        this.deadline = deadline;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", createDate='" + createDate + '\'' +
                ", deadline='" + deadline + '\'' +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
