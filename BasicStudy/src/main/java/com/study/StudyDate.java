package com.study;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudyDate {

    public static void main(String[] args) {

        Date date = new Date();
        // 把时间安装字符串格式输出，可读性更强
        System.out.println(date.toString());
        // 打印出1970年1月1日到现在的秒数
        System.out.println(date.getTime());
        // 将日期格式化输出
        SimpleDateFormat sdf = new SimpleDateFormat("E yyyy-MM-dd HH-mm-ss");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat(" yyyyMMdd-HHmmss");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat(" yyyyMMdd-HHmmss.S");
        System.out.println(sdf.format(date));

    }
}
