package com.study.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PageLoadTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.baidu.com");
        driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("java");

    }
}
