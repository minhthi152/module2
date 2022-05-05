package views;

import management.UsersManagement;
import model.User;
import notification.WrongChoice;
import utils.ValidateUtils;

import java.util.List;
import java.util.Scanner;

import static notification.ReturnToMenu.returnMainMenu;


public class UserView {
    public static UsersManagement usersManagement = UsersManagement.getInstance();
    static Scanner input = new Scanner(System.in);

    public static void showMembers() {
        System.out.println("----MEMBERS LIST---------------------------------------------------------------------------------------------------- ");
        System.out.printf("%-10s %-25s %-35s %-25s %-25s\n", "Id", "Full name", "Email", "Phone Number", "Username");
        System.out.println("---------------------------------------------------------------------------------------------------------------------  ");

        List<User> users = usersManagement.getUsers();
        for (User user : users) {
                System.out.printf("%-10s %-25s %-35s %-25s %-25s\n", user.getId(), user.getFullName(), user.getEmail(), user.getPhoneNumber(), user.getUserName());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------  ");
        System.out.println(" ");
    }


    public static void changeInfo() {
        try {
            showMembers();
            usersManagement.getUsers();
            System.out.println("Enter id account that you want to change information: ");
            int id = Integer.parseInt(input.nextLine());
            if (usersManagement.existById(id)) {
                System.out.println("---------------------------");
                System.out.println("|  1. Change email        |");
                System.out.println("|  2. Change phone number |");
                System.out.println("|  3. Change password     |");
                System.out.println("|  4. Return              |");
                System.out.println("---------------------------");
                System.out.println("Enter your choice: ");
                int choice = input.nextInt();
                User user = new User();
                user.setId(id);
                switch (choice) {
                    case 1:
                        System.out.println("Enter new email: ");
                        String email = input.nextLine();
                        while(!ValidateUtils.isEmailValid(email)){
                            System.out.println("Email" + email + " does not match the format. Please check and try again!");
                            System.out.println("Enter new email (ex: thi152@gmail.com): ");
                            email = input.nextLine();
                        }
                        while(usersManagement.checkDuplicateEmail(email)){
                            System.out.println("Email" + email + " has already existed. Please try another new one!");
                            System.out.println("Enter new email (ex: thi152@gmail.com): ");
                            email = input.nextLine();
                        }
                        user.setEmail(email);
                        usersManagement.update(user);
                        System.out.println("Successfully updated email.");
                        returnMainMenu();
                        break;
                    case 2:
                        System.out.println("Enter new phone number: ");
                        String phoneNumber = input.nextLine();
                        while (!ValidateUtils.isPhoneValid(phoneNumber)){
                            System.out.println("This phone number does not match the format. Please check and try again!");
                            System.out.println("Enter new phone number (ex: 0987654123): ");
                            phoneNumber = input.nextLine();
                        }
                        while(usersManagement.checkDuplicatePhone(phoneNumber)){
                            System.out.println("This phone number has already existed. Please try another new one!");
                            System.out.println("Enter new phone number (ex: 0987654123): ");
                            phoneNumber = input.nextLine();
                        }
                        user.setPhoneNumber(phoneNumber);
                        usersManagement.update(user);
                        System.out.println("Successfully updated email.");
                        returnMainMenu();

                        break;
                    case 3:
                        System.out.println("Enter your current password: ");
                        String curPassword = input.nextLine();
                        User curUser = usersManagement.getUserById(id);
                        while(!curPassword.equals(curUser.getPassword())){
                            System.out.println("Wrong password, please try again!");
                            curPassword = input.nextLine();
                        }
                            System.out.println("Enter new password: ");
                            String newPassword = input.nextLine();
                            user.setPassword(newPassword);
                            usersManagement.update(user);
                        System.out.println("Password updated successfully!");
                        returnMainMenu();
                        break;
                    case 4:
                        Menu.showMainMenu();
                        break;
                    default:
                        WrongChoice.chooseWrong();
                        changeInfo();
                }

            } else {
                System.out.println("This id does not exist. Please try again");
                changeInfo();
            }
        } catch (Exception e) {
            System.out.println("Please enter an id!");
            changeInfo();
        }
    }






    public static User findUserByUsername(String username) {
        List<User> usersList = usersManagement.getUsers();
        for (User user: usersList) {
            if(user.getUserName().equals(username)){
                return user;
            }
        }
        return null;
    }
}
