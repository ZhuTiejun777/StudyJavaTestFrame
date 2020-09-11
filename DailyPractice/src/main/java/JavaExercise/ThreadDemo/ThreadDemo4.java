package JavaExercise.ThreadDemo;

public class ThreadDemo4 {

    public static void main(String[] args) throws InterruptedException {

        // 通过构造方法为线程命名
        new Thread ("ThreadOne") {
            public void run () {
                System.out.println(getName() + ": java");
            }
        }.start();

        // 通过setName()方法为线程命名
        new Thread () {
            public void run () {
                setName("ThreadTwo");
                System.out.println(Thread.currentThread().getName() + ": python");
            }
        }.start();

        // 获取当前线程的名称
        System.out.println(Thread.currentThread().getName());

        // 线程休眠
        Thread.sleep(1000);
    }
}
