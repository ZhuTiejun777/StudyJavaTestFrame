package com.study.InterfaceTest;

/**
 * 通过implements关键字继承定义好的接口
 * 重写接口中的方法
 * 一个实现接口的类，必须实现接口内所描述的所有方法，否则就必须声明为抽象类。
 */
public class StudentTest implements Student{

    public int getAge () {
        return 15;
    }
}
