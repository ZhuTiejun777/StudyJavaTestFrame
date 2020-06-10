package com.qa.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestngReportDemo {

    @Test
    public void testReport(){

        WebDriver driver=new ChromeDriver();

        Reporter.log("launch chrome browser instance");

        driver.manage().window().maximize();

        Reporter.log("Max the browser");

        driver.get("https://www.baidu.com");

        Reporter.log("open baidu site");

        driver.quit();

        Reporter.log("退出浏览器");

    }

}