package views;

import management.IUsersManagement;
import management.UsersManagement;

import java.util.Scanner;

import static notification.Exit.exitProgram;
import static notification.TryAgainOrExit.tryAgainOrExit;
import static notification.WrongChoice.chooseWrong;

public class SignIn {
public static IUsersManagement userSignIn = new UsersManagement();
static Scanner input = new Scanner(System.in);
    public static void signIn() {
        System.out.println("________________ SIGN IN _________________");
        System.out.println("1. Enter username");
        String username = input.nextLine();
        System.out.println("2. Enter password: ");
        String password = input.nextLine();
        if (userSignIn.login(username, password) == null) {
            System.out.println("Wrong username or password");
            tryAgain();
        } else {
            System.out.println("Sign in successfully! \n");
            System.out.println("Welcome to i-Tasks!");
            Menu.showMainMenu();
        }
    }

    public static void tryAgain() {
        tryAgainOrExit();
        String choice = input.nextLine();
        switch (choice) {
            case "y":
                signIn();
                break;
            case "n":
                exitProgram();
                break;
            default:
                chooseWrong();
                tryAgainOrExit();
                tryAgain();
        }
    }

}
