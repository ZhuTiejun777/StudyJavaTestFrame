package com.qa.practice;

import org.apache.http.impl.execchain.TunnelRefusedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.io.*;
import java.util.*;
import java.util.concurrent.Callable;

public class TestDDT {

    @Test(dataProvider = "testdata")
    public void TestLogin(String username, String password) throws Exception {

        System.setProperty("webdriver.firefox.bin", "E:\\test_tools\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com");

        System.out.println(username + password);

        // click login link
        driver.findElement(By.xpath("//*[@id='u1']/a[7]")).click();
        Thread.sleep(2000);

        // driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_8__userName']")).clear();
        // driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_8__userName']")).sendKeys(username);
        // driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_8__password']")).clear();
        // driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_8__password']")).sendKeys(password);

    }

    //@DataProvider(name="testdata")
    public Object[][] TestDataFeed1() {
        //创建一个二维数组
        Object[][] baidudata = new Object[2][2];
        // 设置数组的元素值，这里是设置第一个用户名
        baidudata[0][0] = "Selenium1@baidu.com";
        // 设置第一个用户密码
        baidudata[0][1] = "Password1";
        // 设置第二个用户名称
        baidudata[1][0] = "Selenium2@baidu.com";
        // 设置第二个用户密码
        baidudata[1][1] = "Password2";
        // 返回数据传给脚本
        return baidudata;
    }

    //@Parameters("path_test1")
    @DataProvider(name = "testdata")
    public Object[][] TestDataFeed() throws Exception {
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
        // 读取文件
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(".//file//data.csv")));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            Map<String, String> map = new HashMap<String, String>();
            String key = line.split(",")[0];
            String value = line.split(",")[1];
            map.put("userName", key);
            map.put("passWord", value);
            list.add(map);
        }
        br.close();
        Object[][] files = new Object[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            files[i] = new Object[] {
                list.get(i)
            };
        }
        return files;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Object[][] files = new Object[2][2];
        int i = 0;
        // 读取文件
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(".//file//data.csv")));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            Map<String, String> map = new HashMap<String, String>();
            files[i][0] = line.split(",")[0];
            files[i][1] = line.split(",")[1];
            System.out.println(files[i][0]);
            System.out.println(files[i][1]);
            System.out.println("-------");
            String key = line.split(",")[0];
            String value = line.split(",")[1];
            map.put("userName", key);
            map.put("passWord", value);
            //map.put(key, value);
            list.add(map);
        }
        br.close();
        //System.out.println(list);
        //System.out.println(list.get(0));
        for (Map<String, String> maps : list) {
            System.out.println(maps.get("userName"));
            System.out.println(maps.get("passWord"));
            System.out.println();
            System.out.println(i);
            files[i][0] = maps.get("userName");
            files[i][1] = maps.get("passWord");
            //System.out.println(list.indexOf(j));
            //System.out.println(maps);
            //System.out.println(maps.entrySet());
            // maps.keySet() [passWord, userName]
            //System.out.println(maps.keySet());
            //System.out.println(maps.values());

//            for (String key : maps.keySet()) {
//                System.out.println(maps.get(key));
//                files[i][0] = maps.get(key);
//                files[i][1] = maps.values();
//            }
            i += 1;
        }

        System.out.println(files[2][2]);
    }


}




