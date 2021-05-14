package com.demoOrg.VehInsCalc.Engines;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.demoOrg.VehInsCalc.Utilities.CommonMethods;
import com.demoOrg.VehInsCalc.Utilities.PropertiesOperations;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestEngine extends CommonMethods{


	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;

	@BeforeMethod
	public void setupMethod() throws Exception {
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = PropertiesOperations.getPropertyValueByKey("url");
		String headlessModeExecution = PropertiesOperations.getPropertyValueByKey("headlessModeExecution");


		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			if(headlessModeExecution.equalsIgnoreCase("Y")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");   ////or use- options.setHeadless(true);

			//	driver = new ChromeDriver(options);
				DesiredCapabilities capability = DesiredCapabilities.chrome();
				capability.setBrowserName(BrowserType.CHROME);
				capability.setPlatform(Platform.WIN10);

				driver = new RemoteWebDriver(new URL("http://192.168.0.104:4444/wd/hub"), capability);
			} else {
				driver = new ChromeDriver();

			}

		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().arch64().forceDownload().setup();
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}




	@AfterMethod
	public void cleanup() {

		//driver.close();
		//close browsers
		//close report

	}
}
