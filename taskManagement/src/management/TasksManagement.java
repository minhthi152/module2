package management;

import model.Task;

import java.util.List;

public class TasksManagement implements ITasksManagement{
    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public void addTask(Task newTask) {

    }

    @Override
    public Task getByTaskId(long TaskId) {
        return null;
    }

    @Override
    public boolean existById(long TaskId) {
        return false;
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void removeById(long taskId) {

    }
}
