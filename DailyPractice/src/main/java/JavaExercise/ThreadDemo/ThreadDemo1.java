package JavaExercise.ThreadDemo;

public class ThreadDemo1 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        for (int i = 0; i < 10000; i ++) {
            System.out.println("java");
        }
    }
}
