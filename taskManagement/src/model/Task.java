package model;

public class Task {
    private static int number = 100;
    private int id;
    private String taskName;
    private String createDate;
    private String deadline;
    private String createdBy;
    private String updatedBy;

    private String lastUpdate;
    private Status status;
    private String description;

    public Task(String line){
        String[] taskFields = line.split(",");
        this.id = Integer.parseInt(taskFields[0]);
        this.taskName = taskFields[1];
        this.createDate =taskFields[2];
        this.deadline =taskFields[3];
        this.createdBy = taskFields[4];
        this.updatedBy = taskFields[5];
        this.lastUpdate = taskFields[6];
        this.status = Status.fromValue(taskFields[7]);
        this.description = taskFields[8];
    }

    public Task(String taskName, String createDate,String deadline, User performer, String description) {
        this.id = number++;
        this.taskName = taskName;
        this.createDate = createDate;
        this.deadline = deadline;
        this.createdBy = performer.getFullName();
        this.updatedBy = "";
        this.lastUpdate = "";
        this.status = Status.PENDING;
        this.description = description;
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

    public int getId() {
        return id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Status isStatus() {
        return status;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return id +
                "," + taskName +
                "," + createDate +
                "," + deadline +
                "," + createdBy +
                "," + updatedBy +
                "," + lastUpdate +
                "," + status +
                "," + description;
    }
}
