package com.study.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleDateTest {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("http://jqueryui.com/resources/demos/datepicker/default.html");
        Thread.sleep(2000);
        // 日期输入框
        WebElement date_inputbox = driver.findElement(By.id("datepicker"));
        // 第一种方式,鼠标点击日期输入框
        date_inputbox.click();
        // 点击下一个月
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[@data-handler='next']")).click();
        // 点击17日，xpath定义第三行第五个元素，可能每个月排序不一样，所以不一定点击的就是17日
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[5]/a")).click();
        // 第二种方式,直接输入日期
        date_inputbox.sendKeys("08/17/2017");

        // 下拉框处理,定位到下拉框元素
        WebElement el_down = driver.findElement(By.id("nr"));
        Select select = new Select(el_down);
	    //通过选项的索引定位
	    select.selectByIndex(0);
	    waitTime(100);
        //通过value进行设置
        select.selectByValue("50");
        //通过文本进行选择
        select.selectByVisibleText("每页显示50条");

    }

    public static void waitTime(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
