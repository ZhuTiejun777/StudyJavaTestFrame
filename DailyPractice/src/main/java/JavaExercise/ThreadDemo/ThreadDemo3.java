package JavaExercise.ThreadDemo;

public class ThreadDemo3 {

    public static void main(String[] args) {

        new Thread () {
            public void run () {
                for (int i = 0; i < 10000; i ++) {
                    System.out.println("java");
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i ++) {
                    System.out.println("python");
                }
            }
        }).start();

    }
}
