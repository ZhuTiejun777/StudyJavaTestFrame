package TeaseOutKnowledge.seventh;

/**
 * 接口成员特点
 *      成员变量；只能是常量，并且是静态的。
 *      默认修饰符：public static final
 *      建议：自己手动给出。
 * 构造方法：接口没有构造方法。因为接口主要是扩展功能的，而没有具体存在
 * 成员方法：只能是抽象方法。
 *      默认修饰符：public abstract
 *      建议：自己手动给出。
 *
 */


public class StudyConnector {

    public static void main(String[] args) {
        //Student是抽象类; 无法实例化
        //Student student = new Student();
        //Person是接口类; 无法实例化
        //Person person = new Person();

        Child child = new Child();
        System.out.print(child.num);

    }
}
