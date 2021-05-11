package com.demoOrg.VehInsCalc.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.demoOrg.VehInsCalc.Engines.ActionEngine;

public class SendQuotePageObjects extends ActionEngine{
	WebDriver driver;

	public SendQuotePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.id("email");
	By phone = By.id("phone");
	By username = By.id("username");
	By password = By.id("password");
	By confirmpassword = By.id("confirmpassword");
	By sendemail = By.id("sendemail");

	By successMessage = By.xpath("//div[contains(@class, 'sweet-alert')]//h2");

	
	public void enterInfoForSendingQuote() throws Exception {
		driver.findElement(email).sendKeys("demo@ddemo.com");
		driver.findElement(phone).sendKeys("9999999999");
		driver.findElement(username).sendKeys("Admin9909");
		driver.findElement(password).sendKeys("Admin@1234");
		driver.findElement(confirmpassword).sendKeys("Admin@1234");
		driver.findElement(sendemail).click();

	}
	
	
	public void verifySuccessMessage(String expectedMessage) {
		String actualText = driver.findElement(successMessage).getText();
		Assert.assertEquals(actualText, expectedMessage, "Email sending message verification failure");
	}

}
