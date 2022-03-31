import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size;

        Scanner input = new Scanner(System.in);
        do{
            System.out.println("Enter the size of array: ");
            size = input.nextInt();
            if (size > 10){
                System.out.println("Size does not exceed 10");

            }
        }while (size>10);
        int[] array= new int[size];
        int i = 0;
        while(i < array.length){
            System.out.println("Enter element" + (i+1) + " : ");
            array[i] = input.nextInt();
            i++;
        }
//        Print out array
        System.out.println("Property list: ");
        for(int j = 0; j < array.length; j++){
            System.out.print(array[j] + " ");
        }
//        Find Max Value in array
        int max = array[0];
        int index = 0;
        for (int j = 0; j < array.length; j++){
            if(array[j] > max){
                max = array[j];
                index = j;

            }
        }
        System.out.println(); // xuong dong thoi
        System.out.println("Max value of array is " + max + " found at index " + index);


    }

}
