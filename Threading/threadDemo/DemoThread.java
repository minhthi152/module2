public class DemoThread {
    public static void main(String[] args) {
        CuuChuong cuuChuong = new CuuChuong();

        Thread thread1 = new Thread(new MyRunnable(cuuChuong,9), "Thread1");
        Thread thread2 = new Thread(new MyRunnable(cuuChuong,5), "Thread1");
        thread1.start();
        thread2.start();
    }

    static class MyRunnable implements Runnable {
        private final CuuChuong cuuChuong;
        private final int number;

        public MyRunnable(CuuChuong cuuChuong, int number) {
            this.cuuChuong = cuuChuong;
            this.number = number;
        }

        @Override
        public void run() {
            cuuChuong.show(number);
        }
    }

    static class CuuChuong {
        public synchronized void show(int number) {
            for (int i = 1; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("\n%d * %d=%d", i, number, number * i);
            }
        }
    }
}