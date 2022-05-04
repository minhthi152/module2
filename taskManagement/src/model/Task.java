package model;

public class Task {

    private static int number = 100;
    private int id;
    private String taskName;
    private String createDate;
    private String deadline;
    private String createdBy;
    private String updatedBy;
    private int numberOfPerformer;
    String performers;
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
        this.numberOfPerformer = Integer.parseInt(taskFields[5]);
        this.performers = taskFields[5];
        this.updatedBy = taskFields[6];
        this.lastUpdate = taskFields[7];
        this.status = Status.fromValue(taskFields[8]);
        this.description = taskFields[9];
    }

    public Task(String taskName, String createDate,String deadline, User creator, int numberOfPerformer, String performers , String description) {
        this.id = number++;
        this.taskName = taskName;
        this.createDate = createDate;
        this.deadline = deadline;
        this.createdBy = creator.getFullName();
        this.numberOfPerformer = numberOfPerformer;
        this.performers = performers;
        this.updatedBy = "";
        this.lastUpdate = "";
        this.status = Status.PENDING;
        this.description = description;
    }

    public int getNumberOfPerformer() {
        return numberOfPerformer;
    }

    public void setNumberOfPerformer(int numberOfPerformer) {
        this.numberOfPerformer = numberOfPerformer;
    }

    public String getPerformers() {
        return performers;
    }

    public void setPerformers(String performers) {
        this.performers = performers;
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
                "," + numberOfPerformer +
                "," + performers +
                "," + lastUpdate +
                "," + status +
                "," + description;
    }
}
