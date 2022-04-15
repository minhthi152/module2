package menu;
import java.util.Scanner;
public class MainMenu {
    public static void showMainMenu(){
        System.out.println("------------Menu------------");
        System.out.println("* 1. Add a new task        *");
        System.out.println("* 2. Show tasks            *");
        System.out.println("* 3. Delete task           *");
        System.out.println("* 4. Edit a task           *");
        System.out.println("* 0. Exit                  *");
        System.out.println("----------------------------");
        System.out.println("Enter your choice: ");
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
                        System.out.println("Please enter a number from 0 to 4!");
                        showMainMenu();
                }

            }
            catch (Exception e){
                System.out.println("Please enter a number from 0 to 4!");
                showMainMenu();
            }

        }

    }

    public static void showAddMenu(){
        System.out.println("------------Add task--------");
        System.out.println("* 1. Add a task            *");
        System.out.println("* 10. Back to home page     *");
        System.out.println("----------------------------");
        System.out.println("Enter your choice: ");
        int choice = -1;

        while (choice != 0){
            Scanner input = new Scanner(System.in);
            try{
                choice = input.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Add a task");;
                        break;
                    case 10:
                        showMainMenu();
                        break;
                    default:
                        System.out.println("Please enter a number 1 or 10!");
                        showAddMenu();
                }

            }
            catch (Exception e){
                System.out.println("Please enter a number from 1 or 10!");
                showAddMenu();
            }

        }

    }
    public static void showTasks(){
        System.out.println("-----------Show tasks-------");
        System.out.println("* 1. Show pending tasks     *");
        System.out.println("* 2. Show doing tasks       *");
        System.out.println("* 3. Show completed tasks   *");
        System.out.println("* 10. Back to home page     *");
        System.out.println("----------------------------");
        int choice = -1;

        while (choice != 0){
            Scanner input = new Scanner(System.in);
            try{
                choice = input.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Show pending tasks");;
                        break;
                    case 2:
                        System.out.println("Show doing tasks");
                        break;
                    case 3:
                        System.out.println("Show completed tasks");
                        break;
                    case 10:
                        showMainMenu();
                        break;
                    default:
                        System.out.println("Please enter a number 1, 2, 3 or 10!");
                        showTasks();
                }

            }
            catch (Exception e){
                System.out.println("Please enter a number  1, 2, 3 or 10!");
                showTasks();
            }

        }

    }
    public static void showDeleteMenu(){
        System.out.println("------------Delete----------");
        System.out.println("* 1. Delete a task          *");
        System.out.println("* 2. Delete all tasks       *");
        System.out.println("* 10. Back to home page     *");
        System.out.println("-----------------------------");
        int choice = -1;

        while (choice != 0){
            Scanner input = new Scanner(System.in);
            try{
                choice = input.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Delete a task");;
                        break;
                    case 2:
                        System.out.println("Delete all tasks");
                        break;
                    case 10:
                        showMainMenu();
                        break;
                    default:
                        System.out.println("Please enter a number 1, 2 or 10!");
                        showDeleteMenu();
                }

            }
            catch (Exception e){
                System.out.println("Please enter a number 1, 2 or 10!");
                showDeleteMenu();
            }

        }

    }
    public static void showEditMenu(){
        System.out.println("------------Edit-----------");
        System.out.println("* 1. Edit 1               *");
        System.out.println("* 2. Edit 2               *");
        System.out.println("* 10. Back to home page   *");
        System.out.println("---------------------------");
        int choice = -1;

        while (choice != 0){
            Scanner input = new Scanner(System.in);
            try{
                choice = input.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Edit 1");;
                        break;
                    case 2:
                        System.out.println("Edit 2");
                        break;
                    case 10:
                        showMainMenu();
                        break;
                    default:
                        System.out.println("Please enter a number 1, 2 or 10!");
                        showEditMenu();
                }

            }
            catch (Exception e){
                System.out.println("Please enter a number 1, 2 or 10!");
                showEditMenu();
            }

        }
    }
}
