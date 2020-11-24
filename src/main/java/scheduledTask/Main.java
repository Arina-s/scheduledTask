package scheduledTask;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new MyThread(2_000, 0));
        thread1.start();
        thread1.join();

        Thread thread2 = new Thread(new MyThread(1_000, 6_000));
        thread2.start();
        thread2.join();

        Thread thread3 = new Thread(new MyThread(4_000, 5_000));
        thread3.start();
        thread3.join();

        Thread thread4 = new Thread(new MyThread(5_000, 16_000));
        thread4.start();
        thread4.join();

        Thread thread5 = new Thread(new MyThread(1_000, 15_000));
        thread5.start();
    }

}
