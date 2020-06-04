package com.study.SeleniumTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementOperation {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://blog.csdn.net/u011541946");

        Thread.sleep(1000);

        // 定义csdn底部 公司简介 这个元素
        WebElement element = driver.findElement(By.xpath("//*/dd[@class='foot_sub_menu']/a[1]"));
        // 创建一个javascript 执行实例
        JavascriptExecutor je = (JavascriptExecutor) driver;

        // 执行js语句，拖拽浏览器滚动条，直到该元素到底部，马上就不可以见
        // scrollIntoView(true)拖动到element元素可见
        je.executeScript("arguments[0].scrollIntoView(true);",element);

        // 切换到frame标签,rightMain为id或者name元素
        driver.switchTo().frame("rightMain");
        // 化学药 这个分类点击
        WebElement drug_type_huaxue = driver.findElement(By.xpath("//*/span[@title='化学药']"));
        drug_type_huaxue.click();
        Thread.sleep(1000);
        // 切换到Top Windows(主页面)，点击权限提示上面的去登录按钮。
        driver.switchTo().defaultContent();

        // 把单选按钮放在一个list里面
        ArrayList<WebElement> search_type = (ArrayList<WebElement>) driver.findElements(By.xpath("//*/p[@class='search-radios']/input"));
        for(WebElement ele : search_type){
            ele.click();
            Thread.sleep(1000);
        }

        // isDisplayed()判断元素是否存在
        WebElement error_message = driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_8__error' and text()='请输入验证码']"));
        assert error_message.isDisplayed();
        // getText()获取元素文本
        String error_message1 = driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_8__error']")).getText();
        assert(error_message1 == "请输入验证码");

        // 处理alert框,driver.switchTo().alert().getText()获取alert框的文本
        System.out.println(driver.switchTo().alert().getText());
        // driver.switchTo().alert().accept()点击确认alert框的文本
        driver.switchTo().alert().accept();

        WebElement username = driver.findElement(By.id("TANGRAM__PSP_8__userName"));
        // 创建一个JavascriptExecutor对象
        JavascriptExecutor js= (JavascriptExecutor)driver;
        username.sendKeys("abcdefg");
        // 设置颜色,利用JS处理元素高亮显示
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",username);
        WebElement password = driver.findElement(By.id("TANGRAM__PSP_8__password"));
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",password);

    }
}
