package TeaseOutKnowledge.fourthly;

/**
 * private 关键字（意思是私有的）
 *      是一个权限修饰符。
 *      可以修饰成员(成员变量和成员方法)
 *      被private修饰的成员只在本类中才能访问。
 * private最常见的应用：
 *      把成员变量用private修饰
 *      提供对应的getXxx()/setXxx()方法
 *      一个标准的案例的使用
 */

/**
 * this关键字:代表所在类的对象引用。简单的说，它就代表当前类的一个对象
 * 相当于实例化当前类
 * 方法被哪个对象调用，在该方法内部的this就代表那个对象
 * 用法:解决局部变量隐藏成员变量,将局部变量赋值给成员变量,也就是类变量
 */

public class Student {

    // 成员变量不能被静态方法调用,只能被静态成员变量访问
    private int age;
    private String name;

    public void study () {
        System.out.println("学习");
    }

    // 可以获取到被赋值的私有变量的值
    public int getAge () {
        return age;
    }

    // 可以赋值给私有变量的函数
    public void setAge (int age) {
        this.age = age;
        this.study();
    }


    public void setName () {
        String name = "xx";
        System.out.println(name);
        // 将私有变量赋值给成员变量
        this.name = name;
    }

    public static void ss () {
    }

    public void sss () {
        //name = "1";
    }

}
