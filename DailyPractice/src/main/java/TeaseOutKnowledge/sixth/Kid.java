package TeaseOutKnowledge.sixth;

/**
 * 方法重写概述
 *      子类中出现了和父类中一模一样的方法声明，也被称为方法覆盖，方法复写。
 * 方法重载概述
 *      本类中出现的方法名一样，参数列表不同的方法。与返回值无关。
 * 使用特点：
 *      如果方法名不同，就调用对应的方法
 *      如果方法名相同，最终使用的是子类自己的
 * 方法重写的应用：
 *      当子类需要父类的功能，而功能主体子类有自己特有内容时，可以重写父类中的方法，这样，即沿袭了父类的功能，又定义了子类特有的内容
 *
 * 方法重写的注意事项
 *      A:父类中私有方法不能被重写（因为父类私有方法子类根本就无法继承）
 *      B:子类重写父类方法时（访问权限不能更低，最好就一致）
 *      C:父类静态方法，子类也必须通过静态方法进行重写
 *      子类重写父类方法的时候，最好声明一模一样。
 */

public class Kid extends Person{

    // 方法重写,覆盖父类的方法,使用super.eat()函数,调用父类的函数
    // 既有父类的属性又有子类特有的属性
    public void eat () {
        super.eat();
        System.out.println("eat");
    }

    public void call (String str) {
        super.call(str);
        System.out.println("call" + str);
    }

    public static void sleep () {
        System.out.println("sleep");
    }

}
