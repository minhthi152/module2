public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> ll = new MyLinkedList();
        ll.addFirst(1);
        ll.addFirst(3);
        ll.addLast(6);
        ll.add(6, 0);
        ll.add(10, 2);
        ll.printLinkedList();
        ll.add(100, 10);
        ll.printLinkedList();

    }
}
