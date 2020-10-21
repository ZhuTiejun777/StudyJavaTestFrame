package com.qa.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTestNG {

    WebDriver driver;

    @Test
    public void openbaidu () {
        driver.get("https://www.baidu.com");
        driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("Selenium");
        driver.findElement(By.xpath("//*[@id='su']")).click();
    }

    @BeforeClass
    public void beforeclass () {
        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterclass () {
        driver.quit();
    }

}
