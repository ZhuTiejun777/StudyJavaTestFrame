package TeaseOutKnowledge.seventh;

/**
 * 抽象类的成员特点：
 *      成员变量：既可以是变量，也可以是常量。
 *      构造方法：构造方法不能被实例化。所以构造方法的特点是：用于子类访问父类数据的初始化。
 * 抽象类的成员方法特性：
 *      可以有抽象方法，强制要求子类做的事情。
 *      也可以有非抽象方法，子类继承的事情，提高代码复用性。
 *
 */


// 继承抽象类后，没有重写所有抽象类方法，那么子类也是抽象类
abstract class Dog extends Animal{

    public void show () {
        System.out.println("Dog show");
    }
}
