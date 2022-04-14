package menu;

import java.util.Scanner;
public class MainMenu {
    public static void main(String[] args) {
        showMainMenu();

    }


    public static void showMainMenu(){
        System.out.println("------------Menu------------");
        System.out.println("* 1. Add a new task        *");
        System.out.println("* 2. Show tasks            *");
        System.out.println("* 3. Delete task           *");
        System.out.println("* 4. Edit a task           *");
        System.out.println("* 0. Exit                  *");
        System.out.println("----------------------------");
        System.out.println("Enter your choice: ");
        showSelection();
    }
    public static void showDeleteMenu(){
        System.out.println("------------Delete----------");
        System.out.println("* 1. Delete a task          *");
        System.out.println("* 2. Delete all tasks       *");
        System.out.println("* 10. Back to home page     *");
        System.out.println("----------------------------");

    }
    public static void showAddMenu(){
        System.out.println("------------Add task--------");
        System.out.println("* 1. Add a task            *");
        System.out.println("* 10. Back to home page     *");
        System.out.println("----------------------------");

    }
    public static void showTasks(){
        System.out.println("-----------Show tasks-------");
        System.out.println("* 1. Show pending tasks     *");
        System.out.println("* 2. Show doing tasks       *");
        System.out.println("* 3. Show completed tasks   *");
        System.out.println("* 10. Back to home page     *");
        System.out.println("----------------------------");
    }
    public static void showEditMenu(){
        System.out.println("------Choose a task to edit----");
        showTasks();
    }


    public static void showSelection(){
        int choice = -1;

        while (choice != 0){
            Scanner input = new Scanner(System.in);
            try{
                choice = input.nextInt();
                switch (choice){
                    case 1:
                        showAddMenu();
                        break;
                    case 2:
                        showTasks();
                        break;
                    case 3:
                        showDeleteMenu();
                        break;
                    case 4:
                        showEditMenu();
                        break;
                    case 0:
                        System.out.println("-----end program-----");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("No choice!");

                }

            }
            catch (Exception e){
                System.out.println("Please enter a number!");
                showMainMenu();
            }

        }
    }
}
