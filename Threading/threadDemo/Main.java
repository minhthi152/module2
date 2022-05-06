public class Main {
    public static void main(String[] args) {
        ThreadExample1 threadExample1 = new ThreadExample1();
        Thread t1 = new Thread(threadExample1);
        ThreadExample2 t2 = new ThreadExample2();

        t1.start();
        t2.start();
    }
}



