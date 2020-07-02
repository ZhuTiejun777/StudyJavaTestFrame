package TeaseOutKnowledge.twentyfourth;

public class MyThreadDemo {

    public static void main(String[] args) {
        // 创建线程对象
        //无参构造+setXxx()
        MyThread my1 = new MyThread();
        MyThread my2 = new MyThread();
        //调用方法设置名称
        my1.setName("刘备");
        my2.setName("关羽");
        my1.start();
        my2.start();

        //带参构造方法给线程起名字
        // MyThread my1 = new MyThread("刘备");
        // MyThread my2 = new MyThread("关羽");
        // my1.start();
        // my2.start();

        //我们可以使用无参构造的方法，也可以使用带参构造的方法
    }
}
