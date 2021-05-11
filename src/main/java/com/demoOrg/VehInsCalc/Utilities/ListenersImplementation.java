package com.demoOrg.VehInsCalc.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.Status;
import com.demoOrg.VehInsCalc.Engines.TestEngine;

public class ListenersImplementation extends TestEngine implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		//create separate entry for each test case
		 test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test case: "+ result.getMethod().getMethodName()+" is passed");
		}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case: "+ result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());

		//screenshot attach
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String currentTimeStamp = format.format(date);
		
		String screenshotPath = System.getProperty("user.dir")+"/Reports/Screenshots/"+currentTimeStamp+".png";
		File screenshotSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File screenshotLocal = new File(screenshotPath);
		try {
			FileUtils.copyFile(screenshotSrc, screenshotLocal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		 extent = ExtentSetup.setupExentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
