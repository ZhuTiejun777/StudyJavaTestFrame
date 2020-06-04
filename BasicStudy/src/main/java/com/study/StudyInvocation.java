package com.study;

/**
 * 在Java中用static关键字的方法，就叫静态方法，静态方法只能被类本身调用，
 * 不能被类的实例对象调用（会出现警告，类型不匹配），而没有static关键字的方法，在类中叫实例方法，
 * 任何一个实例对象都能调用实例方法。同样，类变量也和方法类似。
 */

public class StudyInvocation {
    public static void main(String[] args) {
        Student Anthony = new Student(); // Anthony 是一个对象或者叫实例

        Anthony.setId(1);
        Anthony.setName("Anthony");
        Anthony.setAge(18);

        System.out.println(Anthony.getName() + " is " + Anthony.getAge() + " years old.");
    }
}
