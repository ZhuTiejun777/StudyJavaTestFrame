package com.qa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qa.practice.HttpClientTest;
import com.qa.practice.RestClientTest;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException, BiffException {




        /*CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://192.168.1.18:8088/bankApi/queryCustSubaccountBalance");
        JSONObject obj = new JSONObject();
        obj.put("custAcctId", "3294000000102488");
        StringEntity stringEntity = new StringEntity(obj.toString());
        stringEntity.setContentEncoding("UTF-8");
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = client.execute(httpPost);
        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        // string转化为json格式,Json字符串转换成JSONObject对象
        JSONObject jsonObject= JSON.parseObject(content);
        *//*JSONObject jsonObject1 = jsonObject.getJSONObject("payload");
        String string = jsonObject1.getString("BodyMsg");
        System.out.println(string.split("&")[1]);
        String text = jsonObject.toJSONString();*//*
        Workbook book = Workbook.getWorkbook(new File(".\\data\\TestData.xls"));
        //Workbook book = Workbook.getWorkbook(new File(file));
        Sheet sheet = book.getSheet("Sheet1");
        System.out.println(sheet.getCell(6, 1).getContents());
        String strings = sheet.getCell(6, 1).getContents();
        String balanceString = strings.split("=")[0];
        *//*System.out.println(balanceString);
        System.out.println(strings.split("=")[1]);*//*
        Object object = jsonObject;
        //String jpath = "payload/BodyMsg";
        for(String s : strings.split("=")[1].split("/")) {
            if(!s.isEmpty()) {
                if(!(s.contains("[") || s.contains("]"))) {
                    object = ((JSONObject) object).get(s);
                }else if(s.contains("[") || s.contains("]")) {
                    object =((JSONArray)((JSONObject)object).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replaceAll("]", "")));
                }
            }
        }
        System.out.println(object.toString());*/


        /*Object object = jsonObject;
        String string = null;
        for (String s : strings.split("=")[1].split("/")) {
            System.out.println("-------------");
            System.out.println(s);
            if (s.contains("{") || s.contains("}")) {
                object = ((JSONObject) object).getJSONObject(s.substring(0, s.length()-2));
            } else {
                string = ((JSONObject) object).getString(s);
            }
            System.out.println(object);
            System.out.println(string);
            System.out.println("-------------");
        }*/

        /*JSONObject object =new JSONObject();
        for (String string : strings.split(";")) {
            object.put(string.split("\"")[1], string.split("\"")[3]);
        }
        System.out.println(object);
        int rows = sheet.getRows();
        int cols = sheet.getColumns();
        Object[][] objects = new Object[rows - 1][cols];
        for (int row = 1; row < rows; row ++) {
            for (int col = 0; col < cols; col ++) {
                objects[row - 1][col] = sheet.getCell(col, row).getContents();
                System.out.println(sheet.getCell(col, row).getContents());
            }
        }*/
        /*response.close();
        client.close();
        book.close();*/



        /*// 字符串切割，如果呗切割字符在字符串首位，string[]的第一个元素为“ ”
        String strings = "abbbbbabbbbbba";
        Map<String,String> maps = new HashMap<String, String>();
        strings.split("\"");
        for (String string : strings.split("a")) {
            *//*System.out.println("------------------");
            System.out.println(string.split("\"")[0]);
            System.out.println(string.split("\"")[1]);
            System.out.println(string.split("\"")[2]);
            System.out.println(string.split("\"")[3]);
            maps.put(string.split("\"")[1], string.split("\"")[3]);
            System.out.println(maps);*//*
            System.out.println(string);
        }
        System.out.println(maps);*/

       /* Workbook book = Workbook.getWorkbook(new File(".\\data\\TestData.xls"));
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
                        //System.out.println(cell.getContents());
                    }
                    //System.out.println(list);
                    listSize = list.size();
                    lists.add(list);
                }
            }
        }
        //System.out.println(lists);
        book.close();
        int listsSize = lists.size();
        System.out.println(listSize);
        System.out.println(listsSize);
        Object[][] objects = new Object[listsSize][listSize];
        for (int i = 0; i < listsSize; i ++) {
            for (int j =0; j < listSize; j++) {
                objects[i][j] = lists.get(i).get(j);
            }
        }*/

        /*CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://192.168.8.31:9080/tsnAirImport/airImport/create");
        CloseableHttpResponse response = client.execute(httpPost);*/

        /*HttpClientTest httpClientTest = new HttpClientTest();
        httpClientTest.get("http://www.csdn.net/");
        RestClientTest restClientTest = new RestClientTest();
        restClientTest.get("http://www.csdn.net/");*/
        /*List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>();
        List<List<String>> lists = new ArrayList<List<String>>();
        int arrayslength = 0;
        int listsize = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(".//data//custacctid.csv")));
        for (String string = bufferedReader.readLine(); string != null; string = bufferedReader.readLine()) {
            System.out.println(string);
            String[] strings = string.split(",");
            arrayslength  = strings.length;
            System.out.println(strings.length);
            System.out.println(Arrays.toString(strings));
            List<String> arraylist = Arrays.asList(strings);
            System.out.println(arraylist);
            lists.add(arraylist);
        }
        System.out.println(lists);
        listsize = lists.size();
        System.out.println(listsize);
        System.out.println(arrayslength);
        Object[][] objects = new Object[lists.size()][arrayslength];
        for (int i = 0; i < listsize; i++) {
            for (int j = 0; j < arrayslength; j ++) {
                objects[i][j] = lists.get(i).get(j);
            }
        }
        System.out.println(objects);*/
    }

}
