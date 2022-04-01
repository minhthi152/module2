import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        double[] myArr = {1,2,3,4,5};
        String newArr = x2array(myArr);
//        x2array(myArr);
        System.out.println(newArr);
    }
    public static String x2array(double[] array){
        int i;
        for(i = 0; i < array.length; i++){
            array[i] = array[i]*2;
        }
        return Arrays.toString(array);
    }

}


