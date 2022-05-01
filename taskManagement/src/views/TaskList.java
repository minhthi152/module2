package views;

import management.ITasksManagement;
import management.TasksManagement;
import model.Task;
import model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static management.TasksManagement.tasksList;

public class TaskList {
    public static TasksManagement tasksManagement = new TasksManagement();
    static Scanner input = new Scanner(System.in);

    //Add a task to task list
    public static void addTask() throws ParseException {
        System.out.println("Enter an ID: ");
        int id = Integer.parseInt(input.nextLine());

        System.out.println("1. Enter task name: ");
        String taskName = input.nextLine();
        System.out.println("2. Enter create date: ");
        String createdDate = input.nextLine();

        System.out.println("2. Enter a deadline");
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        Date deadline = df.parse(input.nextLine());
        String deadline = input.nextLine();

        Task task = new Task(id, taskName, createdDate, deadline, new User());
        tasksList.add(task);

    }

    //    Show task
    public static void showAllTasks() {
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("--------------------------------------------ALL TASKS----------------------------------------------");
        System.out.printf("%-10s %-15s %-18s %-15s %-15s %-15s %-15s\n", "Id", "Task name", "Created Date", "Deadline", "Created by", "Updated by", "Status");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (Task task : tasksList) {
            System.out.printf("%-10s %-15s %-18s %-15s %-15s %-15s %-15s\n", task.getId(), task.getTaskName(), task.getCreateDate(),
                    task.getDeadline(), task.getCreatedBy(), task.getUpdatedBy(), task.isStatus());
        }
        System.out.println("---------------------------------------------------------------------------------------------------\n");
    }

    //Edit task
    public static void editProduct() throws ParseException {
        showAllTasks();
        System.out.println("Select a task ID to edit: ");
        int id = Integer.parseInt(input.nextLine());
        if (!tasksManagement.existById(id)) {
            System.out.println("Task does not exist!");
            return;
        }
        System.out.println("Enter new task name: ");
        String newTaskName = input.nextLine();
        System.out.println("Enter a deadline: ");
        String createDate = tasksList.get(id).getCreateDate();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String newDeadline = input.nextLine();
//        Date newDeadline = df.parse(input.nextLine());
        Task newTask = new Task(id, newTaskName, createDate, newDeadline, new User());
        tasksManagement.update(newTask);
        System.out.println("Task edited successfully!");
    }

    //Delete a task
    public static void deleteTask() {
        showAllTasks();
        System.out.println("Enter the id of the task you want to delete: ");
        int id = Integer.parseInt(input.nextLine());
        for (int i = 0; i < tasksList.size(); i++) {
            if (id == tasksList.get(i).getId()) {
              tasksManagement.remove(tasksList.get(i));
            }
            break;
        }
        System.out.println("Task removed successfully!");
    }

    // Search a task
    public static void searchTaskByName() {
        System.out.println("Enter name of product: ");
        String taskName = input.nextLine().toUpperCase();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int count = 0;
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-18s %-15s %-15s %-15s %-15s\n", "Id", "Task name", "Created Date", "Deadline", "Created by", "Updated by", "Status");
        for (int i = 0; i < tasksList.size(); i++) {

            if ((tasksList.get(i).getTaskName().toUpperCase()).contains(taskName)) {
                System.out.println("---------------------------------------------------------------------------------------------------------");
                System.out.printf("%-10s %-15s %-18s %-15s %-15s %-15s %-15s\n", tasksList.get(i).getId(), tasksList.get(i).getTaskName(), df.format(tasksList.get(i).getCreateDate()),
                        df.format(tasksList.get(i).getDeadline()), tasksList.get(i).getCreatedBy(), tasksList.get(i).getUpdatedBy(), tasksList.get(i).isStatus());
                count++;
            }

        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
        if (count == 0) {
            System.out.println("Not found!");
        }
    }
}