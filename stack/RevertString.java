package stack;

import java.util.Scanner;
import java.util.Stack;

public class RevertString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String str = input.nextLine();
        Stack <String> stackString = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            stackString.push(str.charAt(i)+"");
        }
        System.out.println(stackString.size());
        for(int i = 0; i < str.length(); i++){
            System.out.print(stackString.pop());
        }
        System.out.println();
        System.out.println(stackString.size());


    }
}
