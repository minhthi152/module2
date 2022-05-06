package stack.Palindrome;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new PriorityQueue<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = input.nextLine();
        for(int i = 0; i< str.length(); i++){
            stack.push(str.charAt(i)+"");
            queue.offer(str.charAt(i)+"");
        }
        for(int i = 0; i<str.length(); i++){
            System.out.print(stack.pop() + "  ");

        }
        System.out.println();
        for(int i = 0; i<str.length(); i++){
            System.out.print(queue.poll() + "  ");

        }

    }
}
