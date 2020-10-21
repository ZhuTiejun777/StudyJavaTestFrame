package com.qa.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.jayway.jsonpath.JsonPath;
import com.qa.restclient.RestClient;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;


public class TestUtil {

    /**
     * @param responseJson ,这个变量是拿到响应字符串通过json转换成json对象
     * @param jpath,这个jpath指的是用户想要查询json对象的值的路径写法
     * jpath写法举例：1) per_page  2)data[1]/first_name ，data是一个json数组，[1]表示索引
     * /first_name 表示data数组下某一个元素下的json对象的名称为first_name
     * @return，返回first_name这个json对象名称对应的值
     */

    final static Logger Log = Logger.getLogger(RestClient.class);

    //1 json解析方法
    //jpath写法举例：1) per_page  2)data[1]/first_name ，data是一个json数组，[1]表示索引
    public static String getValueByJPath(JSONObject responseJson, String jpath) {
        Object obj = responseJson;
        for (String s : jpath.split("/")) {
            if (!s.isEmpty()) {
                if (!(s.contains("[") || s.contains("]"))) {
                    obj = ((JSONObject) obj).get(s);
                } else if (s.contains("[") || s.contains("]")) {
                    obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replaceAll("]", "")));
                }
            }
        }
        return obj.toString();
    }


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

    public static String readjsonpath(CloseableHttpResponse response, String path) throws IOException {
        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        Log.info("Response Param: " + content);
        return JSONPath.read(content, path.split("=")[1]).toString();
    }


    public static String readpath(CloseableHttpResponse response, String path) throws IOException {
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
    }

    public static Map<String, String> readresult(String result) {
        Map<String, String> map = new HashMap<String, String>();
        for (String string : result.replaceAll("\n", "").split(";")) {
            map.put(string.split("=")[0], string.split("=")[1]);
            Log.info("Result: " + string.split("=")[0] + "=" + string.split("=")[1]);
        }
        return map;
    }

    /*// 解析param参数
    public static StringEntity disposeParam (String param) throws UnsupportedEncodingException {
        JSONObject objectParam =new JSONObject();
        for (String string : param.split(";")) {
            objectParam.put(string.split("\"")[1], string.split("\"")[3]);
        }
        Log.info("Resqust Param: " + objectParam.toString());
        StringEntity stringEntity = new StringEntity(objectParam.toString());
        // 设置请求编码
        stringEntity.setContentEncoding("UTF-8");
        // 设置请求ContentType
        stringEntity.setContentType("application/json");
        return stringEntity;
    }*/


    /*public static Object[][] readxls (String file) throws IOException, BiffException {
        //Workbook book = Workbook.getWorkbook(new File(".\\data\\TestData.xls"));
        Workbook book = Workbook.getWorkbook(new File(file));
        Sheet[] sheets = book.getSheets();
        List<List<String>> lists = new ArrayList<List<String>>();
        int listSize = 0;
        if (sheets != null) {
            for (Sheet sheet : sheets) {
                int rows = sheet.getRows();
                int cols = sheet.getColumns();
                for (int row = 1; row < rows; row ++) {
                    List<String> list = new ArrayList<String>();
                    for (int col = 0; col < cols; col ++) {
                        Cell cell = sheet.getCell(col, row);
                        list.add(cell.getContents());
                    }
                    listSize = list.size();
                    lists.add(list);
                }
            }
        }
        book.close();
        int listsSize = lists.size();
        Object[][] objects = new Object[listsSize][listSize];
        for (int i = 0; i < listsSize; i ++) {
            for (int j =0; j < listSize; j++) {
                objects[i][j] = lists.get(i).get(j);
            }
        }
        return objects;
    }*/

}