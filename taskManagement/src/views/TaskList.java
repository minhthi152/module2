package views;

import management.TasksManagement;
import model.Task;
import model.User;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class TaskList {
    public static TasksManagement tasksManagement = new TasksManagement();

    static Scanner input = new Scanner(System.in);

    //Add a task to task list
    public static void addTask()  {
//        System.out.println("Enter an id: ");
//        int id = Integer.parseInt(input.nextLine());
        System.out.println("1. Enter task name: ");
        String taskName = input.nextLine();
        System.out.println("2. Enter create date: ");
        String createdDate = input.nextLine();

        System.out.println("2. Enter a deadline");
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        Date deadline = df.parse(input.nextLine());
        String deadline = input.nextLine();

        System.out.println("Enter ID of performer: ");
        int performerId = Integer.parseInt(input.nextLine());
        User performer =  UserView.findUserById(performerId);
        System.out.println("Add a description: ");
        String description = input.nextLine();

        Task task = new Task(taskName, createdDate, deadline, performer, description);
        tasksManagement.addTask(task);
        System.out.println("Successfully added task!");

        System.out.println("Enter y to continue adding or any other key to return");
        String choice = input.nextLine();
        switch (choice){
            case "y":
                addTask();
                break;
            default:
                Menu.showMainMenu();
                break;
        }

    }

    //    Show task
    public static void showAllTasks() {
        List<Task> tasksList = tasksManagement.getTasks();
        System.out.println("---ALL TASKS--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-18s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Id", "Task name", "Created Date", "Deadline", "Created by", "Updated by", "Last update", "Status", "Description");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Task task : tasksList) {
            System.out.printf("%-10s %-15s %-18s %-15s %-15s %-15s %-15s %-15s %-15s\n", task.getId(), task.getTaskName(), task.getCreateDate(),
                    task.getDeadline(), task.getCreatedBy(), task.getUpdatedBy(), task.getLastUpdate(), task.isStatus(), task.getDescription());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    //Edit task
    public static void updateTask(){
        showAllTasks();
        List<Task> tasksList = tasksManagement.getTasks();
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

        System.out.println("Enter a new description: ");
        String description = input.nextLine();
        Task newTask = new Task(newTaskName, createDate, newDeadline, new User(), description);
        tasksManagement.update(newTask);
        System.out.println("Task edited successfully!");


    }

    //Delete a task
    public static void deleteTask() {
        showAllTasks();
        System.out.println("Enter the id of the task you want to delete: ");

        int id = Integer.parseInt(input.nextLine());

        Task task = tasksManagement.getByTaskId(id);
        if(task == null){
            System.out.println("Task with ID " + id + " does not exist!");
        }else{

            tasksManagement.remove(task);
            System.out.println("Task removed successfully!");
        }
        System.out.println("Enter y to continue deleting or any other key to return");
        String choice = input.nextLine();
        switch (choice){
            case "y":
                deleteTask();
                break;
            default:
                Menu.showMainMenu();
                break;
        }

    }

    // Search a task
    public static void searchTaskByName() {
        List<Task> tasksList = tasksManagement.getTasks();
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