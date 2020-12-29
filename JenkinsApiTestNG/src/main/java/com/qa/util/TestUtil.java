package com.qa.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.jayway.jsonpath.JsonPath;
import com.sun.net.httpserver.Headers;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.apache.http.entity.mime.MultipartEntity;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;


public class TestUtil {

    final static Logger Log = Logger.getLogger(TestUtil.class);

    public static Object[][] readcsv(String file) throws IOException {
        List<List<String>> lists = new ArrayList<List<String>>();
        int arrayslength = 0;
        int listsize = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        for (String string = bufferedReader.readLine(); string != null; string = bufferedReader.readLine()) {
            String[] strings = string.split(",");
            arrayslength = strings.length;
            List<String> arraylist = Arrays.asList(strings);
            lists.add(arraylist);
        }
        listsize = lists.size();
        Object[][] objects = new Object[listsize][arrayslength];
        for (int i = 0; i < listsize; i++) {
            for (int j = 0; j < arrayslength; j++) {
                objects[i][j] = lists.get(i).get(j);
            }
        }
        return objects;
    }


    public static Object[][] readxls(String file) throws IOException, BiffException {
        //Workbook book = Workbook.getWorkbook(new File(".\\data\\TestData.xls"));
        Workbook book = Workbook.getWorkbook(new File(file));
        Sheet sheet = book.getSheet("Sheet1");
        int rows = sheet.getRows();
        int cols = sheet.getColumns();
        Object[][] objects = new Object[rows - 1][cols];
        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                objects[row - 1][col] = sheet.getCell(col, row).getContents();
                System.out.println(sheet.getCell(col, row).getContents());
            }
        }
        book.close();
        return objects;
    }

    public static String readpath(CloseableHttpResponse response, String path) throws IOException {
        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        //JSONObject jsonObject = JSON.parseObject(content);
        Log.info("Response Param: " + content);
        return JsonPath.read(content, path.split("=")[1]).toString();
    }

    /*public static String readpath(CloseableHttpResponse response, String path) throws IOException {
        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        Log.info("Response Param: " + content);
        Object object = JSON.parseObject(content);
        for (String s : path.split("=")[1].split("/")) {
            if (!s.isEmpty()) {
                if (!(s.contains("[") || s.contains("]"))) {
                    object = ((JSONObject) object).get(s);
                } else if (s.contains("[") || s.contains("]")) {
                    object = ((JSONArray) ((JSONObject) object).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replaceAll("]", "")));
                }
            }
        }
        return object.toString();
    }*/

    public static Map<String, String> readresult(String result) {
        Map<String, String> map = new HashMap<String, String>();
        for (String string : result.replaceAll("\n", "").split(";")) {
            map.put(string.split("=")[0], string.split("=")[1]);
            Log.info("Result: " + string.split("=")[0] + "=" + string.split("=")[1]);
        }
        return map;
    }

}