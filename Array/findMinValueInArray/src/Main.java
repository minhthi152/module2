import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = createArray();
        System.out.println(Arrays.toString(array));
        System.out.println("Min value of the above array is " + findMin(array));

    }
    public static int[] createArray(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = input.nextInt();
        int[] array = new int[size];
        for( int i = 0; i < size; i++){
            System.out.print("Enter element " + i + ": ");
            array[i] = input.nextInt();
        }
        return array;
    }
    public static int findMin(int[] array){
        int min = array[0];
        for(int i = 1; i < array.length; i++){
            if(min > array[i]){
                min = array[i];
            }

        }
        return min;
    }

}
