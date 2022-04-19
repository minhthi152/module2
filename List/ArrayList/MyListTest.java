import java.util.Arrays;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<Integer>();
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addFirst(6);
        System.out.println(list);
        list.add(5,2);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.size();
        System.out.println(Arrays.toString(list.clone()));
        System.out.println(list.contains(4));
        System.out.println(list.contains(10));
        System.out.println(list.indexOf(3));
        System.out.println(list.indexOf(10));
        list.clear();
        System.out.println(list);

    }
}
