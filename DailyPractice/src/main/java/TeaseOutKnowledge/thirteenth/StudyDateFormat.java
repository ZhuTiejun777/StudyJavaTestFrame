package TeaseOutKnowledge.thirteenth;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateFormat类概述
 *      DateFormat 是日期/时间格式化子类的抽象类，它以与语言无关的方式格式化并解析日期或时间。
 *      是抽象类，所以使用其子类SimpleDateFormat
 * SimpleDateFormat构造方法
 *      public SimpleDateFormat():默认模式
 *      public SimpleDateFormat(String pattern):给定的模式
 * 格式:yyyy年MM月dd日 HH:mm:ss
 * 成员方法
 *      public final String format(Date date)：Date – String(格式化)
 *      public Date parse(String source)：String – Date(解析)
 */

public class StudyDateFormat {

    public static void main(String[] args) {
        // Date -- String
        // 创建日期对象
        Date d = new Date();
        // 创建格式化对象
        // SimpleDateFormat sdf = new SimpleDateFormat();
        // 给定模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        // Date  --  String(格式化)
        String s = sdf.format(d);
        System.out.println(s);


        //String -- Date(解析)
        String str = "2016-08-08 12:12:12";
        //在把一个字符串解析为日期的时候，请注意格式必须和给定的字符串格式匹配
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Date dd = sdf2.parse(str);
        //System.out.println(dd);


    }
}
