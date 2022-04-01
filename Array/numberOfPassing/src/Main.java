import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size;


        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter a size: ");
            size = input.nextInt();
            if (size > 30) {
                System.out.println("Size does not exceed 30");
            }
        } while (size > 30);
        int[] list = new int[size];
        for (int i = 0; i < list.length; i++) {
            System.out.println("Enter a mark for student " + (i + 1) + ": ");
            list[i] = input.nextInt();
        }
        int count = 0;
        System.out.printf("%-15s", "List of mark: ");
        for (int j = 0; j < list.length; j++) {
            System.out.print(list[j] + "\t");
            if (list[j] >= 5 && list[j] <= 10) {
                count++;
            }
        }
        System.out.print("\n The number of students passing the exam is " + count);
    }
}
