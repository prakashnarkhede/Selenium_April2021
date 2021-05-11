package com.demoOrg.VehInsCalc.PageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoOrg.VehInsCalc.Engines.ActionEngine;

public class EnterVehicleDataPageObjects extends ActionEngine{
	WebDriver driver;

	public EnterVehicleDataPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	By make = By.id("make");
	By model = By.id("model");
	By cylindercapacity = By.id("cylindercapacity");
	By engineperformance = By.id("engineperformance");
	By dateofmanufacture = By.id("dateofmanufacture");
	By numberofseatsmotorcycle = By.id("numberofseatsmotorcycle");
	By listprice = By.id("listprice");
	By annualmileage = By.id("annualmileage");
	By nextButton = By.id("nextenterinsurantdata");

	
	public EnterInsurantDataPageObjects enterVehicleData(HashMap<String, String> data) throws Exception {
		selectDropDownValue(driver.findElement(make), data.get("Vehicle_Make"));
		selectDropDownValue(driver.findElement(model), data.get("Vehicle_Model"));
		do_SendKeys(driver.findElement(cylindercapacity), data.get("Vehicle_CylinderCapacity"), "Vehicle_CylinderCapacity");
		
		driver.findElement(engineperformance).sendKeys(data.get("Vehicle_Enging Performance"));
		driver.findElement(dateofmanufacture).sendKeys(data.get("Vehicle_Date of Manufacture"));
		selectDropDownValue(driver.findElement(numberofseatsmotorcycle), data.get("Vehicle_No of Seats_motorcycle"));
		driver.findElement(listprice).sendKeys(data.get("Vehicle_List Price"));
		driver.findElement(annualmileage).sendKeys(data.get("Vehicle_Annual Mileage"));
		do_Click(driver.findElement(nextButton), "Next Button On Enter VehicleDataPage");
		return new EnterInsurantDataPageObjects(driver);

	}

}
