package views;


import notification.Exit;
import notification.WrongChoice;

import java.util.Scanner;


public class Menu {
    static   Scanner input = new Scanner(System.in);

public static void homeMenu(){
    System.out.println("-----------*****------------");
    System.out.println("|        1. Sign in        |");
    System.out.println("|        2. Sign up        |");
    System.out.println("|        0. Exit           |");
    System.out.println("|__________________________|");
    System.out.println("Tell me your choice: ");
    int choice = -1;
    while(choice!=0){
       choice = Integer.parseInt(input.nextLine());
       switch (choice){
           case 1: SignIn.signIn();
           break;
           case 2: SignUp.signUp();
           break;
           case 0:
               Exit.exitProgram();
       }
    }
}
    public static void showMainMenu(){
        System.out.println("------------Menu------------");
        System.out.println("| 1. Add a new task        |");
        System.out.println("| 2. Show tasks            |");
        System.out.println("| 3. Delete task           |");
        System.out.println("| 4. Edit a task           |");
        System.out.println("| 5. Sort tasks            |");
        System.out.println("| 6. Search tasks          |");
        System.out.println("| 0. Exit                  |");
        System.out.println("|__________________________|");
        System.out.println("Enter your choice: ");
        int choice = -1;

        while (choice != 0){
            try{
                choice = Integer.parseInt(input.nextLine());
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
//                    case 5:
//                        showMenuSort();
//                        break;
                    case 6:
                        TaskList.searchTaskByName();
                    case 0:
                        Exit.exitProgram();
                        break;
                    default:
                        WrongChoice.chooseWrong();
                        showMainMenu();
                }

            }
            catch (Exception e){
                WrongChoice.chooseWrong();
                showMainMenu();
            }

        }

    }

    public static void showAddMenu(){
        int choice = -1;

        while (choice != 0){
            System.out.println("------------Add task--------");
            System.out.println("| 1. Add a task            |");
            System.out.println("| 10. Back to home page    |");
            System.out.println("----------------------------");
            System.out.println("Enter your choice: ");

            try{
                choice = input.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Add a task");
                        TaskList.addTask();
                        break;
                    case 10:
                        showMainMenu();
                        break;
                    default:
                        WrongChoice.chooseWrong();
                        showAddMenu();
                }

            }
            catch (Exception e){
                e.printStackTrace();
                WrongChoice.chooseWrong();
                showAddMenu();
            }

        }

    }
    public static void showTasks(){
        System.out.println("----------Show tasks---------");
        System.out.println("| 1. Show all tasks         |");
        System.out.println("| 2. Show pending tasks     |");
        System.out.println("| 3. Show doing tasks       |");
        System.out.println("| 4. Show completed tasks   |");
        System.out.println("| 10. Back to home page     |");
        System.out.println("-----------------------------");
        int choice = -1;

        while (choice != 0){
            Scanner input = new Scanner(System.in);

            try{
                choice = Integer.parseInt(input.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Show all tasks");
                        TaskList.showAllTasks();
                        break;
                    case 2:
                        System.out.println("Show pending tasks");;
                        break;
                    case 3:
                        System.out.println("Show doing tasks");
                        break;
                    case 4:
                        System.out.println("Show completed tasks");
                        break;
                    case 10:
                        showMainMenu();
                        break;
                    default:
                        WrongChoice.chooseWrong();
                        showTasks();
                }

            }
            catch (Exception e){
                WrongChoice.chooseWrong();
                showTasks();
            }

        }

    }
    public static void showDeleteMenu(){
        System.out.println("------------Delete----------");
        System.out.println("| 1. Delete a task          |");
        System.out.println("| 2. Delete all tasks       |");
        System.out.println("| 10. Back to home page     |");
        System.out.println("-----------------------------");
        int choice = -1;

        while (choice != 0){
            Scanner input = new Scanner(System.in);
            try{
                choice = Integer.parseInt(input.nextLine());
                switch (choice){
                    case 1:
                        TaskList.deleteTask();
                        break;
                    case 2:
                        System.out.println("Delete all tasks");
                        break;
                    case 10:
                        showMainMenu();
                        break;
                    default:
                        WrongChoice.chooseWrong();;
                        showDeleteMenu();
                }

            }
            catch (Exception e){
                WrongChoice.chooseWrong();;
                showDeleteMenu();
            }

        }

    }
    public static void showEditMenu(){
        System.out.println("------------Edit-----------");
        System.out.println("| 1. Edit a task          |");
        System.out.println("| 10. Back to home page   |");
        System.out.println("---------------------------");
        int choice = -1;

        while (choice != 0){
            Scanner input = new Scanner(System.in);
            try{
                choice = Integer.parseInt(input.nextLine());
                switch (choice){
                    case 1:
                        TaskList.editProduct();
                        break;
                    case 10:
                        showMainMenu();
                        break;
                    default:
                        WrongChoice.chooseWrong();
                        showEditMenu();
                }

            }
            catch (Exception e){
                WrongChoice.chooseWrong();
                showEditMenu();
            }

        }
    }
}
