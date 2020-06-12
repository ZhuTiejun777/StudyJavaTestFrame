package TeaseOutKnowledge.seventh;

/**
 * 类与类：
 *      继承关系,只能单继承,可以多层继承
 * 类与接口：
 *      实现关系,可以单实现,也可以多实现
 *      并且还可以在继承一个类的同时实现多个接口
 * 接口与接口：
 *      继承关系,可以单继承,也可以多继承
 */


abstract class Student implements Person{

    public void drink () {
        System.out.print("Student drink");
    }
}
