package Listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestBase.BaseClass;
import Utility.GenericKeywords;

public class MyTestResult implements ITestListener{
	

	public void onTestSuccess(ITestResult result) {
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("tests");
		test.log(Status.PASS, "Success Test Case name is  "+result.getName());
		//test.log(Status.PASS, result.getMethod().getMethodName());
		//GenericKeyword.generateScreenshots(result.getMethod().getMethodName());

	}

	public void onTestFailure(ITestResult result) {
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("tests");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		GenericKeywords.generateScreenshots(result.getThrowable().getMessage());
//		throw new RuntimeException("Test failure occurred. Stopping the suite.");
	}

	public void onTestSkipped(ITestResult result) {
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("tests");
		test.log(Status.SKIP, result.getName());
		test.log(Status.SKIP, result.getMethod().getMethodName());
		//GenericKeyword.generateScreenshots();
	}

	public void onFinish(ITestResult result) {
		
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("tests");
		test.log(Status.INFO, result.getName());
		
	}

}
