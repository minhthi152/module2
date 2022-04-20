package stack.Queue.LinkedList;

public class MyLinkedListQueue {
    private Node head;
    private Node tail;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }
//    enqueue: Thêm đối tượng vào cuối Queue (hàng đợi)
     public void enqueue(int key){
        Node temp = new Node(key);
         if (this.head == null) {
             this.head = this.tail = temp;
             return;
         }
         this.tail.next = temp;
         this.tail = temp;
     }
//     DeQueue(): lấy đối tượng ở đầu queue ra khỏi hàng đợi
//     và trả về giá trị của nó. Nếu hàng đợi rỗng thì lỗi sẽ xảy ra.
    public Node dequeue() {
        if (this.head == null)
            return null;
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head == null)
            this.tail = null;
        return temp;
    }

    public void printLinkedListQueue(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            Node temp = head;
            while (temp != null){
                System.out.print(temp.key + "  ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
