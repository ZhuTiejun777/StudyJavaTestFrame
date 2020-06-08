package com.study.SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MyWaitTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        // driver.switchTo().frame("auth-frame");
        // TODO 此处报错:空指针异常,未找到原因
        MyWait.isElementPresent(driver, "//*[@id='kw1']", 10).sendKeys("tester");
        MyWait.isElementPresent(driver, "//*[@id='pwd']", 10).sendKeys("123456");
    }
}
