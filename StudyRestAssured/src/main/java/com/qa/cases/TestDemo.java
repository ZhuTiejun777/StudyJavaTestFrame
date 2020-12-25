package com.qa.cases;

import com.qa.base.TestBase;
import com.qa.tests.AccountBill;
import com.qa.tests.UserResponse;
import com.qa.tests.querySubaccountBalance;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestDemo extends TestBase {

    @Test
    public void test01 () {
        logger.info("test config class");
    }

    @Test
    public void test02 () {
        System.out.println(baseURI);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("custAcctId", "3294000000102488");
        hashMap.put("selectFlag", "2");
        hashMap.put("pageNum", 1);
        given().
            //contentType("application/json").
            contentType(ContentType.JSON).
            body(hashMap).
        when().
            post("/bankApi/querySubaccountBalance").
        then().
            log().all();
    }

    @Test
    public void test03() {
        AccountBill accountBill = new AccountBill();
        accountBill.setCustAcctId("3294000000102488");
        accountBill.setSelectFlag("2");
        accountBill.setPageNum(1);

        response = postResponByPath("/bankApi/querySubaccountBalance", accountBill);
        JsonPath jsonPath = getJsonPath(response);
        // 反序列化
        UserResponse userResponse = response.as(UserResponse.class);
        Assert.assertEquals(userResponse.getMsg(), "成功");
        System.out.println(userResponse.getMsg());
        System.out.println(userResponse.getPayload().get("RspMsg"));

        System.out.println(jsonPath.getString("payload.RspMsg"));
        System.out.println(response.jsonPath().getMap("payload"));

        testUtils.checkStatusCode(response, 200);
        testUtils.printResponseBody(response);
    }

    @Test
    public void test04 () {
        AccountBill accountBill = new AccountBill();
        accountBill.setCustAcctId("3294000000102488");

        response = postResponByPath("/bankApi/queryCustSubaccountBalance", accountBill);

        response.then().spec(responseSpecification).log().all();

        JsonPath jsonPath = getJsonPath(response);
        System.out.println(jsonPath.getMap("payload"));
    }

    @Test
    public void test05 () {
        // Assert.assertEquals("true", "false");

    }
}
