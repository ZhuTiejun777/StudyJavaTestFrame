package com.study.SeleniumTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Summarizing {

    private static final String url = "https://www.baidu.com";
    private static final String element_baidu = "//*[@id='baidu']";

    public static void main(String[] args) throws AWTException {

        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);

        WebElement webElement = driver.findElement(By.xpath(element_baidu));

        /*ChromeOptions options = new ChromeOptions();
        // 关闭提示语
        options.addArguments("disable-infobars");
        // 跳过网站不安全界面
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        // 加载浏览器的静默模式,使浏览器在后台运行
        options.addArguments("headless");
        // 设置默认编码为 utf-8，也就是中文
        options.addArguments("lang=zh_CN.UTF-8");
        // 取消沙盒模式
        options.addArguments("–no-sandbox");
        options.addArguments("-disable-gpu");
        options.addArguments("--disable-images");
        options.addArguments("--blink-settings=imagesEnabled=false");
        // 禁用图像
        options.addArguments("–disable-images");
        // 启动进入隐身模式
        options.addArguments("–incognito");
        // 禁用插件
        options.addArguments("–disable-plugins");
        WebDriver chromeDriver = new ChromeDriver(options);*/

        // 当前页面打开新的网页
        driver.navigate().to("new url");
        // 后退
        driver.navigate().back();
        // 前进
        driver.navigate().forward();
        // 刷新当前页面
        driver.navigate().refresh();

        // 获取当前页面url
        driver.getCurrentUrl();
        // 获取当前页面title
        driver.getTitle();
        // 获取当前页面源码
        driver.getPageSource();

        // 获取浏览器所有页面句柄
        Set<String> handlesSet = driver.getWindowHandles();
        // 获取浏览器当前页面句柄
        String handlesString = driver.getWindowHandle();
        // 切换页面
        driver.switchTo().window(handlesString);

        // 显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement waitelement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element_baidu)));

        // 定位元素,id
        driver.findElement(By.id(element_baidu));
        // 定位元素,linkText
        driver.findElement(By.linkText(element_baidu));
        // 定位元素,class
        driver.findElement(By.className(element_baidu));
        // 定位元素,name
        driver.findElement(By.name(element_baidu));
        // 定位元素,partialLinkText
        driver.findElement(By.partialLinkText(element_baidu));
        // 定位元素,tagName
        driver.findElement(By.tagName(element_baidu));
        // 定位元素,cssSelector
        driver.findElement(By.cssSelector(element_baidu));
        // 定位元素,xpath
        driver.findElement(By.xpath(element_baidu));

        // 判断元素是否存在
        driver.findElement(By.xpath(element_baidu)).isDisplayed();
        // 获取元素文本
        driver.findElement(By.xpath(element_baidu)).getText();
        // 通过元素获取元素属性值
        driver.findElement(By.xpath(element_baidu)).getAttribute("element");

        // 切换frame标签
        driver.switchTo().frame(element_baidu);
        // 切换到主页面
        driver.switchTo().defaultContent();

        // 执行js语句
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",webElement);

        // 处理alert弹框,获取文本
        driver.switchTo().alert().getText();
        // 处理alert弹框,点击确认
        driver.switchTo().alert().accept();
        // 处理alert弹框,关闭弹框
        driver.switchTo().alert().dismiss();
        // 处理alert弹框,输入文本
        driver.switchTo().alert().sendKeys("string");

        // 实例化鼠标
        Actions actions = new Actions(driver);
        // 鼠标悬停,执行操作
        actions.moveToElement(webElement).perform();
        // 鼠标双击,执行操作
        actions.doubleClick(driver.findElement(By.xpath(element_baidu))).perform();
        // 随机划取字段,执行操作
        actions.clickAndHold(webElement).moveToElement(webElement).perform();
        // 拖拽元素(-->),执行操作
        actions.dragAndDrop(webElement, webElement).build().perform();
        // 关闭实例化
        actions.release();

        // 实例化下拉框
        Select select = new Select(webElement);
        // 通过Index定位
        select.selectByIndex(0);
        // 通过value定位
        select.selectByValue("value");
        // 通过text定位
        select.selectByVisibleText("text");

        // 调用截图方法,截取浏览器界面
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(".\\Screenshots\\screen.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // 调用截图方法,截取整个屏幕,当前屏幕上显示的
        Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage image = new Robot().createScreenCapture(rectangle);
        try{
            ImageIO.write(image, "png", new File(".\\Screenshots\\screen_robot.png"));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        // 正则匹配
        String re = "[\\d]+";
        Pattern retest = Pattern.compile("String");
        Matcher res = retest.matcher(re);
        System.out.println(res.matches());
        if (res.matches()) {
            System.out.println(res.group(0));
            System.out.println(res.group(1));
            System.out.println(res.group(2));
        } else {
            System.out.println("No find result!");
        }

        // 创建一个格式化dateformat对象
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 利用date获取当前时间
        Date date = new Date();
        // 格式化时间
        String StringDate = dateformat.format(date);
        System.out.println(StringDate);
    }
}
