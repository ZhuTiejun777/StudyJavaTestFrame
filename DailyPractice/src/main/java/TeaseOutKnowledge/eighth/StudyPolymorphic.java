package TeaseOutKnowledge.eighth;

/**
 * 多态的前提
 *      要有继承关系
 *      要有方法重写
 *      要有父类引用指向子类对象，父 f =  new 子();
 *
 * 成员变量
 *      编译看左边，运行看左边
 *      （父类没有的成员变量，子类独有的成员变量，无法访问）
 *      （可以访问子类独有的静态成员变量）
 * 构造方法
 *      子类的构造都会默认访问父类构造
 * 成员方法
 *      编译看左边，运行看右边
 *      （父类没有的方法，子类独有的方法，无法调用）
 *      （可以访问子类独有的静态方法）
 * 静态方法
 *      编译看左边，运行看左边
 *      所以静态方法不能算方法的重写
 *
 * 提高了代码的维护性(继承保证)
 * 提高了代码的扩展性(由多态保证)
 *
 * 多态的弊端不能使用子类的特有功能。
 */

public class StudyPolymorphic {

    public static void main(String[] args) {
        Subject chemistry = new Chemistry();

        System.out.println(chemistry.num1);
        // 子类独有的成员变量访问不到
        // System.out.println(chemistry.num2);
        System.out.println(Chemistry.str);
        // 子类独有的方法无妨调用
        // chemistry.show();
        chemistry.grade();
        Chemistry.book();

        Chemistry.page();
    }
}
