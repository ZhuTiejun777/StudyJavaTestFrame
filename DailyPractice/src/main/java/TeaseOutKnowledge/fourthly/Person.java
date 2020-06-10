package TeaseOutKnowledge.fourthly;

public class Person extends Student{

    int num;

    // 构造方法为初始化方法,等同于python中的__init__
    // 初始化时可以传入参数,可以存在多个初始化方法(对构造方法进行重构)
    public Person () {
        System.out.println("构造方法");
    }

    public Person (String str) {
        System.out.println("构造方法" + str);
    }

    public Person (int num) {
        System.out.println("构造方法" + num);
        this.num =  num;
    }

    public void eat () {
        System.out.println("eat");
    }

}
