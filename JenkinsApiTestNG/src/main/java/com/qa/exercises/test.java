package com.qa.exercises;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;

public class test {

    public static void main(String[] args) throws IOException, BiffException {

        String param = "{\"custAcctId\":\"{0}\",\"selectFlag\":\"2\",\"pageNum\":1}";
        String global = "ssss";
        String paramstring = MessageFormat.format(param, global);
        String paramstrings = param.replace("{0}", global);
        System.out.println(paramstrings);
        System.out.println(paramstring);

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
