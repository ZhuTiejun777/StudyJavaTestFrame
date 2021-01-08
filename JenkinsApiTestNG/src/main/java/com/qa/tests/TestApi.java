package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.bean.ApiDataBean;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

import static com.qa.util.MethodUtil.parseHttpRequest;
import static com.qa.util.ToolsUtil.*;


//@Feature("FeatureTest")
public class TestApi extends TestBase {

    /**
     * 是否使用form-data传参 会在post与put方法封装请求参数用到
     */
    // private static boolean requestByFormData = false;

    final static Logger Log = Logger.getLogger(TestApi.class);

    @Test(dataProvider = "apiDatas")
    /*@Story("StoryTest")
    @Description("DescriptionTest")
    @Step("StepTest")*/
    public void test01 (ApiDataBean apiDataBean) throws UnsupportedEncodingException, InterruptedException {
        if (apiDataBean.getSleep() > 0) {
            // sleep休眠时间大于0的情况下进行暂停休眠
            Log.info(String.format("sleep %s seconds", apiDataBean.getSleep()));
            Thread.sleep(apiDataBean.getSleep() * 1000);
        }
        // String apiParam = buildRequestParam(apiDataBean);
        // String rootUrl = parseUrl(apiDataBean.getUrl(), url);
        // Log.info("请求数据:" + apiParam);
        HttpClient httpClient = HttpClients.createDefault();
        HttpUriRequest method = parseHttpRequest(apiDataBean, url);
        String responseData = null;
        try {
            HttpResponse response = httpClient.execute(method);
            HttpEntity respEntity = response.getEntity();
            responseData= EntityUtils.toString(respEntity, "UTF-8");
            Log.info("响应数据:" + responseData);
            int responseStatus = response.getStatusLine().getStatusCode();
            Log.info("状态码:" + responseStatus);
            if (apiDataBean.getStatus()!= 0) {
                Assert.assertEquals(responseStatus, apiDataBean.getStatus(), "返回状态码与预期不符合!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO 断言结果 状态码枚举类 添加到util 状态码提取xls中的数据
        // 验证预期信息
        verifyResult(responseData, apiDataBean.getVerify());
        // 对返回结果进行提取保存。
        saveResult(responseData, apiDataBean.getSave());
        // TODO 文件上传
        System.out.println(getSaveDatas("test"));
    }

    /**
     * 过滤数据，run标记为Y的执行。
     *
     * @return
     * @throws DocumentException
     */
    @DataProvider(name = "apiDatas")
    public Iterator<Object[]> getApiData() throws DocumentException {
        /**
         * 所有api测试用例数据
         */
        List<ApiDataBean> dataList = readExcelData(excelPath.split(";"), sheetName.split(";"));

        List<Object[]> dataProvider = new ArrayList<Object[]>();
        for (ApiDataBean data : dataList) {
            if (data.isRun()) {
                dataProvider.add(new Object[] { data });
            }
        }
        return dataProvider.iterator();
    }

}
