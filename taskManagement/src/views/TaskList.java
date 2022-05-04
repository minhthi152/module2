package views;

import management.TasksManagement;
import model.Status;
import model.Task;
import model.User;
import notification.WrongChoice;
import utils.ValidateUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TaskList {
    public static TasksManagement tasksManagement = new TasksManagement();

    static Scanner input = new Scanner(System.in);

    //Add a task to task list
    public static void addTask()  {
        tasksManagement.getTasks();
//        System.out.println("Enter an id: ");
//        int id = Integer.parseInt(input.nextLine());
        System.out.println("1. Enter task name: ");
        String taskName = input.nextLine();
        String createdDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("2. Enter a deadline: ");
        String deadline = input.nextLine();

//        int a = (ValidateUtils.toISODate(deadline)).compareTo(ValidateUtils.toTodayISO(LocalDate.now().toString()));
//        System.out.println(a);
       while (!ValidateUtils.isDateValid(deadline)|| (ValidateUtils.toISODate(deadline)).compareTo(ValidateUtils.toTodayISO(LocalDate.now().toString()))<0){
           System.out.println("Invalid deadline, please enter a valid deadline:  ");
           deadline = input.nextLine();
//           System.out.println(a);
       }

       User creator = UserView.findUserByUsername(SignIn.currentUsername);

        System.out.println("3. Enter number of performers: ");
        int numberOfPerfomers = Integer.parseInt(input.nextLine());
        String performers = "";
        for(int i = 0; i<numberOfPerfomers; i++){
            System.out.println("4. Enter ID of performer " + (i+1) + ": ");
            int performerID = Integer.parseInt(input.nextLine());

            performers += UserView.findUserById(performerID).getFullName() + " - ";
        }
        performers = performers.substring(0, performers.length()-2);
//        System.out.println("3. Enter ID of creator: ");
//        int creatorId = Integer.parseInt(input.nextLine());
//        User creator =  UserView.findUserById(creatorId);
        System.out.println("5. Add a description: ");
        String description = input.nextLine();

        Task task = new Task(taskName.trim(), createdDate.trim(), deadline.trim(), creator,numberOfPerfomers,performers.trim(), description.trim());
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
        System.out.println("---ALL TASKS-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-18s %-15s %-15s %-30s %-15s %-20s %-15s %-15s\n", "Id", "Task name", "Create day", "Deadline", "Created by", "Performers","Updated by", "Last update", "Status", "Description");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Task task : tasksList) {
            System.out.printf("%-10s %-20s %-18s %-15s %-15s %-30s %-15s %-20s %-15s %-15s\n", task.getId(), task.getTaskName(), task.getCreateDate(),
                    task.getDeadline(), task.getCreatedBy(),task.getPerformers(), task.getUpdatedBy(), task.getLastUpdate(), task.isStatus(), task.getDescription());
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    //Edit task
    public static void updateTask(){
        showAllTasks();
        tasksManagement.getTasks();
        int id;

       try {
           System.out.println("Enter ID of the task you want to update: ");
           id = Integer.parseInt(input.nextLine());

           while(!tasksManagement.existById(id)){
               System.out.println("ID does not exist, please enter a right ID : ");
               id = Integer.parseInt(input.nextLine());
           }
       }catch (Exception e){
           System.out.println("ID does not exist, please enter a right ID : ");
           id = Integer.parseInt(input.nextLine());
       }


        Task task = tasksManagement.getByTaskId(id);
        if(tasksManagement.checkDuplicateId(id)){
            System.out.println("------------------------------");
            System.out.println("|  1. Edit task name         |");
            System.out.println("|  2. Update deadline        |");
            System.out.println("|  3. Update status          |");
            System.out.println("|  4. Update description     |");
            System.out.println("|  5. Return                 |");
            System.out.println("------------------------------");
            System.out.println("Enter your choice: ");
            try {
                int choice = Integer.parseInt(input.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Enter new task name: ");
                        String newTaskname = input.nextLine();
                        task.setTaskName(newTaskname);
                        tasksManagement.update();
                        System.out.println("Successfully update task name!");
                        break;
                    case 2:
                        System.out.println("Enter new deadline: ");
                        String deadline = input.nextLine();
//        int a = (ValidateUtils.toISODate(deadline)).compareTo(ValidateUtils.toTodayISO(LocalDate.now().toString()));
//        System.out.println(a);
                        while (!ValidateUtils.isDateValid(deadline)|| (ValidateUtils.toISODate(deadline)).compareTo(ValidateUtils.toTodayISO(LocalDate.now().toString()))<0){
                            System.out.println("Invalid deadline, please enter a valid deadline:  ");
                            deadline = input.nextLine();
//        System.out.println(a);
                        }

                        task.setDeadline(deadline);
                        tasksManagement.update();
                        System.out.println("Successfully update deadline!");
                        break;
                    case 3:
                        boolean is = true;
                        do {
                            try {
                                System.out.println("Choose a status to update: ");
                                System.out.println("1. PENDING");
                                System.out.println("2. PROCESSING");
                                System.out.println("3. COMPLETED");
                                System.out.println("Enter your choice: ");
                                int selection = Integer.parseInt(input.nextLine());
                                switch (selection){
                                    case 1:
                                        task.setStatus(Status.PENDING);
                                        tasksManagement.update();
                                        System.out.println("Successfully update status!");
                                        break;
                                    case 2:
                                        task.setStatus(Status.PROCESSING);
                                        tasksManagement.update();
                                        System.out.println("Successfully update status!");
                                        break;
                                    case 3:
                                        task.setStatus(Status.COMPLETED);
                                        tasksManagement.update();
                                        System.out.println("Successfully update status!");
                                        break;
                                    default:
                                        WrongChoice.chooseWrong();
                                        is = false;

                                }
                            }catch (Exception e){
                                WrongChoice.chooseWrong();
                                is = false;
                            }
                        }while (!is);
                        break;
                    case 4:
                        System.out.println("Enter description: ");
                        String description = input.nextLine();
                        task.setDeadline(description);
                        tasksManagement.update();
                        System.out.println("Successfully update description!");
                        break;
                    case 5: Menu.showMainMenu();
                        break;
                    default:
                        WrongChoice.chooseWrong();
                        updateTask();
                }
            }catch (Exception e){
                WrongChoice.chooseWrong();
                updateTask();
            }finally {
                String lastUpdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
                task.setLastUpdate(lastUpdate);
                tasksManagement.update();
            }
        }

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


        for (Task task : tasksList) {
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------\n");


        System.out.printf("%-10s %-20s %-18s %-15s %-15s %-15s %-20s %-15s %-15s\n", "Id", "Task name", "Create day", "Deadline", "Created by", "Updated by", "Last update", "Status", "Description");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < tasksList.size(); i++) {

            if ((tasksList.get(i).getTaskName().toUpperCase()).contains(taskName)) {
                System.out.printf("%-10s %-20s %-18s %-15s %-15s %-15s %-20s %-15s %-15s\n", tasksList.get(i).getId(), tasksList.get(i).getTaskName(), tasksList.get(i).getCreateDate(),
                        tasksList.get(i).getDeadline(), tasksList.get(i).getCreatedBy(), tasksList.get(i).getUpdatedBy(), tasksList.get(i).getLastUpdate(), tasksList.get(i).isStatus(), tasksList.get(i).getDescription());
                count++;
            }

        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        if (count == 0) {
            System.out.println("Not found!");
        }
    }



}