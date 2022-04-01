import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a,b,c;
        System.out.print("Enter number a: ");
        a = input.nextInt();
        System.out.print("Enter number b: ");
        b = input.nextInt();
        System.out.print("Enter number c: ");
        c = input.nextInt();

        int i =1;
        while (true){
            if((a*i) % b != 0 || (a*i) % c !=0){
                i++;
                System.out.println(i);
                continue;
            }
            System.out.println(a*i + " is LCM of a, b and c");
            break;
        }
    }
}
