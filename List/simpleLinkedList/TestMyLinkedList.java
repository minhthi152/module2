public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("-----TESTING-----");
        MyLinkedList ll = new MyLinkedList(1);
        ll.add(4, 7);
        ll.add(5, 6);
        ll.add(3,10);
        ll.add(2,11);
//        ll.addFirst(2);
//        ll.addFirst(3);
//        ll.addFirst(8);
        ll.printList();
//        System.out.println("----------");
//        System.out.println(ll.get(3));
    }
}
