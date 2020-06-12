package TeaseOutKnowledge.sixth;

/**
 * 方法重写（Override）和方法重载（Overload）的区别
 *      方法重写：在子类中，出现和父类中一模一样的方法声明的现象
 *      方法重载：同一个类中，出现的方法名相同，参数列表不同的现象
 *      方法重载能改变返回值类型，因为它和返回值类型无关
 *
 *
 *
 *
 */


public class Man extends Person{

    // 方法重载,子类函数和父类函数同名,单数参数不同
    public static void sleep (String str) {
        System.out.println("Man sleep" + str);
    }

    public void eat (String str) {
        System.out.println("Man eat" + str);
    }

    // 无法继承父类私有方法
    public void rap () {
        System.out.println("Man rap");
    }

}
