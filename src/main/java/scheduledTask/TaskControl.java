package scheduledTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

class TaskControl {

    static private TaskControl taskControl;

    private ScheduledExecutorService scheduler;

    private ScheduledFuture<?> beeperHandle;

    public TaskControl() {
        initScheduledExecutorService(1);
    }

    static public TaskControl getBeeperControl() {
        if (taskControl == null) {
            taskControl = new TaskControl();
        }
        return taskControl;
    }

    private void initScheduledExecutorService(int corePoolSize) {
        scheduler = Executors.newScheduledThreadPool(corePoolSize);
    }

    public void setScheduler(long delay) {
        cancelTask();
        initScheduledExecutorService(1);
        beeperHandle = scheduler.scheduleAtFixedRate(new TaskScheduled(), delay, delay, MILLISECONDS);
    }

    public void cancelTask() {
        if (beeperHandle != null) {
            beeperHandle.cancel(false);
        }
        scheduler.shutdown();
    }

}
