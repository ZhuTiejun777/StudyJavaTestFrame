package TeaseOutKnowledge.thirteenth;

import java.util.Date;

/**
 * Date类概述
 *      类 Date 表示特定的瞬间，精确到毫秒。
 * 构造方法
 *      public Date():根据当前的默认毫秒值创建日期对象
 *      public Date(long date)：根据给定的毫秒值创建日期对象
 *
 * 成员方法
 *      public long getTime():获取时间，以毫秒为单位（从Date得到一个毫秒值）
 *      public void setTime(long time):设置时间（把一个毫秒值转换为Date）
 */

public class StudyDate {

    public static void main(String[] args) {
        // 创建对象
        Date d = new Date();
        System.out.println("d:" + d);
        //long time = System.currentTimeMillis();//获取当前的时间

        // 创建对象
        long time = 1000 * 60 * 60; // 1小时
        Date d2 = new Date(time);
        System.out.println("d2:" + d2);

        // 创建对象
        Date d1 = new Date();
        // 获取时间
        long time1 = d1.getTime();
        System.out.println(time1);
        System.out.println(System.currentTimeMillis());
        //运行结果可以发现，上面的结果是相同的
    }

}
