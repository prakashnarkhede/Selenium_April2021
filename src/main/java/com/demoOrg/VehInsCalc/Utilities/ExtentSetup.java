package com.demoOrg.VehInsCalc.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentSetup {


	public static ExtentReports setupExentReport() {

		String reportPath = System.getProperty("user.dir")+  "/Reports/executionResult.html";
		ExtentSparkReporter spartReport = new ExtentSparkReporter(reportPath);

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spartReport);
		
		spartReport.config().setReportName("Veh Ins Calculation Test Execution");
		spartReport.config().setTheme(Theme.DARK);
		spartReport.config().setDocumentTitle("Doc Title - Veh ins app Test automtion");

		return extent;


	}



}
