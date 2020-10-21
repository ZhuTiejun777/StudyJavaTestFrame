package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Util {

    WebDriver driver;

    public WebDriver getFirefox() {
        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }
}
