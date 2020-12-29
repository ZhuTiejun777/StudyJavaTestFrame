package com.qa.util;

import io.restassured.response.Response;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestUtils {

    //断言状态码是不是200或者其他状态码,例如常见404等
    public void checkStatusCode (Response response, int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode, "状态码检查失败!");
    }

    //打印响应全部内容,debug中应该经常用到这个
    public void printAllResponseText(Response response) {
        System.out.println(response.then().log().all());
    }

    //只打印响应正文
    public void printResponseBody(Response response) {
        System.out.println(response.then().log().body());
    }

    public static Object[][] readxls(String file) throws IOException, BiffException {
        //Workbook book = Workbook.getWorkbook(new File(".\\data\\TestData.xls"));
        Workbook book = Workbook.getWorkbook(new File(file));
        Sheet sheet = book.getSheet("Sheet1");
        int rows = sheet.getRows();
        int cols = sheet.getColumns();
        Object[][] objects = new Object[rows - 1][cols];
        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                objects[row - 1][col] = sheet.getCell(col, row).getContents();
                System.out.println(sheet.getCell(col, row).getContents());
            }
        }
        book.close();
        return objects;
    }
}
