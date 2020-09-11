package JavaExercise.ThreadDemo;

public class PrintDemo {

    Object o = new Object();    //新建一个任意的锁对象，任意的对象都可以

    public void print1 () {
        synchronized(o) {       //这里对象o不能使用匿名类对象new Object()，无法保证锁对象是同一个
            System.out.print("A");
            System.out.print("n");
            System.out.print("t");
            System.out.print("h");
            System.out.print("o");
            System.out.print("n");
            System.out.print("y");
            System.out.print("\r\n");
        }
    }

    public void print2() {
        synchronized(o) {   //这里对象o不能使用匿名类对象new Object()，无法保证锁对象是同一个
            System.out.print("learn");
            System.out.print("Java");
            System.out.print("\r\n");
        }
    }
}
