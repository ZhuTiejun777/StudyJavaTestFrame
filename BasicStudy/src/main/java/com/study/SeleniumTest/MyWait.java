package com.study.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MyWait {

    public static WebElement isElementPresent(WebDriver driver, String xpath, int time){
        WebElement ele = null;
        for (int i = 0; i < time; i++) {
            try {
                ele = driver.findElement(By.xpath(xpath));
                break;
            } catch (Exception e1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e2) {
                    System.out.println("Wait for element to appear on DOM");
                }
            }
        }
        return ele;
    }
}
