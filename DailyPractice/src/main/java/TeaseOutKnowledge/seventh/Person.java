package TeaseOutKnowledge.seventh;

/**
 * 接口用关键字interface表示
 *      格式：interface 接口名 {}
 * 类实现接口用implements表示
 *      格式：class 类名 implements 接口名 {}
 * 接口不能实例化
 *      按照多态的方式，由具体的子类实例化。其实这也是多态的一种，接口多态（下一节讲）。
 * 接口的子类
 *      可以是抽象类。但是意义不大。
 *      可以是具体类。要重写接口中的所有抽象方法。(推荐方案)
 *
 */

interface Person {

    // 成员变量；只能是常量，并且是静态的
    // 相当于 static final int num = 10;
    int num = 10;

    // 接口类中可以定义抽象方法
    public abstract void drink ();

    public void eat();

    // 接口没有构造方法
    // public Person ();

}
