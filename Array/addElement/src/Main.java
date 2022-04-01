import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr));

        Scanner input  = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = input.nextInt();
        System.out.println("Enter a position (index): ");
        int position = input.nextInt();

        System.out.print(Arrays.toString(add(arr, number, position)));

    }
    private static int[] add(int[] array, int number, int index){
        int[] newArray = new int[array.length +1];

        for(int i = 0; i < index; i++){
            newArray[i] = array[i];
        }
        newArray[index] = number;
        for(int j = index + 1, i = index; j < newArray.length; j++, i++){
            newArray[j] = array[i];
        }
        return newArray;
    }
}
