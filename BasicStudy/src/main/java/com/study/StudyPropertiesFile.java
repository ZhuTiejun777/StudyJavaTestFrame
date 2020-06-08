package com.study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class StudyPropertiesFile {

    public static String browser_Name;
    public static String server_Url;

    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        InputStream ips = new FileInputStream(".//src//main//resources//config.properties");
        pro.load(ips);

        browser_Name = pro.getProperty("browserName");
        server_Url = pro.getProperty("serverUrl");

        System.out.println(browser_Name);
        System.out.println(server_Url);

        ips.close();

    }
}
