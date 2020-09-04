package JavaExercise.ThreadDemo;

public class ThreadDemo2 {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        for (int i = 0; i < 10000; i ++) {
            System.out.println("java");
        }
    }
}
