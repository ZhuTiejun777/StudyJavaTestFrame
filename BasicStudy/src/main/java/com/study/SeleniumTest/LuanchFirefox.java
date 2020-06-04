package com.study.SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * driver.navigate()操作网页导航功能：前进、后退、刷新等
 * driver.manage()操作网页和获取界面值
 */

public class LuanchFirefox {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.baidu.com");

        Thread.sleep(2000);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // to(String url)在当前页打开新的网页
        driver.navigate().to("http://news.baidu.com");
        Thread.sleep(2000);

        // back()后退到百度首页
        driver.navigate().back();

        Thread.sleep(2000);
        // forward() 前进到百度新闻
        driver.navigate().forward();

        Thread.sleep(2000);
        // 刷新当前页
        driver.navigate().refresh();

        // 获取页面title
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println(title);
        assert title =="百度一下，你就知道";
        // 或者这样写断言
        assert title.equals("百度一下，你就知道");

        // 获取当前页面url
        String current_url = driver.getCurrentUrl();
        assert current_url == "http://news.baidu.com";

        // 获取当前页面源码
        System.out.println(driver.getPageSource());

        // 获取浏览器句柄,getWindowHandles()返回一个Set集合
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
        // 获取当前页面句柄
        String handle = driver.getWindowHandle();
        // 获取所有页面的句柄，并循环判断不是当前的句柄
        // 从页面A切换到页面B，同时关闭页面A
        for (String temhandle : driver.getWindowHandles()) {
            if (!temhandle.equals(handle))
                driver.close();
                // 切换到句柄页面
                driver.switchTo().window(temhandle);
        }
        // equals函数判断相等返回布尔型
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle))
                // 跳过本次循环
                continue;
            // 从A页面跳到B页面
            driver.switchTo().window(handles);
        }

        // quit()和close()的区别,quit()退出浏览器驱动,close()关闭当前页面
        driver.quit();
        driver.close();

    }

}
