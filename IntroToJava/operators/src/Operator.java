import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter width: ");
        width = scanner.nextFloat();
        System.out.print("Enter height: ");
        height = scanner.nextFloat();
        float area = width * height;
        System.out.print("Area is: " + area);

    }
}
