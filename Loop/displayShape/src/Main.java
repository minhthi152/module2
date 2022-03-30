import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 0){
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("1. Print the rectangle");
                    int width, height;
                    System.out.println("Enter the width: ");
                    width = input.nextInt();
                    System.out.println("Enter the height: ");
                    height = input.nextInt();

                    for( int i = 1; i <= height; i++ ){

                        for(int k = 1; k <= width; k++){
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                case 2:
                    System.out.println("1. Print the square triangle");
                    int sideLength;
                    System.out.println("Enter the length side: ");
                    sideLength = input.nextInt();
                   for (int i = 1; i <= sideLength; i++){
                       for (int k = 1; k <= i; k++){
                           System.out.print("*");
                       }
                       System.out.println();

                   }
                case 3:
                    System.out.println("1. Print the isosceles triangle");
                    int high, k = 0;
                    System.out.println("Enter the height: ");
                    high = input.nextInt();
                    for (int i = 1; i <= high; ++i, k = 0){
                        for (int space = 1; space <= high - i; ++space){
                            System.out.print(" ");
                        }
                        while(k != 2 * i -1){
                            System.out.print("*");
                            ++k;
                        }
                        System.out.println();


                    }

            }

        }

    }
}
