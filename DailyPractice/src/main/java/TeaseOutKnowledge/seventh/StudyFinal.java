package TeaseOutKnowledge.seventh;

/**
 * final关键字是最终的意思，可以修饰类，成员变量，成员方法。
 *      修饰类，类不能被继承
 *      修饰变量，变量就变成了常量，只能被赋值一次
 *      修饰方法，方法不能被重写
 */

public class StudyFinal {
    int num1 = 10;
    final int num2 = 20;


    // 由于继承中方法有一个现象：方法重写。所以，父类的功能就会被子类覆盖掉。
    // 有时候为了不让子类去覆盖掉父类的功能，只能让他用，所以，针对这种情况，java就提供了一个关键字：final。
    public final void test () {
        System.out.println("final");
    }


}
