import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a, b, c: ");
        double a, b, c;
        Scanner input = new Scanner(System.in);
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();

        QuadraticEquation equation1 = new QuadraticEquation(a,b,c);
        if(equation1.getDiscriminant()>0){
            System.out.println("The above equation has 2 solutions: \nx1 = " + equation1.getRoot1() + "\nx2 = " + equation1.getRoot2());
        }else if(equation1.getDiscriminant()==0){
            System.out.println("The equation has 1 solutions: \nx = " + equation1.getDoubleRoot());
        }else{
            System.out.println("Oops! The equation has no solutions.");
        }





    }
}
