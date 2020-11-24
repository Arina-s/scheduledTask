package scheduledTask;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskScheduled implements Runnable {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Override
    public void run() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }

}
