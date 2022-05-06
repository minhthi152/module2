public class ThreadExample2 extends Thread {
    @Override
    public void run() {
        super.run();
        for(int i = 0; i<1000; i++){
            System.out.println("Thread 2: " + i);
        }
    }
}
