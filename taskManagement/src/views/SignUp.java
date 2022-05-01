package views;

import management.IUsersManagement;
import model.Role;
import model.User;

import utils.ValidateUtils;

import java.util.Random;
import java.util.Scanner;

public class SignUp {
    public static IUsersManagement userSignUp;
    static Scanner input = new Scanner(System.in);
    public static void signUp() {
        try {
// Create ramdom id
            int id = 1;
            Random r = new Random();
            int low = 100;
            int high = 999;
            int number = r.nextInt(high-low) + low;

//            enter full name
            System.out.println("Enter your full name (ex: Thi Pham): ");
            String fullName = input.nextLine();
            while (!ValidateUtils.isFullNameValid(fullName)) {
                System.out.println(fullName + "does not match the format");
                System.out.println("Enter your full name (ex: Thi Pham): ");
                fullName = input.nextLine();
            }

//   enter email
            System.out.println("Enter your email (ex: thi152@gmail.com): ");
            String email = input.nextLine();
            while (!ValidateUtils.isEmailValid(email)) {
                System.out.println("Email" + email + " does not match the format. Please check and try again!");
                System.out.println("Enter your email (ex: thi152@gmail.com): ");
                email = input.nextLine();
            }
            while (userSignUp.checkDuplicateEmail(email)) {
                System.out.println("Email " + email + " has already existed, please try another email");
                System.out.println("Enter your email (ex: thi152@gmail.com): ");
                email = input.nextLine();
            }

//enter phone number
            System.out.println("Enter your phone number (ex: 0987456123): ");
            String phoneNumber = input.nextLine();
            while (!ValidateUtils.isPhoneValid(phoneNumber)) {
                System.out.println(phoneNumber + " does not match the format, please check and try again!");
                System.out.println("Enter your phone number (ex: 0987456123): ");
                phoneNumber = input.nextLine();
            }
            while (userSignUp.checkDuplicatePhone(phoneNumber)) {
                System.out.println("This phone number has already existed, please try another number");
                System.out.println("Enter your phone number (ex: 0987456123): ");
                phoneNumber = input.nextLine();

// enter user name
                System.out.println("Enter your username: ");
                String userName = input.nextLine();
                while (userSignUp.checkDuplicateUserName(userName)) {
                    System.out.println("This username has already existed, please enter another username!");
                    userName = input.nextLine();
                }

// enter password
                System.out.println("Enter your password (more than 8 characters");
                String password = input.nextLine();
                while (!ValidateUtils.isPasswordValid(password)) {
                    System.out.println("Weak password, please try another password!");
                    password = input.nextLine();

// Create user
                    User user = new User(id,fullName, email, phoneNumber, userName, password, Role.LEADER);
                    setRole(user);
                    userSignUp.add(user);
                    System.out.println("Sign up successfully!");
                }

            }
        } catch (Exception e) {
            System.out.println("Invalid input, please try again!");
            signUp();
        }

    }

        public static void setRole(User user) {
                System.out.println("Select a role: ");
                System.out.println("1. LEADER");
                System.out.println("2. MEMBER");
                int role = input.nextInt();
                input.nextLine();
                switch (role) {
                    case 1:
                        user.setRole(Role.LEADER);
                        break;
                    case 2:
                        user.setRole(Role.MEMBER);
                        break;
                    default:
                        System.out.println("Wrong input, please try again!");
                        setRole(user);
                }
            }
}


