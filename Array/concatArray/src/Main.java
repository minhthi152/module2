import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array1 = createArray();
        int[] array2 = createArray();
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

        System.out.println("Concatenate array1 and array2: ");
        System.out.println(Arrays.toString(concat(array1,array2)));


    }
//    Enter element to array
    public static int[] createArray(){

        System.out.println("Enter a size: ");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++){
            System.out.println("Enter element " + i + ":" );
            array[i] = input.nextInt();
        }
        return array;
    }
    private static int[] concat(int[] arr1, int[] arr2){
        int[] arr3 = new int[arr1.length + arr2.length];
        for(int i = 0; i < arr1.length; i++){
            arr3[i] = arr1[i];

        }
        for(int j = arr1.length, i = 0; j < arr3.length; j++, i++){
            arr3[j] = arr2[i];

        }
        return arr3;
    }
}
