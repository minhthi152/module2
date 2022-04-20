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

//Add element at fist position
    public void addFirst(int value){
        Node temp = head;
        head = new Node(value);
        head.next =temp;
        size++;
    }
//    add element at last
    public void addLast(int value){
        Node temp = head;
        while (temp.next !=null){
                temp = temp.next;
        }
        temp.next = new Node(value);
        size++;
    }
//   Add element at a specified index position
    public void add(int value, int index){
        if(index==0){
            addFirst(value);
        }else{
//           create a node to add
            Node newNode = new Node(value);
//            find position to add
            Node curNode = head;
            int count = 0;
            while (curNode.next!= null){
                count ++;
                if(count == index){
//                    add
                    newNode.next = curNode.next;
                    curNode.next = newNode;
                        break;
                }
                curNode = curNode.next;
            }
        }
        size++;

    }
//remove first
    public void removeFirst(){

    }

//    Remove element at a specified index position




}
