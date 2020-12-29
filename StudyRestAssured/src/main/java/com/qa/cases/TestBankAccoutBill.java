package com.qa.cases;

import com.alibaba.fastjson.JSONPath;
import com.qa.base.TestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
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
        hashMap.put("Cookie", "userId=admin; JSESSIONID=F5B9AE431210FF73BB8F76FB8E68EB9C");
        hashMap.put("Content-Type", "application/json;charset=UTF-8");
        //hashMap.put("Accept", "application/json, text/javascript, */*; q=0.01");
        HashMap<String, Object> boby = new HashMap<>();
        // given().headers(hashMap).body(boby).post("http://122.224.230.26:20087/member/pointOut/queryPointOutCount").then().contentType(ContentType.JSON).statusCode(200).log().all();
        Response response = given().headers(hashMap).body(boby).post("http://122.224.230.26:20087/member/pointOut/queryPointOutCount");
        JsonPath jsonPath = new JsonPath(response.asString());
        List<Map<String, Object>> arrayList = new ArrayList<>();
        arrayList = jsonPath.getList("payload");
        System.out.println(jsonPath.getList("payload"));
        for (Map<String, Object> map : arrayList) {
            System.out.println(map.get("statusName"));
        }
        // 通过JSONPath匹配
        System.out.println(JSONPath.read(response.asString(), "$.payload.statusName[0:-1]"));
        Assert.assertEquals("办卡申请:在线平台", JSONPath.read(response.asString(), "$.payload.statusName[0]"));
        /*JsonPath jsonPath = new JsonPath(response.asString());
        System.out.println(jsonPath.getMap(""));*/
        //given().headers(hashMap).cookie("userId=admin; JSESSIONID=14C1A9E94772CE09BDD6634B3316EA74").when().post("http://122.224.230.26:20087/member/pointOut/queryPointOutCount").then().contentType(ContentType.JSON).body("mag", is("成功")).log().all();
        /*response = given().cookie("userId=admin; JSESSIONID=147229E915CE67249A9D1F05C9A18EDF").post("http://122.224.230.26:20087/member/pointOut/queryPointOutCount");
        String string = response.asString();
        JsonPath jsonPath = new JsonPath(response.asString());*/
        // JsonPath jsonPath = getJsonPath(response);
        /*List<Object> lists = jsonPath.getList("payload");
        System.out.println(lists);*/
        //System.out.println(jsonPath.getString("msg"));

    }

    @Test
    public void test03 () {

    }


}
