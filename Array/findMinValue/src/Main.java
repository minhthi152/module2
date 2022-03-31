public class Main {
    public static void main(String[] args) {
        int[] arr = {100, 5, 8, 1, 7, 100, 5, 3};
        int index = minValue(arr);
        System.out.println("Min value of array is " + arr[index] + " at position " + (index + 1));

    }
    public static int minValue(int[] array){
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if(array[index] > array[i]){
                array[index] = array[i];
                index = i;
            }
        }
        return index;
    }
}
