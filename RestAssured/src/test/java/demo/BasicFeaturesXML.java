package demo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BasicFeaturesXML {

    /**
     * 测试响应内容是单个xml数据
     */
    /*@Test
    public void testSingleXMLContent() {
        given().
            get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
        then().
            body("CUSTOMER.ID", equalTo("10")).
            body("CUSTOMER.FIRSTNAME", equalTo("Sue")).
            body("CUSTOMER.LASTNAME", equalTo("Fuller")).
            body("CUSTOMER.STREET", equalTo("135 Upland Pl.")).
            body("CUSTOMER.CITY", equalTo("Dallas")).
            log().all();
    }*/

    /**
     * 多个测试点一行代码去校验
     */
    /*@Test
    public void testCompleteTextinOneLine() {
        given().
                get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
                then().
                body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas")).
                log().all();
    }*/

    /**
     * find value by xpath
     */
    /*@Test
    public void findValueByXpath() {
        given().
                get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
                then().
                body(hasXPath("/CUSTOMER/FIRSTNAME"), containsString("Sue"));
    }*/

    /**
     * find value by xpath, eg2
     */
    /*@Test
    public void findValueByXpath2() {
        given().
                get("http://www.thomas-bayer.com/sqlrest/INVOICE/").
                then().
                body(hasXPath("/INVOICEList/INVOICE[text()='20']")).
                log().all();
    }*/
}
