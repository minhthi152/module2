package views;

import management.ITasksManagement;
import management.IUsersManagement;
import management.TasksManagement;
import management.UsersManagement;
import model.*;
import notification.WrongChoice;
import services.IPermissionService;
import services.PermissionService;
import utils.ValidateUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static notification.ReturnToMenu.returnOrContinueUpdateTask;
import static views.Menu.showMainMenu;

public class TaskList {
    public static ITasksManagement tasksManagement = new TasksManagement();
    public static IUsersManagement usersManagement = UsersManagement.getInstance();
    public static IPermissionService permissionService = PermissionService.getInstance();

    static Scanner input = new Scanner(System.in);

    //Add a task to task list
    public static void addTask() {
        User currentUser = UserView.findUserByUsername(SignIn.currentUsername);
        assert currentUser != null;
//            System.out.println(fullName);
//            System.out.println(permissionType);
//            System.out.println(currentUser.getRole());

        if (!currentUser.getRole().equals(Role.LEADER)) {
            System.out.println("Oops! You do not have the right to add a task :(");
            System.out.println("This is only for team leader");
            showMainMenu();
        } else {
            tasksManagement.getTasks();
            permissionService.getPerformers();
//        System.out.println("Enter an id: ");
//        int id = Integer.parseInt(input.nextLine());
            System.out.println("1. Enter task name: ");
            String taskName = input.nextLine();
            String createdDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            System.out.println("2. Enter a deadline: ");
            String deadline = input.nextLine();

//        int a = (ValidateUtils.toISODate(deadline)).compareTo(ValidateUtils.toTodayISO(LocalDate.now().toString()));
//        System.out.println(a);
            while (!ValidateUtils.isDateValid(deadline) || (ValidateUtils.toISODate(deadline)).compareTo(ValidateUtils.toTodayISO(LocalDate.now().toString())) < 0) {
                System.out.println("Invalid deadline, please enter a valid deadline:  ");
                deadline = input.nextLine();
//           System.out.println(a);
            }

            User creator = UserView.findUserByUsername(SignIn.currentUsername);


//        int numberOfPerfomers = -1;
//        do {
//            System.out.println("3. Enter a number of performer (from 1 to 5): ");
//            String temp = input.nextLine();
//            if (!ValidateUtils.isNumberFrom1To5Valid(temp)) {
//                System.out.println("You enter an invalid input, please try again! ");
//                continue;
//            }
//            numberOfPerfomers = Integer.parseInt(temp);
//            break;
//        } while (true);


//        String performers = "";
//        for (int i = 0; i < numberOfPerfomers; i++) {
//            System.out.println("4. Enter ID of performer " + (i + 1) + ": ");
//            int performerID = Integer.parseInt(input.nextLine());
//
//            performers += usersManagement.getUserById(performerID).getFullName() + " - ";
//        }
//        performers = performers.substring(0, performers.length() - 2);


//        System.out.println("3. Enter ID of creator: ");
//        int creatorId = Integer.parseInt(input.nextLine());
//        User creator =  UserView.findUserById(creatorId);
            System.out.println("5. Add a description: ");
            String description = input.nextLine();
            // Task task = new Task(taskName.trim(), createdDate.trim(), deadline.trim(), creator, numberOfPerfomers, performers.trim(), description.trim());
            Task task = new Task(taskName.trim(), createdDate.trim(), deadline.trim(), creator, Status.PENDING, description);
            tasksManagement.addTask(task);
            System.out.println("Successfully added task!");
            System.out.println("Please enter performers: ");

            //    permissions = new ArrayList<>();
            boolean isRetry;
            do {
                UserView.showMembers();

                int performerID;

                do {
                    System.out.println("Enter ID of performer: ");
                    String temp = input.nextLine();
                    if (!ValidateUtils.isNumberValid(temp)) {
                        System.out.println("You enter an invalid input, please try again! ");
                        continue;
                    }
                    performerID = Integer.parseInt(temp);
                    if (usersManagement.getUserById(performerID) == null) {
                        System.out.println("Wrong ID! please try another ID of performer: ");
                        continue;
                    }

                    if (permissionService.existByIdInEachTask(task.getId(), performerID)) {
                        System.out.println("This member is already in this task, please add an another one: ");
                        continue;
                    }
                    break;
                } while (true);

                User performer = usersManagement.getUserById(performerID);

                int rID;
                Random r = new Random();
                int low = 100;
                int high = 999;
                do {
                    rID = r.nextInt(high - low) + low;
                } while (permissionService.existById(rID));
                //Option allocate right for performer
//                 READ, UPDATE, CREATE_UPDATE ,CREATE_UPDATE_DELETE;
                int value = -1;
                boolean check = false;
                System.out.println("Choose the right for performer: ");
                System.out.println("0. Read only");
                System.out.println("1. Update");
                System.out.println("3. Update and delete");
                do {

                    try {
                        value = Integer.parseInt(input.nextLine());

                        if (value < -1 || value > 3) {
                            System.out.println("Please enter a number!");
                            check = true;
                        }
                    } catch (Exception e) {
                        System.out.println("Please enter a number!");
                        check = true;
                    }
                } while (check);


                Performers permission = new Performers(rID, performer.getId(), task.getId(), performer.getFullName(), PermissionType.parsePermissionType(value));
                System.out.println(permission);
                permissionService.add(permission);


                System.out.println("Do you want to add more performer? \n Enter y to add or enter other keys to skip adding.");
                String choice = input.nextLine();
                if (choice.equals("y")) {
                    isRetry = true;
                } else {
                    break;
                }
            } while (isRetry);

            System.out.println("Enter y to continue adding or any other key to return");
            String choice = input.nextLine();
            switch (choice) {
                case "y":
                    addTask();
                    break;
                default:
                    Menu.showMainMenu();
                    break;
            }

        }

    }

