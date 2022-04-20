package stack.Queue.LinkedList;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(1000);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(10);
        queue.enqueue(40);
        queue.enqueue(60);

        queue.printLinkedListQueue();
        System.out.println("Dequeued item is " + queue.dequeue().key);
    }
}
