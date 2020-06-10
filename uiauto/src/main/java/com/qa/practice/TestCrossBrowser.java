package com.qa.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCrossBrowser {

    @Test
    // 这行@Test一定要写，如果不写，表示当前没有需要执行的脚本，你可以测试不写，然后run testng.xml试试看，会发生什么
    @Parameters("Browser")
    public void startBrowser (String browser) {

        if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://www.baidu.com");
            driver.quit();
        }
        else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.baidu.com");
            driver.quit();
        }
    }
}
