package com.study.SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class test2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("https://www.baidu.com");
        try {
            String baidu_title = "百度一下，你就知道";
            assert baidu_title == driver.getTitle();
            System.out.println("Test Pass");
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
