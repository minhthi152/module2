package notification;

import java.util.Scanner;

import static views.Menu.showMainMenu;

public class ReturnToMainMenu {
    static Scanner input = new Scanner(System.in);
    public static void returnMainMenu(){
        System.out.println("Enter r to return: ");
        String r = input.nextLine();
        while(!r.equals("r")){
            try {
                System.out.println("Enter r to return: ");
                r = input.nextLine();
            }catch (Exception e){
                System.out.println("Enter r to return: ");
                r = input.nextLine();
            }
        }
        showMainMenu();
        }

}
