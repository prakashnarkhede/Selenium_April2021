package com.demoOrg.VehInsCalc.PageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoOrg.VehInsCalc.Engines.ActionEngine;
import com.demoOrg.VehInsCalc.Engines.TestEngine;

public class EnterInsurantDataPageObjects extends ActionEngine{

	WebDriver driver;

	public EnterInsurantDataPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	By firstname = By.id("firstname");	
	By lastname = By.id("lastname");
	By birthdate = By.id("birthdate");
	By gender	 = By.xpath("//input[@name='Gender']/parent::label");
	By country = By.id("country");
	By city = By.id("city");
	By zipcode = By.id("zipcode");
	By occupation = By.id("occupation");
	By hobbies = By.xpath("//label[text()='Hobbies']/parent::div/p/label");
	By nextenterproductdata = By.id("nextenterproductdata");



	public EnterProductDataPageObjects enterInsurantData(HashMap<String, String> data) throws Exception {

		driver.findElement(firstname).sendKeys(data.get("Insurant_FirstName"));
		driver.findElement(lastname).sendKeys("Narkhede");
		driver.findElement(birthdate).sendKeys("01/01/1989");
		selectRadioButton(driver.findElements(gender), "Male");
		selectDropDownValue(driver.findElement(country), "India");

		driver.findElement(zipcode).sendKeys("411061");
		driver.findElement(city).sendKeys("Pune");

		selectDropDownValue(driver.findElement(occupation), "Farmer");
		selectCheckboxes(driver.findElements(hobbies), "Speeding;Other");

		driver.findElement(nextenterproductdata).click();
		return new EnterProductDataPageObjects(driver);

	}

}
