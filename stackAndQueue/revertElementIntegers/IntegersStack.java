package stack.revertElementIntegers;

import java.util.Scanner;
import java.util.Stack;

public class IntegersStack {


    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<Integer> newItegerStack = new Stack<>();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        int num;
        int size =0;
        do {
            num = input.nextInt();
            integerStack.push(num);
            size++;
        }while (size!=6);
        System.out.println(integerStack);
        for(int i = 0; i< size; i++){
//            System.out.print(integerStack.pop() + "  ");
           newItegerStack.push( integerStack.pop());
        }

        System.out.println(newItegerStack);
    }


}
