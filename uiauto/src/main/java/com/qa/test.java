package com.qa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        // 创建一个格式化dateformat对象
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 利用date获取当前时间
        Date date = new Date();
        // 格式化时间
        String StringDate = dateformat.format(date);
        System.out.println(StringDate);
    }
}
