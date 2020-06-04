package com.study.SeleniumTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class test1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");
        //System.setProperty("webdriver.chrome.bin","\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        //System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrator\\AppData\\Local\\Programs\\Python\\Python37\\geckodriver.exe");
        //System.setProperty("webdriver.gecko.driver","E:\\test_tools\\firefox.exe");
        //System.setProperty("webdriver.gecko.driver",".\\tools\\geckodriver.exe");
        // 初始化火狐浏览器实例
        WebDriver driver = new FirefoxDriver();
        // WebDriver driver = new ChromeDriver();
        // 最大窗口化
        driver.manage().window().maximize();
        // 设置隐性等待时间
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        // get()打开网站
        driver.get("https://www.baidu.com");
        // getTitle()获取当前页面title的值
        System.out.println("当前打开的标题是:" + driver.getTitle());
        // 关闭并退出浏览器驱动
        driver.quit();
    }
}
