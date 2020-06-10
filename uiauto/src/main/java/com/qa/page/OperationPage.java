package com.qa.page;

import com.qa.base.BasePage;
import org.openqa.selenium.WebElement;

public class OperationPage extends BasePage {

    String xpath_sousuo = "//*[@id='su']";
    String xpath_shuru = "//*[@class='kw']";


//    public void findelement () {
//        ele_sousuo = getelement(xpath_sousuo);
//        ele_shuru = getelement(xpath_shuru);
//    };

    private WebElement find_shuru () {
        return getelement(xpath_shuru);
    }

    private void handle_element (String text) {
        sendkeytext(find_shuru(), text);
    };

}
