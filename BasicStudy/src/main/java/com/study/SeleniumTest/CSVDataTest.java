package com.study.SeleniumTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVDataTest {
    public List<Map<String, String>> getData(String filePath) {
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                Map<String, String> map = new HashMap<String, String>();
                String key = line.split(",")[0];
                String value = line.split(",")[1];
                map.put("userName", key);
                map.put("passWord", value);
                list.add(map);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @DataProvider
    public Object[][] testCVSData() {
        List<Map<String, String>> result = getData(".\\file\\data.csv");
        Object[][] files = new Object[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            files[i] = new Object[] {
                    result.get(i)
            };
        }
        return files;
    }

    @Test(dataProvider = "testCVSData")
    public void testCSVData(Map<String,String> param) {
        System.out.println(param.get("userName")+"\t"+param.get("passWord"));
    }
}
