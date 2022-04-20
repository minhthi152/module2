package stack;

import java.util.Scanner;
import java.util.Stack;

public class BinaryNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int decimalNumber = input.nextInt();

        Stack<Integer> stackSurplus = new Stack<>();

        while(decimalNumber !=0){
            int surplus = decimalNumber % 2;
            stackSurplus.push(surplus);
            decimalNumber /=2;
        }
        System.out.printf("Binarny number of %d is: ", decimalNumber);
        int size = stackSurplus.size();
        for(int i =0; i < size; i++){
            System.out.print(stackSurplus.pop());
        }

    }
}
