package JavaExercise.EruptSimultaneouslyDemo;

public class PrintDemo {

    // 静态方法只能直接调用静态变量,不可以直接调用成员变量,需要实例化
    // 成员方法可以直接调用成员变量,也可以直接调用静态变量
    private int flag = 1;
    private static int flagTest = 1;
    private Object object;

    /*public static void main(String[] args) {
        // 会报错,无法直接调用
        System.out.println(flag);
    }*/

    public void test () {
        System.out.println(flag);
        System.out.println(flagTest);
    }

    public void printDemo1 () throws InterruptedException {
        synchronized (this) {
            if (flag != 1) {
                this.wait(); // 设置线程等待，如果flag 不等于1
            }
            System.out.print("跟");
            System.out.print("我");
            System.out.print("一");
            System.out.print("起");
            System.out.println("念");
            flag = 2;
            this.notify(); // 设置flag等于2，使用线程唤醒功能，其他线程就可以启动
        }
    }

    public void printDemo2 () throws InterruptedException {
        synchronized (this) {
            if (flag != 2) {
                this.wait();  // 设置线程等待，如果flag 不等于2
            }
            System.out.print("做");
            System.out.print("测");
            System.out.print("试");
            System.out.print("死");
            System.out.print("路");
            System.out.print("一");
            System.out.println("条");
            flag = 1;
            this.notify();  //随机唤醒单个等待的线程
        }
    }
}
