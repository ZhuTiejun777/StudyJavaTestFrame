package TeaseOutKnowledge.thirdly;

/**
 * 方法重载,同一类中允许有多个同名方法
 * 根据调用时传递的参数不同,来调用不用的函数
 */

public class SumDemo {

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int result = sum(x,y);
        System.out.println(result);

    }

    public static int sum (int a, int b) {
        return a + b;
    }

    public static int sum (int a, int b, int c) {
        return a + b + c;
    }

    public static int sum (int a, int b, int c, int d) {
        return a + b + c + d;
    }
}
