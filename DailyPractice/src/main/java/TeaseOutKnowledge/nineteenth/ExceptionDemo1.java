package TeaseOutKnowledge.nineteenth;

/**
 * 程序的异常：Throwable
 *      严重问题：Error 我们不处理。这种问题一般都是很严重的，比如说内存溢出。
 *      问题：Exception
 *          编译期问题:不是RuntimeException的异常 必须进行处理的，因为你不处理，编译就不能通过。
 *          运行期问题:RuntimeException 这种问题我们也不处理，因为是你的问题，而且这个问题出现肯定是我们的代码不够严谨，需要修正代码的。
 *
 * JVM的默认处理方案
 *      把异常的名称，错误原因及异常出现的位置等信息输出在了控制台
 *      程序停止执行
 *
 * 异常的处理方案
 *      try…catch…finally
 *      throws
 */

public class ExceptionDemo1 {

    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        // 报异常
        System.out.println(a / b);

        System.out.println("over");

    }
}
