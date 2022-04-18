package model;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    private static ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }
//Add a task to task list
    public static void addTask(){
        Scanner input = new Scanner(System.in);
        System.out.println("1. Enter task name: ");
        String taskName = input.nextLine();
        System.out.println("2. Enter a deadline");
        String deadline = input.nextLine();

        Task task = new Task(taskName, deadline);
        taskList.add(task);

    }
//    Show task
    public static void showAllTasks(){
        for (Task task: taskList) {
            System.out.println(task.toString());
        }

    }


}
