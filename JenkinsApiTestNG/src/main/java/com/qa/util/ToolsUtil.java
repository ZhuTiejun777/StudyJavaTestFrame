package com.qa.util;

import com.alibaba.fastjson.JSONPath;
import com.qa.bean.ApiDataBean;
import org.apache.log4j.Logger;
import org.testng.Assert;

import static com.qa.base.TestBase.getCommonParam;
import static com.qa.base.TestBase.savePreParam;

public class ToolsUtil {


    final static Logger Log = Logger.getLogger(ToolsUtil.class);

    /**
     * 断言响应结果
     *
     */
    public static void verifyResult(String sourchData, String verifyStr) {
        if (null == sourchData || "".equals(sourchData)) {
            return;
        }
        // 全局变量替换断言数据
        String allVerify = getCommonParam(verifyStr);
        // 通过';'分隔，通过jsonPath进行一一校验
        for (String stringVerify : allVerify.split(";")) {
            String actualValue = JSONPath.read(sourchData, stringVerify.split("=")[0]).toString();
            String exceptValue = stringVerify.split("=")[1].trim();
            Log.info("actualValue:" + actualValue);
            Log.info("exceptValue:" + exceptValue);
            Assert.assertEquals(actualValue, exceptValue);
        }
    }

    /**
     * 参数处理
     *
     */
    public static String buildRequestParam(ApiDataBean apiDataBean) {
        // 分析处理预参数 （函数生成的参数）
        // TODO PreParam参数保存来自那里，优化去掉这个方法
        // String preParam = buildParam(apiDataBean.getPreParam());
        String preParam = apiDataBean.getPreParam();
        if (!"".equals(preParam)) {
            preParam = getCommonParam(preParam);
            savePreParam(preParam);// 保存预存参数 用于后面接口参数中使用和接口返回验证中
        }
        // 处理参数
        // String apiParam = buildParam(apiDataBean.getParam());
        // return apiParam;
        // return buildParam(apiDataBean.getParam());
        String apiParam = apiDataBean.getParam();
        apiParam = getCommonParam(apiParam);
        return apiParam;
    }

}
