package TeaseOutKnowledge.twentyfourth;

/**
 * 进程
 *      正在运行的程序，是系统进行资源分配和调用的独立单位。
 *      每一个进程都有它自己的内存空间和系统资源。
 * 线程
 *      是进程中的单个顺序控制流，是一条执行路径
 *      一个进程如果只有一条执行路径，则称为单线程程序
 *      一个进程如果有多条执行路径，则称为多线程程序
 * 方式1：继承Thread类
 *      步骤
 *          A:自定义类MyThread继承Thread类。
 *          B:MyThread类里面重写run()
 *          C:创建对象
 *          D:启动线程
 * Thread类的基本获取和设置方法
 *      public final String getName():获取线程的名称。
 *      public final void setName(String name):设置线程的名称
 */

public class MyThread extends Thread{

    public MyThread() {
    }

    public MyThread(String name) {
        super();
    }

    @Override
    public void run() {
        // 自己写代码
        // 一般来说，被线程执行的代码肯定是比较耗时的。所以我们用循环改进
        for (int x = 0; x < 100; x++) {
            System.out.println(x);
        }
    }
}
