package com.study.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ActionTest {
    public static void main(String[] args) throws Exception{

        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.baidu.com");

        driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("测试");
        driver.findElement(By.xpath("//input[@id='su']")).sendKeys(Keys.ENTER);
        Thread.sleep(2);

        WebDriverWait wait1 =new WebDriverWait(driver,10);
        wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[text()='全部产品>>']")));

        // 创建一个WebDriverWait类的一个对象 wait，设置5，默认单位是秒
        // 等待知道5秒之后该元素还是不可见，就报超时错误。
        WebDriverWait wait2 = new WebDriverWait(driver,5);
        WebElement element=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='appleId']")));
        boolean status = element.isDisplayed();
        // 判断
        if (status) {
            System.out.println("===== 元素可见======");
        } else {
            System.out.println("===== 元素不可见======");
        }
    }
}
