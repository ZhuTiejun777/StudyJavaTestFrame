package TeaseOutKnowledge.sixth;

/**
 * 多个类中存在相同属性和行为时，将这些内容抽取到单独一个类中，那么多个类无需再定义这些属性和行为，只要继承那个类即可。
 * 通过extends关键字可以实现类与类的继承
 * 格式：class 子类名 extends 父类名 {}
 * 单独的这个类称为父类，基类或者超类；这多个类可以称为子类或者派生类。
 * 有了继承以后，我们定义一个类的时候，可以在一个已经存在的类的基础上，还可以定义自己的新成员
 *
 * Java只支持单继承，不支持多继承
 * Java支持多层继承(继承体系)
 *
 * 子类只能继承父类所有非私有的成员(成员方法和成员变量)
 *      其实这也体现了继承的另一个弊端：打破了封装性
 * 子类不能继承父类的构造方法，但是可以通过super关键字去访问父类构造方法。
 * 不要为了部分功能而去继承
 * 我们到底在什么时候使用继承呢?
 *      继承中类之间体现的是：”is a”的关系。
 *      举例：水果和苹果，苹果是一种水果。
 *      学生和人，学生是人的一种。
 *      所以我们总结采用假设法。如果有两个类A,B。只有他们符合A是B的一种，或者B是A的一种，就可以考虑使用继承。
 *
 * 在子类方法中访问一个变量的查找顺序：
 *      a:在子类方法的局部范围找，有就使用
 *      b:在子类的成员范围找，有就使用
 *      c:在父类的成员范围找，有就使用
 *      d:如果还找不到，就报错
 */

public class ExtendsDemo {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.eat();
        // 子类继承父类的静态方法,类名.方法方式调用
        Student.sleep();
        System.out.println("----------");
        Teacher teacher1 = new Teacher();
        teacher1.eat();
        Teacher.sleep();
        // 父类的私有类不能继承
        // teacher1.rap();

        // 子类可以继承父类的成员变量
        System.out.println(teacher1.num2);
        System.out.println(teacher1.num1);

        Student teacher2 = new Student("TEST");
        System.out.println("----------");

        Kid kid = new Kid();
        kid.eat();
        kid.call("test");
        Kid.sleep();
        System.out.println("----------");

        Man man = new Man();
        // man.eat()调用父类方法,不需要传参数
        man.eat();
        // man.eat()调用子类重载的方法,需要传参数,方法重载后不会在调用父类方法
        man.eat("test");
        Man.sleep("test");
        Man.sleep();
        man.rap();

    }
}
