package com.qa.base;

import com.qa.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

/**
 * 子类无法继承父类的私有方法和变量,使用get()和set()可以
 */

public class BasePage {

    WebDriver driver;

    public void getdriver () {
        Util util = new Util();
        driver = util.getFirefox();
    }

    public WebElement getelement (String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public void sendkeytext (WebElement element, String text) {
        element.clear();
        Reporter.log("输入:" + text);
        element.sendKeys(text);
    }

    public void clickelement (WebElement element) {
        Reporter.log("点击:" + element);
        element.click();
    }


}
