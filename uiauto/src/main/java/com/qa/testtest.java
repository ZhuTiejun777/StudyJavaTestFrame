package com.qa;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class testtest {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个格式化dateformat对象
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 利用date获取当前时间
        Date date = new Date();
        // 格式化时间
        String StringDate = dateformat.format(date);
        System.out.println(StringDate);

        // Cookie cookie = new Cookie("JSESSIONID", "DBDF947BB1859B30B55055F49BAFC366");
        Cookie cookie = new Cookie("Cookie", "JSESSIONID=DBDF947BB1859B30B55055F49BAFC366");

        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://122.224.230.26:20087/member/login/home");
        Thread.sleep(5000);
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.close();
    }
}
