package TeaseOutKnowledge.sixth;

/**
 * 子类中所有的构造方法默认都会访问父类中空参数的构造方法
 *      因为子类会继承父类中的数据，可能还会使用父类的数据。所以，子类初始化之前，一定要先完成父类数据的初始化。
 *      注意：子类每一个构造方法的第一条语句默认都是：super();
 */

public class Student extends Person{

    public Student () {
        System.out.println("Student 构造方法");
    }

    // 通过super(str)调用父类构造参数
    public Student (String str) {
        super(str);
        System.out.println("Student 构造方法" + str);
    }
}
