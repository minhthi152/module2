package views;

import model.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TaskList {
    static List<Task> taskList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    //Add a task to task list
    public static void addTask() throws ParseException {
        System.out.println("Enter an ID: ");
        int id = Integer.parseInt(input.nextLine());

        System.out.println("1. Enter task name: ");
        String taskName = input.nextLine();
        Date createdDate = new Date();

        System.out.println("2. Enter a deadline");
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date deadline = df.parse(input.nextLine());

        Task task = new Task(id, taskName, createdDate, deadline);
        taskList.add(task);

    }

    //    Show task
    public static void showAllTasks() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("--------------------------------------------ALL TASKS----------------------------------------------");
        System.out.printf("%-10s %-15s %-18s %-15s %-15s %-15s %-15s\n", "Id", "Task name", "Created Date", "Deadline", "Created by", "Updated by", "Status");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (Task task : taskList) {
            System.out.printf("%-10s %-15s %-18s %-15s %-15s %-15s %-15s\n", task.getId(), task.getTaskName(), df.format(task.getCreateDate()),
                   df.format(task.getDeadline()), task.getCreatedBy(), task.getUpdatedBy(), task.isStatus());
        }
        System.out.println("---------------------------------------------------------------------------------------------------\n");
    }


}
