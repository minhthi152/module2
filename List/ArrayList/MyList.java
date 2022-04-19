import java.util.Arrays;

public class MyList <E> {
    private int size =0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];

    }
// x2 capacity of list
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
//Add an element to the end
    public void addLast(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
//    get element
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }

//add an element to the first
    public void addFirst(E e){
        if (size == elements.length) {
            ensureCapa();
        }
        Object newElements[] = new Object[elements.length];
        for(int i = 0; i < elements.length-1; i++){
            newElements[i+1]= elements[i];
        }
        newElements[0] = e;
        size++;
        elements = newElements;
//        System.arraycopy(elements,0,elements,1,elements.length - 1);
//        elements[0] = e;
    }

//    add an element at the specified index position
    public void add(E e, int index){
        if (size == elements.length) {
            ensureCapa();
        }
        Object newElements[] = new Object[elements.length];
        for(int i = 0; i < index; i++){
            newElements[i] = elements[i];
        }
        newElements[index] = e;
        for(int i = index; i < elements.length-1; i++){
            newElements[i+1] = elements[i];
        }
        elements = newElements;
        size++;
    }

// Remove an element at the specified index position
    public void remove(int index){
        if (size == elements.length) {
            ensureCapa();
        }
        Object newElements[] = new Object[elements.length];
        for(int i = 0; i < index; i++){
            newElements[i] = elements[i];
        }
        for(int i = index; i < elements.length-1; i++){
            newElements[i] = elements[i+1];
        }
        size--;
        elements = newElements;
    }
//    get size of the list
    public void size(){
        System.out.println(size);
    }
//    clone the list
    public Object[] clone(){
        Object newElements[] = new Object[elements.length];
        for(int i = 0; i < elements.length; i++){
            newElements[i] = elements[i];
        }
        return newElements;
    }
// Check an element is contained in the list

    public boolean contains(E e){
        for(int i = 0; i< elements.length; i++){
            if(e.equals(elements[i])){
                return true;
            }
        }
        return false;
    }

//    indexOf
    public int indexOf(E e){
        for(int i = 0; i < elements.length; i++){
            if(e.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }

//    clear
    public void clear(){
        for(int i = 0; i < elements.length; i++){
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
