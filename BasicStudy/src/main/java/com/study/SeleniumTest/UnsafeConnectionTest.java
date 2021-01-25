package com.study.SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class UnsafeConnectionTest {

    public static void main(String[] args) {

        // ChromeOptions opts = new ChromeOptions();
        // opts.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        // WebDriver driver = new ChromeDriver(opts);

        System.setProperty("webdriver.chrome.driver","./driver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        //FirefoxOptions options = new FirefoxOptions();
        // 关闭提示语
        // options.addArguments("disable-infobars");
        // 跳过网站不安全界面
        // options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        // 加载浏览器的静默模式,使浏览器在后台运行
        // options.addArguments("headless");
        // 设置默认编码为 utf-8，也就是中文
        // options.addArguments("lang=zh_CN.UTF-8");
        // 取消沙盒模式
        options.addArguments("–no-sandbox");
        // options.addArguments("-disable-gpu");
        // options.addArguments("--disable-images");
        // options.addArguments("--blink-settings=imagesEnabled=false");
        // 禁用图像
        // options.addArguments("–disable-images");
        // 启动进入隐身模式
        // options.addArguments("–incognito");
        // 禁用插件
        // options.addArguments("–disable-plugins");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://kyfw.12306.cn/otn");

    }
}
