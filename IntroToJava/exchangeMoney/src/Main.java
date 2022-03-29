import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double usd;
        double result;
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter amount of money USD: ");
        usd = myScanner.nextDouble();
        result = usd * 23000;
        System.out.print("Equal to " + result + " VND");

    }
}
