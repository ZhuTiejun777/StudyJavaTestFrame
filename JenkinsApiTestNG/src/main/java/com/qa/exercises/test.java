package com.qa.exercises;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.qa.base.TestBase;
import com.qa.bean.ApiDataBean;
import com.qa.tests.TestApi;
import com.qa.util.ExcelUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.dom4j.DocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.qa.util.ExcelUtil.instantiationBean;
import static com.qa.util.ExcelUtil.readExcel;
import static com.qa.util.ToolsUtil.buildRequestParam;

public class test extends TestBase {

    /*public String testres (String string) {
        return getCommonParam(string);
    }*/
    final static Logger Log = Logger.getLogger(test.class);

    @Test
    public void test01 () {
        String str = "ss";
        System.out.println(null == str || "".equals(str));
        System.out.println(true || false || false);
        if (true || false || false) {
            System.out.println("result");
        }
    }

    @Test
    public void test02 () {
        String shortUrl = "/sss/sss/eee";
        shortUrl = shortUrl.replaceFirst("/", "");
        System.out.println(shortUrl);
    }

    @Test
    public void test03 () {
        System.out.println("post".equalsIgnoreCase("POST"));
        System.out.println("pots".equalsIgnoreCase("POST"));
        System.out.println("Test".equalsIgnoreCase("TEST"));
        System.out.println("Test".equalsIgnoreCase("tEST"));
        System.out.println("test".equalsIgnoreCase("TEST"));
    }


    @Test
    public void test04 () {
        File file = Paths.get(System.getProperty("user.dir"), "excelPath.xls").toFile();
        System.out.println(file.toString());
    }

    @Test
    public void test05 () {
        /*ArrayList<T> arrayList = new ArrayList<>();
        arrayList.forEach((bean) -> {
            bean.setExcelName(file.getName());
        });*/
    }

    @Test
    public void test06 () {
        List<ApiDataBean> temArrayList = new ArrayList<ApiDataBean>();
        // 获取文件路径
        File file = Paths.get(System.getProperty("user.dir"), excelPath).toFile();
        temArrayList = ExcelUtil.readExcel(file.getAbsolutePath());
        for (ApiDataBean apiDataBean : temArrayList) {
            System.out.println(apiDataBean.getHeader());
            System.out.println(apiDataBean.getPreParam());
            System.out.println(apiDataBean.toString());
        }

    }

    @Test
    public void test07 () throws IOException {
        String string = Paths.get(System.getProperty("user.dir"), excelPath).toString();
        File file = new File(string);
        InputStream inputStream = new FileInputStream(file);
        Workbook workbook = new HSSFWorkbook(inputStream);
        inputStream.close();
        int index = workbook.getNumberOfSheets();
        for (int i = 0; i < index; i ++) {
            Sheet sheet = workbook.getSheetAt(i);
            int rowNum = sheet.getLastRowNum();
            Row row = sheet.getRow(0);

        }
    }

    @Test
    public void test08 () throws IOException {
        String string = Paths.get(System.getProperty("user.dir"), excelPath).toString();
        File file = new File(string);
        InputStream inputStream = new FileInputStream(file);
        Workbook workbook = new HSSFWorkbook(inputStream);
        inputStream.close();
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(1);
        Iterator<Cell> iterator = row.cellIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        List<Object> cells = new ArrayList<Object>();
        for (int i = 0; i < row.getLastCellNum(); i ++ ) {
            Cell cell = row.getCell(i);
            //cells.add(getValue(cell));
        }
        System.out.println(cells);

    }