    //    Show task
    public static void showAllTasks() {
        List<Task> tasksList = tasksManagement.getTasks();
        List<Performers> performers = permissionService.getPerformers();
        System.out.println("---ALL TASKS-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-17s %-17s %-15s %-15s %-15s %-15s %-30s %-15s %-15s\n", "Id", "Task name", "Create day", "Deadline", "Created by", "Updated by", "Last update", "Status", "Description");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Task task : tasksList) {
            System.out.printf("%-17s %-17s %-15s %-15s %-15s %-15s %-30s %-15s %-15s\n", task.getId(), task.getTaskName(), task.getCreateDate(), task.getDeadline(), task.getCreatedBy(), task.getUpdatedBy(), task.getLastUpdate(), task.isStatus(), task.getDescription());
            for (Performers performer : performers) {
                if (performer.getTaskId() == task.getId())
                    System.out.printf("%-17s %-23s\n", performer.getFullName(), performer.getPermissionType());
            }
            System.out.print("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        }

    }

    //Edit task
    public static void updateTask() {
        showAllTasks();
        tasksManagement.getTasks();

        boolean accept = false;
        long taskId = -1;
        do {
            System.out.println("4. Enter the task ID that you want to update: ");
            String temp = input.nextLine();
            if (!ValidateUtils.isNumberValid(temp) || !tasksManagement.existById(Long.parseLong(temp))) {
                System.out.println("You enter an invalid ID, please try again! ");
                continue;
            }
            taskId = Long.parseLong(temp);
            String performersStr = "";
            for (Performers performer : permissionService.findByTaskId(taskId)) {
                performersStr += performer.getFullName();
            }

            User currentUser = UserView.findUserByUsername(SignIn.currentUsername);

            assert currentUser != null;
            String fullName = currentUser.getFullName();
            PermissionType permissionType = permissionService.findPermissionType(taskId, fullName);

//            System.out.println(fullName);
//            System.out.println(permissionType);
//            System.out.println(currentUser.getRole());


            if (currentUser.getRole().equals(Role.LEADER) ||
                    (performersStr.contains(fullName) && permissionType != null && !permissionType.equals(PermissionType.READ_ONLY))) {
                accept = true;
            } else {
                System.out.println("Oops! You dont have the right to update this task :( ");
                System.out.println("Please choose another task that you have the right to update.");
                updateTask();
            }


        } while (!accept);


        Task task = tasksManagement.getByTaskId(taskId);
        String lastUpdate;
        User updatedBy;
        if (tasksManagement.checkDuplicateId(taskId)) {
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
                switch (choice) {
                    case 1:
                        System.out.println("Enter new task name: ");
                        String newTaskname = input.nextLine();
                        task.setTaskName(newTaskname);
                        lastUpdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
                        task.setLastUpdate(lastUpdate + " task name");
                        updatedBy = UserView.findUserByUsername(SignIn.currentUsername);
                        task.setUpdatedBy(updatedBy.getFullName());
                        tasksManagement.update();
                        System.out.println("Successfully update task name!");
                        returnOrContinueUpdateTask();
                        break;
                    case 2:
                        System.out.println("Enter new deadline: ");
                        String deadline = input.nextLine();
//        int a = (ValidateUtils.toISODate(deadline)).compareTo(ValidateUtils.toTodayISO(LocalDate.now().toString()));
//        System.out.println(a);
                        while (!ValidateUtils.isDateValid(deadline) || (ValidateUtils.toISODate(deadline)).compareTo(ValidateUtils.toTodayISO(LocalDate.now().toString())) < 0) {
                            System.out.println("Invalid deadline, please enter a valid deadline:  ");
                            deadline = input.nextLine();
//        System.out.println(a);
                        }

                        task.setDeadline(deadline);
                        lastUpdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
                        task.setLastUpdate(lastUpdate + " deadline");
                        updatedBy = UserView.findUserByUsername(SignIn.currentUsername);
                        task.setUpdatedBy(updatedBy.getFullName());
                        tasksManagement.update();
                        System.out.println("Successfully update deadline!");
                        returnOrContinueUpdateTask();
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
                                switch (selection) {
                                    case 1:
                                        task.setStatus(Status.PENDING);
                                        lastUpdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
                                        task.setLastUpdate(lastUpdate + " status");
                                        updatedBy = UserView.findUserByUsername(SignIn.currentUsername);
                                        task.setUpdatedBy(updatedBy.getFullName());
                                        tasksManagement.update();

                                        System.out.println("Successfully update status!");
                                        break;
                                    case 2:
                                        task.setStatus(Status.PROCESSING);
                                        lastUpdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
                                        task.setLastUpdate(lastUpdate + " status");
                                        updatedBy = UserView.findUserByUsername(SignIn.currentUsername);
                                        task.setUpdatedBy(updatedBy.getFullName());
                                        tasksManagement.update();
                                        System.out.println("Successfully update status!");
                                        break;
                                    case 3:
                                        task.setStatus(Status.COMPLETED);
                                        lastUpdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
                                        task.setLastUpdate(lastUpdate + " status");
                                        updatedBy = UserView.findUserByUsername(SignIn.currentUsername);
                                        task.setUpdatedBy(updatedBy.getFullName());
                                        tasksManagement.update();
                                        System.out.println("Successfully update status!");
                                        break;
                                    default:
                                        WrongChoice.chooseWrong();
                                        is = false;

                                }
                            } catch (Exception e) {
                                WrongChoice.chooseWrong();
                                is = false;
                            }
                        } while (!is);
                        returnOrContinueUpdateTask();
                        break;
                    case 4:
                        System.out.println("Enter description: ");
                        String description = input.nextLine();
                        task.setDeadline(description);
                        lastUpdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
                        task.setLastUpdate(lastUpdate + " description");
                        updatedBy = UserView.findUserByUsername(SignIn.currentUsername);
                        task.setUpdatedBy(updatedBy.getFullName());
                        tasksManagement.update();
                        System.out.println("Successfully update description!");
//                        returnOrContinueUpdateTask();
                        break;
                    case 5:
                        Menu.showMainMenu();
                        break;
                    default:
                        WrongChoice.chooseWrong();
                        updateTask();
                }
            } catch (Exception e) {
                WrongChoice.chooseWrong();
                updateTask();
            } finally {

                tasksManagement.update();
            }
        }

    }

    //Delete a task
    public static void deleteTask() {
        showAllTasks();

        boolean accept = false;
        long taskId = -1;
        do {
            System.out.println("4. Enter the task ID that you want to delete: ");
            String temp = input.nextLine();
            if (!ValidateUtils.isNumberValid(temp) || !tasksManagement.existById(Long.parseLong(temp))) {
                System.out.println("You enter an invalid ID, please try again! ");
                continue;
            }
            taskId = Long.parseLong(temp);
            String performersStr = "";
            for (Performers performer : permissionService.findByTaskId(taskId)) {
                performersStr += performer.getFullName();
            }

            User currentUser = UserView.findUserByUsername(SignIn.currentUsername);

            assert currentUser != null;
            String fullName = currentUser.getFullName();
            PermissionType permissionType = permissionService.findPermissionType(taskId, fullName);

//            System.out.println(fullName);
//            System.out.println(permissionType);
//            System.out.println(currentUser.getRole());


            if (currentUser.getRole().equals(Role.LEADER) ||
                    (performersStr.contains(fullName) && permissionType != null && permissionType.equals(PermissionType.UPDATE_DELETE))) {
                accept = true;
            } else {
                System.out.println("Oops! You DO NOT have the right to delete this task :( ");
                System.out.println("Please choose another task that you have the right to delete.");
                deleteTask();
            }

//            break;

        } while (!accept);


//        long id = -1;
//
//        do {
//            System.out.println("3. Enter Enter the id of the task you want to delete: ");
//            String temp = input.nextLine();
//            if (!ValidateUtils.isNumberValid(temp)) {
//                System.out.println("You enter an invalid input, please try again! ");
//                continue;
//            }
//            id = Long.parseLong(temp);
//            break;
//        } while (true);


        Task task = tasksManagement.getByTaskId(taskId);
//        if (task == null) {
//            System.out.println("Task with ID " + taskId + " does not exist!");
//        } else {

        tasksManagement.remove(task);
        System.out.println("Task removed successfully!");

        System.out.println("Enter y to continue deleting or any other key to return");
        String choice = input.nextLine();
        switch (choice) {
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
        List<Performers> performers = permissionService.getPerformers();
        System.out.println("Enter name of the task that you want to search: ");
        String taskName = input.nextLine().toUpperCase();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int count = 0;

        System.out.println("---ALL TASKS-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-17s %-23s %-15s %-15s %-15s %-15s %-20s %-15s %-15s\n", "Id", "Task name", "Create day", "Deadline", "Created by", "Updated by", "Last update", "Status", "Description");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < tasksList.size(); i++) {

            if ((tasksList.get(i).getTaskName().toUpperCase()).contains(taskName)) {
                System.out.printf("%-17s %-23s %-15s %-15s %-15s %-15s %-20s %-15s %-15s\n", tasksList.get(i).getId(), tasksList.get(i).getTaskName(), tasksList.get(i).getCreateDate(), tasksList.get(i).getDeadline(), tasksList.get(i).getCreatedBy(), tasksList.get(i).getUpdatedBy(), tasksList.get(i).getLastUpdate(), tasksList.get(i).isStatus(), tasksList.get(i).getDescription());
                count++;
                for (Performers performer : performers) {
                    if (performer.getTaskId() == tasksList.get(i).getId())
                        System.out.printf("%-17s %-23s\n", performer.getFullName(), performer.getPermissionType());
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            }

        }
        if (count == 0) {
            System.out.println("Not found!");
        }
    }


}