package com.study.InterfaceTest;

/**
 * 接口的实现需要interface关键字
 * 接口无法被实例化
 * 接口中方法均为抽象方法
 * 接口只声明方法，没有具体的方法
 * 接口的作用：（类似定义规则）
 * 接口中不能包含实例域或静态方法（静态方法必须实现，接口中方法是抽象方法，不能实现）
 */
public interface Student {
    public int getAge();
}
