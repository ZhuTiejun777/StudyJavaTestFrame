package com.qa.base;

import com.qa.util.TestUtils;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.*;
import java.util.Properties;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class TestBase {

    /*public Properties prop;
    //写一个构造函数
    public TestBase() {
        final Logger Log = Logger.getLogger(TestBase.class);
        try {
            prop = new Properties();
            // FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/qa/config/config.properties");
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources/config.properties");
            prop.load(fis);
            Log.info("正在读取配置文件...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.error("配置文件没有找到");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;
    public static Response response;
    public Logger logger;

    public static String host;
    public static String port;

    //Global Setup Variables
    //public Response response = null; //Response
    //public JsonPath jsonpath = null; //JsonPath
    //测试用例中断言代码能用上这里的 testUtils对象
    public static TestUtils testUtils = new TestUtils();

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        host = resourceBundle.getString("HOST");
        port = resourceBundle.getString("PORT");
    }

    public static void main(String[] args) {
        final Logger logger = Logger.getLogger(TestBase.class);
        logger.info(Integer.parseInt(port));
    }

    @BeforeClass
    public void setup() {
        String className = this.getClass().getName();
        logger = Logger.getLogger(className);
        // PropertyConfigurator.configure("log4j.properties");
        logger.setLevel(Level.DEBUG);
        // logger.info("host: " + host);
        // logger.info("port: " + port);
        // RestAssured.baseURI = host;
        // RestAssured.port = Integer.parseInt(port);
        setBaseURI(); //设置Base URI
        //设置Base Path，我这里是api（https://reqres.in/接口地址都是api开头，所以
        //这里basepath设置api这个字符串），看看具体你自己项目请求地址结构
        // setBasePath("api");
        //setPort();
        // setContentType(ContentType.JSON); //设置Content Type post设置无效,post请求重新实例化了新的given对象
        /*RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecification = requestSpecBuilder.build();*/

        requestSpecification = getRequestSpecification();
        responseSpecification = getResponseSpecification();
    }

    @AfterClass
    public void afterTest () {
        resetBaseURI();
        //resetPort();
        // resetBasePath();
    }

    //设置 base URI
    public static void setBaseURI (){
        //RestAssured.baseURI = host;
        if("80".equals(port)) {
            RestAssured.baseURI = host;
        }else {
            RestAssured.baseURI = host + ":" + port;
        }
        //System.out.println(RestAssured.baseURI);
    }

    /*public static void setPort () {
        RestAssured.port = Integer.parseInt(port);
    }*/

    //设置base path
    public static void setBasePath(String basePath){
        RestAssured.basePath = basePath;
    }

    //执行完测试后重置 Base URI
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }

    /*public static void resetPort () {
        RestAssured.port = -1;
    }*/

    //执行完测试后重置 base path
    public static void resetBasePath(){
        RestAssured.basePath = null;
    }

    //设置请求 ContentType
    public static void setContentType (ContentType Type){
        given().contentType(Type);
    }

    public static RequestSpecification getRequestSpecification () {
        // return new RequestSpecBuilder().setContentType(ContentType.JSON).build();
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        return requestSpecBuilder.build();
    }

    public static ResponseSpecification getResponseSpecification () {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.expectStatusCode(200);
        return responseSpecBuilder.build();
    }

    //返回指定请求path的 response内容
    public static Response getResponsebyPath(String path) {
        return given().spec(requestSpecification).get(path);
    }

    public static Response postResponByPath (String path, Object object) {
       // return given().contentType("application/json").body(object).post(path);
        return given().spec(requestSpecification).body(object).post(path);
    }

    //返回响应内容
    public static Response getResponse() {
        return get();
    }

    //返回 JsonPath对象
    public static JsonPath getJsonPath (Response response) {
        // 以字符串形式拿到所有响应
        String json = response.asString();
        //System.out.print("returned json: " + json +"\n");
        // 字符串转换为json
        return new JsonPath(json);
    }

}
