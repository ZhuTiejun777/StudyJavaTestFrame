package TeaseOutKnowledge.eighth;

public class Chemistry extends Subject{

    int num1 = 100;
    int num2 = 200;
    static String str = "chemistry";

    public void show () {
        System.out.println("Chemistry show");
    }

    public void grade () {
        System.out.println("Chemistry grade");
    }

    // 子类重写父类静态方法，子类的方法也需要是静态方法
    public static void book () {
        System.out.println("Chemistry book");
    }

    public static void page () {
        System.out.println("Chemistry page");
    }
}
