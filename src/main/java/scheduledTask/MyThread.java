package scheduledTask;

class MyThread implements Runnable {

    private int delay;
    private int sleepTime;

    public MyThread(int delay, int sleepTime) {

        this.delay = delay;
        this.sleepTime = sleepTime;
    }

    public void run() {
        try {
            Thread.sleep(sleepTime);
            System.out.println("I woke up!");
            System.out.println("Changing to: " + delay);
            TaskControl.getBeeperControl().setScheduler(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
