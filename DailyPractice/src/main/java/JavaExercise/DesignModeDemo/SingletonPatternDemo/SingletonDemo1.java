package JavaExercise.DesignModeDemo.SingletonPatternDemo;

/**
 * 饿汉式单例（立即加载方式）
 * 饿汉式单例在类加载初始化时就创建好一个静态的对象供外部使用，除非系统重启，这个对象不会改变，所以本身就是线程安全的
 * 通过将构造方法限定为private避免了类在外部被实例化，在同一个虚拟机范围内，Singleton的唯一实例只能通过getInstance()方法访问
 */

public class SingletonDemo1 {

    private SingletonDemo1 () {};

    private static SingletonDemo1 singletonDemo1 = new SingletonDemo1();

    public static SingletonDemo1 getSingletonDemo1 () {
        return singletonDemo1;
    }
}
