import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr, int value) {
        int low = 0, high = arr.length - 1;
        System.out.println(high);
        while (high >= low) {
            int mid = (low + high) / 2;
            System.out.println(mid);
            if (value == arr[mid]) {
                return mid;

            } else if (value > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,7,10,19,100};
        System.out.println(Arrays.toString(array));
        System.out.println(binarySearch(array, 19));
    }

}
