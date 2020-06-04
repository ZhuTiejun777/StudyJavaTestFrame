package com.study.SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class test2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
        // 创建HashMap类的一个对象
        Map<String, Object> prefs = new HashMap<String, Object>();
        // 设置提醒的设置，2表示block
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        // 在 Chrome driver传入options设置
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://scrolltest.com/");
        driver.manage().window().maximize();
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
