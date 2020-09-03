package JavaExercise.DesignModeDemo.SingletonPatternDemo;

/**
 * 懒汉式单例（延迟加载方式）
 * 在方法上加synchronized同步锁或是用同步代码块对类加同步锁，此种方式虽然解决了多个实例对象问题
 * 下一个线程想要获取对象，就必须等待上一个线程释放锁之后，才可以继续运行。
 * 使用双重检查进一步做了优化，可以避免整个方法被锁，只对需要锁的代码部分加锁，可以提高执行效率
 */
public class SingletonDemo2 {

    // 私有构造
    private SingletonDemo2() {}

    private static SingletonDemo2 single = null;

    // 双重检查
    public static SingletonDemo2 getInstance() {
        if (single == null) {
            synchronized (SingletonDemo2.class) {
                if (single == null) {
                    single = new SingletonDemo2();
                }
            }
        }
        return single;
    }
}
