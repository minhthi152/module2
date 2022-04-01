import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = createMatrix();
        displayMatrix(matrix);
//        display matrix using deepToString
//        System.out.println(Arrays.deepToString(matrix));
        System.out.println("Max value in the matrix is: " + findMax(matrix));

    }
//    Create a Matrix
    public static int[][] createMatrix(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter row: ");
        int row = input.nextInt();
        System.out.println("Enter column: ");
        int column = input.nextInt();
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                Random r = new Random();
                int low = 0;
                int high = 100;
                int number = r.nextInt(high-low) + low;
                matrix[i][j] = number;
            }
        }
        return matrix;
    }
//    Display the matrix
    public static void displayMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
//    find Max Value
    public static int findMax(int[][] matrix){
       int max = matrix[0][0];
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if(max < matrix[i][j]){
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }
}
