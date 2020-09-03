package JavaExercise.ExceptionDemo;

public class ExceptionDemo2 {

    //throws：
    //1）用在方法声明后面，跟的是异常类名。
    //2）可以跟多个类名，用逗号隔开
    //3）表示抛出异常由该方法的调用者来处理。
    //throw：
    //1）在方法体内，跟的是异常对象名。
    //2）只能抛出一个异常对象名
    //3）表示抛出异常由该方法体内语句处理。

    public static void main(String[] args) {


        Person p = new Person();
        p.setAge(-18);
        System.out.println(p.getAge());
    }
}
