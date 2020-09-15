package JavaExercise.ThreadDemo;

public class Ticket extends Thread{

    private static int tickets = 1000;

    private static final Object object = new Object();

    public void run () {
        while (true) {
            synchronized (object) {
                if (tickets == 0) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + "...这是第" + tickets-- + "号票");
            }
        }
    }
}
