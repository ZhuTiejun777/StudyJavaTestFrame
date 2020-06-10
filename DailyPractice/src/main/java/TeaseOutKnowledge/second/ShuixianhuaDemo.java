package TeaseOutKnowledge.second;

/**
 * 分析：
 * A:首先必须知道什么是水仙花数
 * 所谓的水仙花数是指一个三位数，其各位数字的立方和等于该数本身。
 * 举例：153就是一个水仙花数。
 * 153 = 1*1*1 + 5*5*5 + 3*3*3 = 1 + 125 + 27 = 153
 * B:定义统计变量，初始化值是0
 * C:三位数告诉了我们范围，用for循环就可以搞定
 * D:获取每一个三位数的个，十，百的数据
 * E:按照要求进行判断
 * F:如果满足要求就计数。
 */
public class ShuixianhuaDemo {
    public static void main(String[] args) {
        //定义统计变量，初始化值是0
        int count=0;
        //三位数告诉了我们范围，用for循环就可以搞定
        for (int i = 100; i < 1000; i++) {
            //获取每一个三位数的个，十，百的数据
            int ge = i%10;
            int shi = i/10%10;
            int bai = i/10/10%10;
            //按照要求进行判断
            if(i == (ge*ge*ge+shi*shi*shi+bai*bai*bai)){
                //如果满足要求就计数。
                count++;
                System.out.println("水仙花数是："+bai+""+shi+""+ge);
            }
        }
        System.out.println("水仙花数共有"+count+"个");
    }
}
