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
        System.out.print(Arrays.toString(remove(arr, number)));

    }
//    private static int[] remove(int[] array, int number){
//        int index = 0;
//        for( int i = 0; i < array.length; i++){
//            if(number == array[i]){
//                index = i;
//            }
//        }
//        int[] newArray = new int[array.length -1];
//
//        for(int j = 0; j < index; j++){
//            newArray[j] = array[j];
//        }
//        for(int j = index; j < newArray.length; j++){
//            newArray[j] = array[j+1];
//        }
//        return newArray;
//    }




    private static int[] remove(int[] array, int number){
        int index = 0;
        int[] newArray = new int[array.length-1];
        for( int i = 0; i < array.length; i++){
            if(number == array[i]){
                index = i;
            }
        }

        for (int i = 0 , j = 0 ; i < array.length; i++) {
            if(i == index) {
                continue;
            }
            newArray[j] = array[i];
            j++;
        }
        return newArray;
    }
}