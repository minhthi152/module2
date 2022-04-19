public class MyLinkedList<E> {
    private Node head;
    private int size =1;

    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public void printLinkedList(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            Node temp = head;
            while (temp != null){
                System.out.print(temp.value + "  ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

//Them phan tu vao dau
    public void addFirst(int value){
        Node temp = head;
        head = new Node(value);
        head.next =temp;
        size++;
    }
//    Them phan tu vao sau
    public void addLast(int value){
        Node temp = head;
        while (temp.next !=null){
                temp = temp.next;
        }
        temp.next = new Node(value);
        size++;
    }
//    Them phan tu vao vi tri bat ky
    public void add(int value, int index){
        if(index==0){
            addFirst(value);
        }else{
//            tao node de add
            Node newNode = new Node(value);
//            tim vi tri can add
            Node curNode = head;
            int count = 0;
            while (curNode.next!= null){
                count ++;
                if(count == index){
//                    thuc hien add vao
                    newNode.next = curNode.next;
                    curNode.next = newNode;
                        break;
                }
                curNode = curNode.next;
            }
        }
        size++;

    }

//    Remove phan tu tai vi tri xac dinh
    

}
