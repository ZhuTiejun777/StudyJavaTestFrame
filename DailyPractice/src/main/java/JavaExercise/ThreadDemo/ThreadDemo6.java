package JavaExercise.ThreadDemo;

public class ThreadDemo6 {

    public static void main(String[] args) {

        final Thread thread1 = new Thread() {
            public void run () {
                for (int i = 0; i < 10; i ++) {
                    System.out.println(this.getName() + "python");
                }
            }
        };

        Thread thread2 = new Thread() {
            public void run () {
                for (int i = 0; i < 10; i ++) {
                    System.out.println(this.getName() + "java");
                    if (i == 2) {
                        try {
                            // 加入线程
                            thread1.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        thread1.start();
        thread2.start();
    }

}
