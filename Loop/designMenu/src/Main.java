import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0){
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice:");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Draw the triangle");
                    System.out.println("     *     ");
                    System.out.println("    ***    ");
                    System.out.println("   *****   ");
                    System.out.println("  ***S2**  ");
                    System.out.println(" ***THI*** ");
                    System.out.println("***********");
                    break;
                case 2:
                    System.out.println("Draw a square");
                    System.out.println("************");
                    System.out.println("*   THI    *");
                    System.out.println("*    DỄ    *");
                    System.out.println("*  THƯƠNG  *");
                    System.out.println("************");
                    break;
                case 3:
                    System.out.println("Draw a rectangle");
                    System.out.println("*******************");
                    System.out.println("**     DO YOU    **");
                    System.out.println("**      love     **");
                    System.out.println("**       ME      **");
                    System.out.println("*******************");

                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");

            }
        }



    }
}
