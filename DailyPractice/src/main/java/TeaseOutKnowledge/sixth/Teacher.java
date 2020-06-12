package TeaseOutKnowledge.sixth;

/**
 * super的用法和this很像
 *      this代表本类对应的引用。
 *      super代表父类存储空间的标识(可以理解为父类引用,可以操作父类的成员)
 * 用法(this和super均可如下使用)
 *      访问成员变量
 *              this.成员变量 调用本类的成员变量
 *              super.成员变量 调用父类的成员变量
 * 访问构造方法
 *      this(…) 调用本类的构造方法
 *      super(…) 调用父类的构造方法
 * 访问成员方法
 *      this.成员方法() 调用本类的成员方法
 *      super.成员方法() 调用父类的成员方法
 */

public class Teacher extends Person{
    int num1 = 100;

    public Teacher () {
        System.out.println("Teacher 构造方法");
        System.out.println(this.num1);
        System.out.println(super.num1);
        System.out.println(super.num2);
    }

}
