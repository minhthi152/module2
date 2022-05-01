package management;

import model.Task;
import model.User;
import utils.CSVUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TasksManagement implements ITasksManagement{
    public static List<Task> tasksList = new ArrayList<Task>();

    public static String path = "data/tasks.csv";
    public TasksManagement() {
        tasksList.add(new Task(0,"Design 1", "12-02-2022","25-04-2022", new User()));
        tasksList.add(new Task(1,"Design 2", "12-02-2022","25-04-2022", new User()));
        tasksList.add(new Task(2,"Design 3", "12-02-2022","25-04-2022",new User()));
        tasksList.add(new Task(3,"Design 4", "12-02-2022","25-04-2022", new User()));
    }

    @Override
    public List<Task> getTasks() {
      List<String> tasksInfo = CSVUtils.read(path);
      for(String taskInfo: tasksInfo){
          try {
              tasksList.add(new Task(taskInfo));
          } catch (ParseException e) {
              throw new RuntimeException(e);
          }
      }
        return tasksList;
    }

    @Override
    public void addTask(Task newTask) {
        tasksList.add(newTask);
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
    }
}
