package TeaseOutKnowledge.seventh;

/**
 * 抽象类特点
 *      抽象类和抽象方法必须用abstract关键字修饰
 *          格式
 *          abstract class 类名 {}
 *          public abstract void eat();
 * 抽象类不一定有抽象方法，有抽象方法的类一定是抽象类
 * 抽象类不能实例化
 *      因为它不是具体的。
 *      那么，抽象类如何实例化呢?
 *      按照多态的方式，由具体的子类实例化。其实这也是多态的一种，抽象类多态。
 * 抽象类的子类
 *      如果不想重写抽象方法，该子类是一个抽象类。
 *      重写所有的抽象方法，这个时候子类是一个具体的类。
 *
 */

// 一个类没有抽象方法也可以定义为抽象类,目的是为了不让创建对象
// abstract关键字和private冲突、final冲突、static无意义
abstract class Animal {

    final int num1 = 10;
    static int num2 = 20;

    //public abstract void eat(){} 空方法体,这个会报错。抽象方法不能有主体
    public abstract void eat ();

    public Animal () {
        System.out.println("Amimal");
    }

    public void method () {
        System.out.println("Animal method");
    }

    public abstract void show ();

    //public abstract void show();
    //非法的修饰符组合: abstract和private
    //private abstract void show();

    //非法的修饰符组合  abstract和final
    //final abstract void show();

    //非法的修饰符组合abstract和static
    //static abstract void show();

    public static void methods() {
        System.out.println("method");
    }

}
