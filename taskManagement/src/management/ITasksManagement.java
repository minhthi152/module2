package management;

import model.Task;

import java.util.List;

public interface ITasksManagement {
    List<Task> getTasks() ;

    void addTask(Task newTask) ;

    Task getByTaskId(long TaskId) ;

    boolean existById(long TaskId) ;

    void update(Task task);

    void remove(Task task);
}
