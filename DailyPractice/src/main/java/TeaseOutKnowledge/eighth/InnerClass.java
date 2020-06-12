package TeaseOutKnowledge.eighth;

/**
 * 内部的访问特点：
 *      内部类可以直接访问外部类的成员，包括私有。
 *      外部类要访问内部类的成员，必须创建对象。
 * 内部类位置
 *      成员位置:在成员位置定义的类，被称为成员内部类。
 *      局部位置:在局部位置定义的类，被称为局部内部类。
 *
 * 访问内部类的成员
 *      外部类名.内部类名 对象名 = 外部类对象.内部类对象;
 *
 * 成员内部的常见修饰符
 *      private 为了保证数据的安全性
 *      static 为了让数据访问更方便
 *          被静态修饰的成员内部类只能访问外部类的静态成员
 *          内部类被静态修饰后的方法
 *              静态方法
 *              非静态方法
 *
 * 可以直接访问外部类的成员
 * 在局部位置，可以创建内部类对象，通过对象调用内部类方法，来使用局部内部类功能
 *
 * 局部内部类访问局部变量必须用final修饰
 * 原因：局部变量是随着方法的调用而调用，随着调用完毕而消失。而堆内存的内容并不会立即消失。
 * 所以，我们加final修饰。加入final修饰后，这个变量就成了常量。既然是常量。你消失了。在内存中存储的是数据20，所以，还是有数据在使用。
 *
 * 匿名内部类就是内部类的简化写法。
 * 前提：存在一个类或者接口
 *      这里的类可以是具体类也可以是抽象类。
 * 格式：
 *      new 类名或者接口名() {重写方法;}
 * 本质：
 *      是一个继承了类或者实现了接口的子类匿名对象
 */

public class InnerClass {

    public void method() {
        //一个方法的时候
        /*
        new Inter() {
            public void show() {
                System.out.println("show");
            }
        }.show();
        */

        //二个方法的时候
        /*
        new Inter() {
            public void show() {
                System.out.println("show");
            }

            public void show2() {
                System.out.println("show2");
            }
        }.show();

        new Inter() {
            public void show() {
                System.out.println("show");
            }

            public void show2() {
                System.out.println("show2");
            }
        }.show2();
        */

        //如果我是很多个方法，就很麻烦了
        //那么，我们有没有改进的方案呢?
        Inter i = new Inter() { //多态
            public void show() {
                System.out.println("show");
            }

            public void show2() {
                System.out.println("show2");
            }
        };

        i.show();
        i.show2();
    }

}
