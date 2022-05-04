package views;

import management.TasksManagement;
import model.Status;
import model.Task;

import java.util.List;
import java.util.Scanner;

import static utils.ValidateUtils.calculateDays;

public class Notice {

    public static TasksManagement tasksManagement = new TasksManagement();
    static Scanner input = new Scanner(System.in);
    public static void showNotice(){


        List<Task> tasksList = tasksManagement.getTasks();
        int count = 0;
        System.out.println("---HURRY UP!-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-18s %-15s %-15s %-30s %-15s %-20s %-15s %-15s\n", "Id", "Task name", "Create day", "Deadline", "Created by", "Performers","Updated by", "Last update", "Status", "Description");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Task task: tasksList) {

            long dif = calculateDays(task.getDeadline());
//            System.out.println(dif);
            if(dif<=7 && task.getStatus() != Status.COMPLETED &&  (task.getPerformers()).contains(UserView.findUserByUsername(SignIn.currentUsername).getFullName())){
//                System.out.println(dif);

                System.out.printf("%-10s %-20s %-18s %-15s %-15s %-30s %-15s %-20s %-15s %-15s\n", task.getId(), task.getTaskName(), task.getCreateDate(),
                        task.getDeadline(), task.getCreatedBy(),task.getPerformers(), task.getUpdatedBy(), task.getLastUpdate(), task.isStatus(), task.getDescription());
                count++;
            }

        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        if(count==0){
            System.out.println("Wow! you dont have any tasks this week.");
        } else if (count == 1) {
            System.out.println("You have 1 task need to be done in the next 7 days!!!");

        }else{
            System.out.println("You have " + count + " tasks need to be done in the next 7 days!!!");
        }



    }
}
