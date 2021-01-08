package com.qa.listener;

import com.qa.util.LogUtil;
import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    // LogUtil logger = new LogUtil(this.getClass());
    private final Logger logger = Logger.getLogger(this.getClass());
    private int retryCount = 1;
    // 控制失败跑几次
    private int maxRetryCount = 5;

    public boolean retry (ITestResult result) {
        if (retryCount < maxRetryCount) {
            logger.info("running retry for  '" + result.getName() + "' on class " +
                    this.getClass().getName() + " Retrying " + retryCount + " times");
            retryCount++;
            return true;
        }
        return false;
    }

}
