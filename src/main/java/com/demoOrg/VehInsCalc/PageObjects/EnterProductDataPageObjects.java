package com.demoOrg.VehInsCalc.PageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoOrg.VehInsCalc.Engines.ActionEngine;
import com.demoOrg.VehInsCalc.Engines.TestEngine;

public class EnterProductDataPageObjects extends ActionEngine{
	WebDriver driver;

	public EnterProductDataPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	By startdate = By.id("startdate");
	By insurancesum = By.id("insurancesum");
	By damageinsurance = By.id("damageinsurance");
	By OptionalProducts = By.xpath("//label[text()='Optional Products']/parent::div/p/label");

	By nextselectpriceoption = By.id("nextselectpriceoption");

	
	public SelectPriceOptionsPageObjects enterProductData(HashMap<String, String> data) throws Exception {
		driver.findElement(startdate).sendKeys(data.get("Product_startdate"));
		selectDropDownValue(driver.findElement(insurancesum), "3.000.000,00");
		selectDropDownValue(driver.findElement(damageinsurance), "No Coverage");
		selectCheckboxes(driver.findElements(OptionalProducts), "Euro Protection;Legal Defense Insurance");
		driver.findElement(nextselectpriceoption).click();
		return new SelectPriceOptionsPageObjects(driver);
	}

}
