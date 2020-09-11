package JavaExercise.ThreadDemo;

public class ThreadDemo5 {

    public static void main(String[] args) {

        Thread thread1 = new Thread() {
            public void run () {
                for (int i = 0; i < 2; i ++) {
                    System.out.println(this.getName() + ": java");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread2 = new Thread() {
            public void run () {
                for (int i = 0; i < 50; i ++) {
                    System.out.println(this.getName() + ": python");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //true就设置为守护线程
        thread2.setDaemon(true);

        thread1.start();
        thread2.start();

    }
}
