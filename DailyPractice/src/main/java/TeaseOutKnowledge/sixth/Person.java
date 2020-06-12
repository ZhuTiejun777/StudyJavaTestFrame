package TeaseOutKnowledge.sixth;


public class Person {

    public Person () {
        System.out.println("Person 构造方法");
    }

    public Person (String str) {
        System.out.println("Person 构造方法" + str);
    }

    public int num1 = 10;
    int num2 = 20;
    static int num3 = 30;

    public void eat () {
        System.out.println("吃饭");
    }

    // 父类的静态方法,子类重写是需要是静态方法
    public static void sleep () {
        System.out.println("睡觉");
    }

    // 私有方法子类无法调用
    private void rap (String str) {
        System.out.println("rap" + str);
    }

    public void call (String str) {
        System.out.println("call" + str);
    }
}
