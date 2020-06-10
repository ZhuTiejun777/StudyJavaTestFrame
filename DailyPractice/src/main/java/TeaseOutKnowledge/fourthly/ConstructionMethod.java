package TeaseOutKnowledge.fourthly;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;


/**
 * 作用概述:
 *      给对象的数据进行初始化
 * 格式：
 *      方法名与类名相同
 *      没有返回值类型，连void都没有
 *      没有具体的返回值
 *
 * 如果你不提供构造方法，系统会给出默认构造方法
 * 如果你提供了构造方法，系统将不再提供
 * 构造方法也是可以重载的
 *
 *
 */

public class ConstructionMethod {
    public static void main(String[] args) {
        // 因为Person类继承里Student类,Student类中不包含所有Person类中的属性
        // 所以可以写成 Student ss = new Person(); 效果与Student sss = new Student()相同;
        // 不能写成 Person sss = new Student();
        // new 调用这个类的构造函数初始化对象，类名()这个是构造函数，用来做初始化
        // 父类可以调用子类的构造函数初始化对象
        Student ss1 = new Person();
        List<String> list = new ArrayList<String>();
        // 初始化时调用Person()的构造方法,,
        Student ss2 = new Person(5);
        // 但是不能调用Person的独有的方法和参数
        // 如 ss2.num 无法调用

        Person person1 = new Person();
        // 输入为0,因为初始化时调用的构造方法没有传入num值,所以num没有初始化,等于0
        System.out.println(person1.num);

        Person person2 = new Person("测试");

        Person person3 = new Person(5);
        System.out.println(person3.num);

    }

    private ConstructionMethod () {

    }
}
