package JavaExercise.DecorateDemo;

public class Demo {

    // 装饰设计模式
    public static void main(String[] args) {
        Programer programer = new Programer(new Student());
        programer.code();
    }
}
