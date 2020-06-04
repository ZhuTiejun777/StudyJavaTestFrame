package com.study.SeleniumTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenshotTest {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.firefox.bin","E:\\test_tools\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.baidu.com");
        Thread.sleep(5000);

        // 调用截图方法,截取浏览器界面
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(".\\Screenshots\\screen.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // 调用截图方法,截取整个屏幕,当前屏幕上显示的
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        // Rectangle ss = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        // BufferedImage image1 = new Robot().createScreenCapture(ss);
        try{
            ImageIO.write(image, "png", new File(".\\Screenshots\\screen_robot.png"));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
