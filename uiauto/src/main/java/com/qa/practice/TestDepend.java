package com.qa.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @test 顺序执行
 * @Test(enabled=false) 取消用例执行
 *
 */
public class TestDepend {

    WebDriver driver;

    @BeforeClass
    public void setuo(){

        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void openBaidu() throws InterruptedException{

        driver.get("https://www.baidu.com");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        //assertTrue(driver.getTitle() == "百度一下，你就知道");
    }

    @Test(dependsOnMethods={"openBaidu"})
    public void testSearch() throws InterruptedException{
        driver.findElement(By.id("kw")).sendKeys("Selenium");
        driver.findElement(By.id("su")).click();
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods={"testSearch"})
    public void testSearch2(){
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys("Selenium+Java");
        driver.findElement(By.id("su")).click();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
