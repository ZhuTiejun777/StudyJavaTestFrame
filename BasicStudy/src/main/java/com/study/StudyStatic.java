package com.study;

/**
 * 在外部调用静态方法时，可以使用"类名.方法名"的方式，也可以使用"对象名.方法名"的方式。
 * 而实例方法只有后面这种方式。也就是说，调用静态方法可以无需创建对象。
 *
 * 静态方法在访问本类的成员时，只允许访问静态成员（即静态成员变量和静态方法），而不允许访问实例成员变量和实例方法；实例方法则无此限制。
 * 静态方法只能访问静态成员，实例方法可以访问静态和实例成员。
 *
 * main()方法是一个典型的静态方法，它同样遵循一般静态方法的规则，所以它可以由系统在创建对象之前就调用。
 *
 * 在静态方法里创建一个当前类的实例对象,才可以调用类方法和类变量
 *
 * java中的静态方法类似于python中类方法和类变量
 */


public class StudyStatic {
    public static void main(String[] args) {
        //调用静态方法和调用实例方法
        Hello hello = new Hello();
        // 类本身调用静态方法
        Hello.DoSomethingWithStatic();
        // 实例对象调用实例方法，如果实例调用静态方法，会出现警告
        hello.DoSomethingWithNoStatic();

        // 类本身调用静态成员变量
        Hello.name = "Anthony";
        System.out.println(Hello.name);
        // 实例对象调用静态成员变量，会出现警告：The static field Hello.name should be accessed in a static way
        hello.name = "Tom";
        System.out.println(hello.name);

    }
}
