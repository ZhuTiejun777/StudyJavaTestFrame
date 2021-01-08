package com.qa.listener;

import com.qa.base.TestBase;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import org.apache.log4j.Logger;

import java.util.Iterator;


/**
 * testNG执行case 失败后 ，testNG Listener会捕获执行失败
 * 如果要实现失败自动截图，需要重写Listener的onTestFailure方法
 * 
 * 当用例失败自动重跑，为防止测试报告中的case数会增多，重写onFinish方法
 * 
 * @author Charlie.chen
 */
public class TestNGListener extends TestListenerAdapter {


	private final Logger logger = Logger.getLogger(TestNGListener.class);

	@Override
	public void onTestSuccess(ITestResult tr) {
		logger.info("Test Success");
		super.onTestSuccess(tr);
	}

	@Override
	public void onTestFailure(ITestResult tr) {
	
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		logger.error("Test Skipped");
		super.onTestSkipped(tr);
	}

	@Override
	public void onStart(ITestContext testContext) {
		logger.info("Test Start");
		super.onStart(testContext);
	}

	//当用例失败自动重跑，为防止测试报告中的case数会增多，重写onFinish方法
	@Override
	public void onFinish(ITestContext testContext) {
		logger.info("Test Finish");
		
        Iterator<ITestResult> listOfFailedTests = testContext.getFailedTests().getAllResults().iterator();
        while (listOfFailedTests.hasNext()) {
            ITestResult failedTest = listOfFailedTests.next();
            ITestNGMethod method = failedTest.getMethod();
            if (testContext.getFailedTests().getResults(method).size() > 1) {
                listOfFailedTests.remove();
            } else {
                if (testContext.getPassedTests().getResults(method).size() > 0) {
                    listOfFailedTests.remove();
                }
            }
        }
		
	}

}