    @Test
    public void test09 () throws IOException {
        String string = Paths.get(System.getProperty("user.dir"), excelPath).toString();
        File file = new File(string);
        InputStream inputStream = new FileInputStream(file);
        Workbook workbook = new HSSFWorkbook(inputStream);
        //取出第一张表，遍历行
        ArrayList<HashMap<String, String>> dataArray = new ArrayList<HashMap<String, String>>();
        Sheet sheet = workbook.getSheetAt(0);
        String sheetName = sheet.getSheetName();
        System.out.println(sheetName);
        Map<Integer, String> keymap = new HashMap<Integer, String>();
        Row row = null;
        //遍历行 getPhysicalNumberOfRows获取物理行 getFirstRowNum获取有数据的第一行行数
        for (int i = sheet.getFirstRowNum(); i <= sheet.getPhysicalNumberOfRows(); i++) {
            try {
                row = sheet.getRow(i);
            } catch (Exception e) {
                e.getStackTrace();
            }
            // 当读取行为空时
            if (row == null) {
                continue;
            }
            HashMap<String, String> hashMap = new HashMap<String, String>();
            // 取出每一行的列数据
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                if (i == 0) {//表头栏
                    keymap.put(j, row.getCell(j).getStringCellValue());
                } else {//数据栏
                    //将每列的表头同每列的数据放入json
                    if (row.getCell(j) != null) {
                        //设置单元格类型
                        Cell cell = row.getCell(j);
                        //row.getCell(j).setCell(CellType.STRING);
                        cell.setCellType(CellType.STRING);
                        hashMap.put(keymap.get(j), row.getCell(j).getStringCellValue());
                    } else {
                        hashMap.put(keymap.get(j), null);
                    }
                }
            }
            //将每行数据json放入json数组
            if (hashMap.size() > 0) {
                dataArray.add(hashMap);
                }
            }
        //判断dataArray是否有数据，有的话调用importjson方法
        // ApiDataBean apiDataBean = new ApiDataBean();
        List<ApiDataBean> list = new ArrayList<>();
        if (dataArray.size() > 0) {
            list = instantiationBean(dataArray, sheetName);
        } else {
            System.out.println("数据为空");
        }
        /*list.forEach(baen -> {
            apiDataBean.setSheetName(sheetName);
        });*/
        if (list != null) {
            for (ApiDataBean apiDataBean : list) {
                System.out.println(apiDataBean.isRun());
                System.out.println(apiDataBean.getDesc());
                System.out.println(apiDataBean.getHeader());
                System.out.println(apiDataBean.getMethod());
                System.out.println(apiDataBean.getSheetName());
            }
        }
    }

    @Test
    public void test10 () {
        String preParam = "qqq";
        if (!"".equals(preParam)) {
            System.out.println(preParam);
        }
    }

    @Test
    public void test11 () throws DocumentException {
        String[] sheetNameArr = sheetName.split(";");
        if (sheetNameArr.length == 0 || sheetNameArr[0] == "") {
            System.out.println("test");
        }
        List<ApiDataBean> dataList = readExcelData(excelPath.split(";"), sheetName.split(";"));
        for (ApiDataBean apidatabean : dataList) {
            System.out.println(apidatabean.getUrl());
            System.out.println(apidatabean.getSheetName());
            System.out.println("--------------------");
        }
    }

    @Test
    public void test12 () {
        String shortUrl = "/bankApi/querySubaccountBalance";
        shortUrl = getCommonParam(shortUrl);
        boolean rooUrlEndWithSlash = url.endsWith("/");
        // 如果url以http开头，直接返回，判断xls中的url
        if (shortUrl.startsWith("http")) {
            System.out.println(shortUrl);
        }
        // 配置项不以"/"结尾false，判读读取文件中的url是否以"/"开头(可能以http开头的全路径url)
        if (rooUrlEndWithSlash == shortUrl.startsWith("/")) {
            // 判断是否配置项以"/"结尾
            if (rooUrlEndWithSlash) {
                // 以"/"结尾，去掉xls中url第一个"/"
                shortUrl = shortUrl.replaceFirst("/", "");
            } else {
                // 加上"/"开头
                shortUrl = "/" + shortUrl;
            }
        }
        System.out.println(url + shortUrl);
    }

    @Test
    public void test13 () throws DocumentException {
        List<ApiDataBean> list = readExcelData(excelPath.split(";"), sheetName.split(";"));
        for (ApiDataBean apiDataBean : list) {
            String apiParam = buildRequestParam(apiDataBean);
            Log.info(apiParam);
            // TODO 执行用例
            HttpClient httpClient = HttpClients.createDefault();
            url = url + apiDataBean.getUrl();
            Log.info(url);
            HttpPost postMethod = new HttpPost(url);
            Log.info(apiDataBean.getHeader());
            for (String stringHeader : apiDataBean.getHeader().split(";")) {
                postMethod.setHeader(stringHeader.split("\"")[1], stringHeader.split("\"")[3]);
                Log.info(stringHeader.split(":")[0]);
                Log.info(stringHeader.split(":")[1]);
            }
            HttpEntity entity = new StringEntity(apiParam, "UTF-8");
            // StringEntity stringEntity = new StringEntity(apiParam.toString());
            postMethod.setEntity(entity);

            HttpResponse response = null;
            String responseData = null;
            try {
                response  = httpClient.execute(postMethod);
                HttpEntity respEntity = response.getEntity();
                responseData= EntityUtils.toString(respEntity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert response != null;
            Log.info(responseData);
            int responseStatus = response.getStatusLine().getStatusCode();
            Log.info(responseStatus);
            Log.info(apiDataBean.getStatus());
            if (apiDataBean.getStatus()!= 0) {
                Assert.assertEquals(responseStatus, apiDataBean.getStatus(), "返回状态码与预期不符合!");
            }
            Log.info(apiDataBean.getVerify());
            for (String stringVerify : apiDataBean.getVerify().split(";")) {
                Log.info(stringVerify);
                Log.info(stringVerify.split("=")[0]);
                Log.info(stringVerify.split("=")[1]);
                String actualValue = JSONPath.read(responseData, stringVerify.split("=")[0]).toString();
                String exceptValue = stringVerify.split("=")[1].trim();
                Log.info("actualValue:" + actualValue);
                Log.info("exceptValue:" + exceptValue);
                Assert.assertEquals(actualValue, exceptValue);
            }
        }
    }

    @Test
    public void test14 () throws IOException, DocumentException {
        List<ApiDataBean> list = readExcelData(excelPath.split(";"), sheetName.split(";"));
        for (ApiDataBean apiDataBean : list) {
            CloseableHttpClient client = HttpClients.createDefault();
            Log.info(url + apiDataBean.getUrl());
            HttpPost httpPost = new HttpPost(url + apiDataBean.getUrl());
            // 处理header字段,添加请求头
            for (String string : apiDataBean.getHeader().split(";")) {
                //httpPost.setHeader(string.split("\"")[1], string.split("\"")[3]);
                System.out.println(string);
                httpPost.setHeader(string.split(":")[0], string.split(":")[1]);
                Log.info("Add Header: " + string.split(":")[0] + "=" + string.split(":")[1]);
                Log.info("Add Header: " + string.split("\"")[1] + "=" + string.split("\"")[3]);
            }
            //httpPost.setHeader("Cookie", cookie);
            // 处理param字段,添加请求数据,json格式
            JSONObject objectParam = JSON.parseObject(apiDataBean.getParam());
            Log.info("Resqust Param: " + objectParam.toString());
            StringEntity stringEntity = new StringEntity(objectParam.toString());
            // 设置请求编码
            // stringEntity.setContentEncoding("UTF-8");
            // 设置请求ContentType
            // stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            CloseableHttpResponse response = client.execute(httpPost);
            System.out.println(EntityUtils.toString(response.getEntity()));
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
        }
    }

    public static void main(String[] args) throws IOException {

        //test test = new test();
        // Pattern replaceParamPattern = Pattern.compile("\\$\\{(.*?)\\}");
        /*Workbook workbook = Workbook.getWorkbook(new File(".//data//TestFormat.xls"));
        Sheet sheet = workbook.getSheet("Sheet1");
        System.out.println(sheet.getCell(5,1).getContents());
        String result = sheet.getCell(5,1).getContents();
        //Pattern replaceParamPattern = Pattern.compile("A(.*?)I");
        Pattern replaceParamPattern = Pattern.compile("\\$\\{(.*?)\\}");
        Matcher matcher = replaceParamPattern.matcher(result);// 取公共参数正则
        Map<String, String> map = new HashMap<>();
        map.put("test", "15094633670");
        map.put("test1", "1509463367011");
        map.put("test11", "150946336701111");
        while (matcher.find()) {
            String replaceKey = matcher.group(1);
            System.out.println(replaceKey);
            *//*System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));*//*
            *//*String value;
            // 从公共参数池中获取值
            value = map.get(replaceKey);
            System.out.println(value);
            // 如果公共参数池中未能找到对应的值，该用例失败。
            Assert.assertNotNull(value,
                    String.format("格式化参数失败，公共参数中找不到%s。", replaceKey));
            result = result.replace(matcher.group(), value);*//*
        }
        System.out.println(result);*/
        //System.out.println(test.testres(result));

        /*HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("");
        HttpUriRequest httpUriRequest = new HttpPost("");
        HttpResponse response = httpClient.execute(httpPost);
        // CloseableHttpResponse

        String param = "{\"custAcctId\":\"{0}\",\"selectFlag\":\"2\",\"pageNum\":1}";
        String global = "ssss";
        // String paramstring = MessageFormat.format(param, global);
        String paramstrings = param.replace("{0}", global);
        System.out.println(paramstrings);*/
        //System.out.println(paramstring);

        /*String string = String.format("name=%s, age=%d", "huhx", 25);
        String message = MessageFormat.format("name={1}, age={0}, {1}", 25, "huhx");
        System.out.println(string);
        System.out.println(message);*/

        /*Workbook book = Workbook.getWorkbook(new File(".//data//MemberTestData.xls"));
        Sheet sheet = book.getSheet("Sheet1");
        String s = sheet.getCell(5, 2).getContents();
        System.out.println(s);
        JSONObject object = JSON.parseObject(s);
        System.out.println(object);
        book.close();*/

        /*String strings = "{\"customerName\":\"\"";
        String string = strings.replaceAll("\"\"", "\" \"");
        System.out.println(string);
        JSONObject objectParam =new JSONObject();
        objectParam.put(string.split("\"")[1], string.split("\"")[3]);
        System.out.println(string.split("\"")[1] + " " + string.split("\"")[3]);
        System.out.println("Resqust Param: " + objectParam.toString());*/

        /*CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://122.224.230.26:20087/member/customerAdvanceManage/viewCustomerAdvancePage");
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.setHeader("Cookie", "userId=admin; JSESSIONID=56AB95615FBB3D9F7EEBBB3654FD38D2; StimulsoftWebViewerExportSettingsOpeningGroups=%7B%22SavingReportGroup%22%3Atrue%2C%22PageRangeGroup%22%3Atrue%2C%22SettingsGroup%22%3Afalse%7D; StimulsoftWebViewerExportSettingsPdf=%7B%22PageRange%22%3A%22All%22%2C%22ImageResolution%22%3A%22100%22%2C%22ImageCompressionMethod%22%3A%22Jpeg%22%2C%22ImageQuality%22%3A%220.75%22%2C%22EmbeddedFonts%22%3Atrue%2C%22ExportRtfTextAsImage%22%3Afalse%2C%22PdfACompliance%22%3Afalse%2C%22OpenAfterExport%22%3Afalse%2C%22AllowEditable%22%3A%22No%22%2C%22PasswordInputUser%22%3A%22%22%2C%22PasswordInputOwner%22%3A%22%22%2C%22KeyLength%22%3A%22Bit40%22%2C%22UseDigitalSignature%22%3Afalse%2C%22GetCertificateFromCryptoUI%22%3Afalse%2C%22UserAccessPrivileges%22%3A%22PrintDocument%2C%20ModifyContents%2C%20CopyTextAndGraphics%2C%20AddOrModifyTextAnnotations%22%7D; StiMobileDesignerDictionarySettings=%7B%22createFieldOnDoubleClick%22%3Afalse%2C%22createLabel%22%3Afalse%2C%22useAliases%22%3Afalse%7D; cultureName=Chinese%20%28Simplified%29; Hm_lvt_f77bd85237c7b8ad95f2c69d375bba4c=1593482363,1594343111,1594343128,1594629499; __wpkreporterwid_=fb272633-29ae-4346-a9ad-5b2ad6ed8deb");
        JSONObject object = new JSONObject();
        object.put("account", "");
        object.put("beginDate", "");
        object.put("certificateNo", "");
        object.put("contractingAgency", "");
        object.put("currPage", "1");
        object.put("custAcctid", "");
        object.put("customerId", "");
        object.put("customerMobile", "");
        object.put("customerName", "");
        object.put("customerType", "");
        object.put("endDate", "");
        object.put("member", "");
        object.put("memberStatus", "");
        object.put("openStatus", "");
        object.put("pageSize", "10");
        object.put("productModel", "");
        object.put("promotionChannel", "");
        object.put("state", "");
        object.put("totalNum", "0");
        object.put("totalPage", "1");
        httpPost.setEntity(new StringEntity(object.toString(), "UTF-8"));
        CloseableHttpResponse response = client.execute(httpPost);
        System.out.println(response.getStatusLine().getStatusCode());*/
        //Object obj = JSON.parseObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
        //JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
        //System.out.println(((JSONObject) ((JSONObject) obj).get("payload")).get("count").toString());
        //System.out.println(jsonObject.getJSONObject("payload").getString("count"));
        //String s = ((JSONObject) ((JSONObject) obj).get("payload")).get("count").toString();
    }
}
