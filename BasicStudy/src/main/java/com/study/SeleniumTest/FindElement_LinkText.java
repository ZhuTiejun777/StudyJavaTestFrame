package com.study.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElement_LinkText {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.baidu.com");
        //id id标签定位
        driver.findElement(By.id("kw")).sendKeys("Java");
        driver.findElement(By.id("su")).click();
        //linkText 连接标签定位 匹配text()
        driver.findElement(By.linkText("新闻")).click();
        //ClassName class标签定位
        driver.findElement(By.className("s_ipt")).sendKeys("Java");
        driver.findElement(By.className("bg s_btn_wr")).click();
        //name name标签定位
        driver.findElement(By.name("wd")).sendKeys("Java");
        //partialLinkText 连接标签定位 匹配text()（模糊匹配）
        driver.findElement(By.partialLinkText("设为主页")).click();
        //cssSelector css定位方法定位
        driver.findElement(By.cssSelector("#kw")).sendKeys("Java");;
        driver.findElement(By.cssSelector("#su")).click();
        //xpath xpath定位方式定位
        driver.findElement(By.xpath(".//*[@id='kw']")).sendKeys("Java");
        driver.findElement(By.xpath(".//*[@id='su']")).click();
        //tagName tagName标签定位
        driver.findElement(By.tagName("body")).sendKeys(Keys.F11);

        //findElements定位元素，List<WebElement> links 列表初始化，WebElement定义列表中元素格式
        List<WebElement> links = driver.findElements(By.xpath(".//*[@id='pane-news']/ul[1]/li/a"));
        //links.size(),links列表的大小
        for(int i=0; i<links.size(); i++){
            System.out.println(links.get(i).getText());
        }

        //这个是设置个一段时间就去做一件事
        WebDriverWait wait = new WebDriverWait(driver,30);
        //每隔一秒就去获取元素
        wait.pollingEvery(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("xxxx"));
        // 线程暂停5000毫秒
        Thread.sleep(5000);
        //判断打开页面是不是百度新闻，这里用url作为验证
        assert driver.getCurrentUrl() == "http://news.baidu.com";

        WebElement settings = driver.findElement(By.xpath("//*[@id='u1']/a[8]"));
        WebElement element = driver.findElement(By.xpath("//*[@id='u1']/a[8]"));
        // moveToElement()鼠标悬停,perform()执行操作()
        Actions action = new Actions(driver);
        action.moveToElement(settings).perform();
        // Actions ss = new Actions(driver).moveToElement(settings);
        // 利用鼠标点击元素
        action.moveToElement(settings).click().perform();
        // 鼠标双击
        action.doubleClick(settings).perform();
        // 划取字段，随机划取
        action.clickAndHold(settings).moveToElement(element).perform();
        action.release();
        // 实例化函数可以不赋予变量直接使用
        // Actions action = new Actions(new ChromeDriver());
        // action.moveToElement(driver.findElement(By.xpath("//*[@id='u1']/a[8]"))).perform();
        // 拖拽操作从元素settings拖拽到element
        action.dragAndDrop(settings, element).build().perform();

    }
}
