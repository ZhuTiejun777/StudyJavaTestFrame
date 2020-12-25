package com.qa.cases;

import com.qa.base.TestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class TestBankAccoutBill extends TestBase {

    @Test
    public void test01 () {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("custAcctId", "3294000000102488");
        hashMap.put("selectFlag", "2");
        hashMap.put("pageNum", 1);

        given().contentType(ContentType.JSON).body(hashMap).when().post("/bankApi/querySubaccountBalance").then().log().all();
    }

    @Test
    public void test02 () {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Cookie", "userId=admin; JSESSIONID=14C1A9E94772CE09BDD6634B3316EA74");
        hashMap.put("Content-Type", "application/json;charset=UTF-8");
        HashMap<String, Object> boby = new HashMap<>();
        given().headers(hashMap).cookie("userId=admin; JSESSIONID=14C1A9E94772CE09BDD6634B3316EA74").when().post("http://122.224.230.26:20087/member/pointOut/queryPointOutCount").then().contentType(ContentType.JSON).body("mag", is("成功")).log().all();
        /*response = given().cookie("userId=admin; JSESSIONID=147229E915CE67249A9D1F05C9A18EDF").post("http://122.224.230.26:20087/member/pointOut/queryPointOutCount");
        String string = response.asString();
        JsonPath jsonPath = new JsonPath(response.asString());*/
        // JsonPath jsonPath = getJsonPath(response);
        /*List<Object> lists = jsonPath.getList("payload");
        System.out.println(lists);*/
        //System.out.println(jsonPath.getString("msg"));

    }
}
