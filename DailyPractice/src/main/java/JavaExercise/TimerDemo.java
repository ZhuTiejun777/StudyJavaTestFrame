package JavaExercise;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

    public static void main(String[] args) throws InterruptedException {

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("java");
            }
        };

        Timer timer = new Timer();

        timer.schedule(timerTask, new Date(120, 8, 11, 11, 32, 30));

        while (true) {
            Thread.sleep(1000);
            System.out.println(new Date());
        }
    }
}
