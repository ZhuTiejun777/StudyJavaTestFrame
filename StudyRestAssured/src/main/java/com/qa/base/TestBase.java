package com.qa.base;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class TestBase {

    public Properties prop;

    //写一个构造函数
    public TestBase() {

        final Logger Log = Logger.getLogger(TestBase.class);
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/qa/config/config.properties");
            prop.load(fis);
            Log.info("正在读取配置文件...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.error("配置文件没有找到");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
