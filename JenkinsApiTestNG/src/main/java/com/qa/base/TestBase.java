package com.qa.base;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qa.util.StringUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class TestBase {

    // public Properties prop;
    public String host;

    /**
     * 公共参数数据池（全局可用）
     */
    private static Map<String, String> saveDatas = new HashMap<String, String>();

    /**
     * 截取自定义方法正则表达式：__xxx(ooo)
     */
    protected Pattern funPattern = Pattern
            .compile("__(\\w*?)\\((([\\w\\\\\\/:\\.\\$]*,?)*)\\)");// __(\\w*?)\\((((\\w*)|(\\w*,))*)\\)
    // __(\\w*?)\\(((\\w*,?\\w*)*)\\)

    /**
     * 替换符，如果数据中包含“${}”则会被替换成公共参数中存储的数据
     */
    protected Pattern replaceParamPattern = Pattern.compile("\\$\\{(.*?)\\}");


    //写一个构造函数
    public TestBase() {

        final Logger Log = Logger.getLogger(TestBase.class);
        /*try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/qa/config/config.properties");
            prop.load(fis);
            Log.info("正在读取配置文件...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.error("配置文件没有找到");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        host = resourceBundle.getString("HOST");
    }

    /**
     * 取公共参数 并替换参数
     *
     * @param param
     * @return
     */
    protected String getCommonParam(String param) {
        if (StringUtil.isEmpty(param)) {
            return "";
        }
        Matcher m = replaceParamPattern.matcher(param);// 取公共参数正则
        while (m.find()) {
            String replaceKey = m.group(1);
            String value;
            // 从公共参数池中获取值
            value = getSaveData(replaceKey);
            // 如果公共参数池中未能找到对应的值，该用例失败。
            Assert.assertNotNull(value,
                    String.format("格式化参数失败，公共参数中找不到%s。", replaceKey));
            param = param.replace(m.group(), value);
        }
        return param;
    }

    /**
     * 获取公共数据池中的数据
     *
     * @param key
     *            公共数据的key
     * @return 对应的value
     */
    protected String getSaveData(String key) {
        if ("".equals(key) || !saveDatas.containsKey(key)) {
            return null;
        } else {
            return saveDatas.get(key);
        }
    }
}
