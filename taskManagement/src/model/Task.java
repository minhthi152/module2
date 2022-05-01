package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private int id;
    private String taskName;
    private String createDate;
    private String deadline;
    private String createdBy;
    private String updatedBy;
    private boolean status;
    private String description;

    public Task(String taskInfo) throws ParseException {
        String[] taskFields = taskInfo.split(",");
        id = Integer.parseInt(taskFields[0]);
        taskName = taskFields[1];
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        createDate =taskFields[2];
        deadline =taskFields[3];
        createdBy = taskFields[4];
        updatedBy = taskFields[5];
    }

    public Task(int id, String taskName, String createDate,String deadline, User performer) {
        this.id = id;
        this.taskName = taskName;
        this.createDate = createDate;
        this.deadline = deadline;
        this.createdBy = performer.getFullName();


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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
