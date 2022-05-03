package management;

import model.Task;
import utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class TasksManagement implements ITasksManagement{

    public static String path = "data/tasks.csv";
    List<Task> tasksList = new ArrayList<>();
    @Override
    public List<Task> getTasks(){
        List<Task> curtasksList = new ArrayList<>();
        List<String> lines = CSVUtils.read(path);
        for (String line: lines) {
            curtasksList.add(new Task(line));
        }
        return tasksList = curtasksList;
    }

    @Override
    public void addTask(Task newTask) {
        tasksList.add(newTask);
        CSVUtils.write(path,tasksList);
    }

    @Override
    public Task getByTaskId(long TaskId) {
        for (Task task: getTasks()) {
            if(task.getId() == TaskId){
                return task;
            }
        }
        return null;
    }

    @Override
    public boolean existById(long TaskId) {
        return getByTaskId(TaskId) != null;
    }

    @Override
    public void update(Task newTask) {
        Task task = getByTaskId(newTask.getId());
        task.setTaskName(newTask.getTaskName());


    }

    @Override
    public void remove(Task task) {
        tasksList.remove(task);
        CSVUtils.write(path,tasksList);
    }
}
