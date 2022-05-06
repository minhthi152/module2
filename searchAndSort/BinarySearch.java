import student.Person;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(Person[] arr, String name) {
        int low = 0, high = arr.length - 1;
        System.out.println(high);
        while (high >= low) {
            int mid = (low + high) / 2;
            System.out.println(mid);
            if (name.compareTo(arr[mid].getName())==0) {
                return mid;

            } else if (name.compareTo(arr[mid].getName())>0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        binarySearch(persons,"Timmy");
    }

}
