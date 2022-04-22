import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestSearch {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5,6,7};
        int[] arr2 = new int[]{7,6,5,4,3,2,1};
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        System.out.println(Arrays.binarySearch(arr1,5));
        System.out.println(Arrays.binarySearch(arr2,3));
    }
}
