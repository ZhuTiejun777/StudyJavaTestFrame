package TeaseOutKnowledge.twentyfirst;

/**
 * 递归
 *      方法定义中调用方法本身的现象
 * 递归的注意事项
 *      递归一定要有出口，否则就是死递归
 *      递归的次数不能太多，否则就内存溢出
 *      构造方法不能递归使用
 */

public class RecursionDemo {

    public static void main(String[] args) {
        int num = 1;
        for (int i = 2; i <= 5; i ++) {
            num *= i;
        }
        System.out.println(num);

        System.out.println(jiecheng(5));
    }

    public static int jiecheng (int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * jiecheng(num - 1);
        }
    }
}
