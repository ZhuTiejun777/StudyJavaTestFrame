package TeaseOutKnowledge.fifth;

/**
 * 代码块概念需要再次学习
 */

public class StudyMath {


    public static void main(String[] args) {
        double dou = Math.random();
        System.out.println(dou);

        int x = 0;
        //获取一个1-100之间的随机数
        for (int i = 0; i < 100; i++) {
            x = (int) (Math.random()*100)+1;
        }
        System.out.println(x);
    }

    // 静态代码块,实例化对象时先执行静态代码块,同一方法中存在多个静态代码块时,按顺序依次执行
    // 随着类的加载而执行，而且只执行一次,无论实例化几个对象
    static {
        System.out.println("ss");
    }

    // 构造代码块,执行顺序优先于静态代码块,每次实例化类后都会执行
    {
        System.out.println();
    }

    public void test () {
        System.out.println();
        // 普通代码块,调用方法时执行,同一方法中存在多个普通代码块时,按顺序依次执行
        // 每次调用方法时都会执行
        {
            System.out.println("普通代码块");
        }

    }


}
