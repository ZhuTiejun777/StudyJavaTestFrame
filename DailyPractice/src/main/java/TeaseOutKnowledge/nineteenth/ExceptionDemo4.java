package TeaseOutKnowledge.nineteenth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Throwable中的方法
 *      getMessage()：获取异常信息，返回字符串。
 *      toString()：获取异常类名和异常信息，返回字符串。
 *      printStackTrace()：获取异常类名和异常信息，以及异常出现在程序中的位置。返回值void。
 *      printStackTrace(PrintStream s)：通常用该方法将异常内容保存在日志文件中，以便查阅。
 *
 * 异常声明Throws
 *      格式：
 *          throws 异常类名
 *          注意：这个格式必须跟在方法的括号后面。
 */

public class ExceptionDemo4 {

    //编译期异常抛出，将来调用者必须处理。
    //运行期异常抛出，将来调用可以不用处理。
    public static void main(String[] args) {
        System.out.println("-------------");
        try {
            method1();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("-------------");
        method2();
    }

    // 编译期异常的抛出，编译不通过，我们就要抛出异常了
    public static void method1() throws ParseException {
        String str = "2020-06-29";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(str);
        System.out.println(date);
    }

    // 运行期异常的抛出
    public static void method2() throws ArithmeticException{
        int a = 10;
        int b = 0;
        System.out.println(a / b);
    }

}
