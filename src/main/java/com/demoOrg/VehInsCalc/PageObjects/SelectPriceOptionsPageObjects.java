package com.demoOrg.VehInsCalc.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoOrg.VehInsCalc.Engines.ActionEngine;
import com.demoOrg.VehInsCalc.Engines.TestEngine;

public class SelectPriceOptionsPageObjects extends ActionEngine{
	WebDriver driver;

	public SelectPriceOptionsPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By nextsendquote = By.id("nextsendquote");

	
	public String getPriceOptionValue(String priceOption) throws Exception {
		String price = null;
		String xpath = "//table[@id='priceTable']/tbody//tr/td[text()='Price per Year ($)']/following-sibling::td[@data-label='"+priceOption+"']/span";
		price = 	driver.findElement(By.xpath(xpath)).getText();
		return price;
	}
	
	public void selectOption(String option) {
		String xpath = "//input[@name='Select Option' and @value = '"+option+"']/parent::label";
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public SendQuotePageObjects navaigateToSendQuote() {
		driver.findElement(nextsendquote).click();
		return new SendQuotePageObjects(driver);
	}

}
