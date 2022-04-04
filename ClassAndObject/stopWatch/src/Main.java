import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StopWatch watch1 = new StopWatch();
        System.out.println(watch1.start());

//        try{
//            Thread.sleep(2000);
//            // Then do something meaningful...
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }
        long[] array = new long[100000];
        for (int i = 0; i < array.length; i++){
            Random r = new Random();
            int low = 0;
            int high = 10000000;
            int number = r.nextInt(high-low) + low;
            array[i] = number;
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        System.out.println(watch1.stop());
        System.out.println(watch1.getElapsedTime());
    }
}
