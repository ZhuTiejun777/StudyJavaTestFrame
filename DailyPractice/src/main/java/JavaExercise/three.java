package JavaExercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class three {

    public static void main(String[] args) throws ParseException {
        // 正则
        // 找出以下字符串中所有的手机号码
        String s = "小明的手机号码是189888888888，曾经用过138123456789，还用过176987654321";
        // 定义手机号码的正则表达式
        String regex = "1[35768]\\d{9}"; // 1 3/5/6/7/8开头的11位手机号
        //使用模式和匹配器
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);

        // 查询Matcher类的API，可以找到find方法，上面有三个手机号，这里循环输出
        while(m.find()) {
            System.out.println(m.group()); //group方法是返回匹配的字符串
        }

        // 时间戳
        System.out.println(System.currentTimeMillis());
        // 获取当前时间
        Date data = new Date();
        System.out.println(data);
        // 定义打印时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String time = simpleDateFormat.format(data);
        System.out.println(time);

        System.out.println(getAgeTime("19961128"));
    }

    private static Long getAgeTime(String birth) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmdd");
        Date date = simpleDateFormat.parse(birth);
        long newDate = System.currentTimeMillis();
        long birthDate = date.getTime();
        return (newDate - birthDate)/1000/60/60/24;
    }
}
