import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = createMatrix();
        displayMatrix(matrix);
        System.out.println(getSumOfColumn(matrix));
        System.out.println(getSumOfMainDiagonal(matrix));
    }
    static int[][] createMatrix(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of row: ");
        int row = input.nextInt();
        System.out.println("Enter number of column: ");
        int column = input.nextInt();
        int[][] matrix = new int[row][column];
        for( int i = 0; i < row; i++){
            for ( int j = 0; j < column; j++){
                Random r = new Random();
                int low = 0;
                int high = 100;
                int number = r.nextInt(high-low) + low;
                matrix[i][j] = number;
            }
        }
        return matrix;
    }
    //Display the matrix
    public static void displayMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
// Calculate sum of a colum
public static int getSumOfColumn(int[][] matrix){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the column that you want to calculate sum: ");
    int col = input.nextInt();
    int sum = 0;
    for(int i = 0; i < matrix.length; i++){
        sum += matrix[i][col-1];
    }
    return sum;
}
// Calculate sum of duong cheo matrix
public static int getSumOfMainDiagonal(int[][] matrix){
    Scanner input = new Scanner(System.in);
    System.out.println("Sum of the main diagonal is: ");
    int sum = 0;
    for(int i = 0; i < matrix.length; i++){
        sum += matrix[i][i];
    }
    return sum;
}

}
