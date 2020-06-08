package com.study.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOprationTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.baidu.com");
        driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("anthony_tester csdn");
        driver.findElement(By.xpath("//input[@id='su']")).click();

        WebElement element = driver.findElement(By.xpath("//span[@class='nums_text']"));
        String text = element.getText();

        String str = text.split("约")[1];
        String result =str.split("个")[0];
        System.out.println(result);

        String re = "[\\d]+";
        Pattern retest = Pattern.compile(text);
        Matcher res = retest.matcher(re);
        System.out.println(res.matches());
        if (res.matches()) {
            System.out.println(res.group(0));
            System.out.println(res.group(1));
            System.out.println(res.group(2));
        } else {
            System.out.println("No find result!");
        }

        driver.close();

        // 创建一个格式化dateformat对象
        DateFormat dateformat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        // 利用date获取当前时间
        Date date = new Date();
        // 格式化时间,并用string对象
        String date1 = dateformat.format(date);
        System.out.println(date1);
    }
}
