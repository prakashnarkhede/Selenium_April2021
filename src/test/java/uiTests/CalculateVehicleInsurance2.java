package uiTests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoOrg.VehInsCalc.Engines.ActionEngine;
import com.demoOrg.VehInsCalc.PageObjects.EnterInsurantDataPageObjects;
import com.demoOrg.VehInsCalc.PageObjects.EnterProductDataPageObjects;
import com.demoOrg.VehInsCalc.PageObjects.EnterVehicleDataPageObjects;
import com.demoOrg.VehInsCalc.PageObjects.HomePageObjects;
import com.demoOrg.VehInsCalc.PageObjects.SelectPriceOptionsPageObjects;
import com.demoOrg.VehInsCalc.PageObjects.SendQuotePageObjects;
import com.demoOrg.VehInsCalc.Utilities.ExcelOperations;


public class CalculateVehicleInsurance2 extends ActionEngine{
	
	ExcelOperations excel = new ExcelOperations("InsurancePremium");
	
	//test data from row1
	@Test 
	public void VehicalInsuranceTest_dataDriven1() throws Exception {
		HashMap<String, String> testData = excel.getTestDataInHashmap(1);
		
		System.out.println(testData);
		HomePageObjects homePage = new HomePageObjects(driver);
		EnterVehicleDataPageObjects vehData = new EnterVehicleDataPageObjects(driver);  //remove these by doing object chaning
		EnterInsurantDataPageObjects insData = new EnterInsurantDataPageObjects(driver);
		EnterProductDataPageObjects prodData = new EnterProductDataPageObjects(driver);
		SelectPriceOptionsPageObjects opt = new SelectPriceOptionsPageObjects(driver);
		SendQuotePageObjects sendQuote = new SendQuotePageObjects(driver);
		
		homePage.selectNavigationMenu("Motorcycle");
		vehData.enterVehicleData(testData);
		insData.enterInsurantData(testData);
		prodData.enterProductData(testData);
		
		Assert.assertEquals(opt.getPriceOptionValue("Silver"), testData.get("PriceValidation_Silver"));
		Assert.assertEquals(opt.getPriceOptionValue("Gold"), testData.get("PriceValidation_Gold"));
		Assert.assertEquals(opt.getPriceOptionValue("Platinum"), testData.get("PriceValidation_Platinum"));
		
		opt.selectOption(testData.get("SelectOption"));
		opt.navaigateToSendQuote();
		sendQuote.enterInfoForSendingQuote();
		sendQuote.verifySuccessMessage("Sending e-mail success!");
	}

	//testData from row2
	@Test 
	public void VehicalInsuranceTest_dataDriven2() throws Exception {
		HashMap<String, String> testData = excel.getTestDataInHashmap(2);
		
		System.out.println(testData);
		HomePageObjects homePage = new HomePageObjects(driver);
		EnterVehicleDataPageObjects vehData = new EnterVehicleDataPageObjects(driver);  //remove these by doing object chaning
		EnterInsurantDataPageObjects insData = new EnterInsurantDataPageObjects(driver);
		EnterProductDataPageObjects prodData = new EnterProductDataPageObjects(driver);
		SelectPriceOptionsPageObjects opt = new SelectPriceOptionsPageObjects(driver);
		SendQuotePageObjects sendQuote = new SendQuotePageObjects(driver);
		
		homePage.selectNavigationMenu("Motorcycle");
		vehData.enterVehicleData(testData);
		insData.enterInsurantData(testData);
		prodData.enterProductData(testData);
		
		Assert.assertEquals(opt.getPriceOptionValue("Silver"), testData.get("PriceValidation_Silver"));
		Assert.assertEquals(opt.getPriceOptionValue("Gold"), testData.get("PriceValidation_Gold"));
		Assert.assertEquals(opt.getPriceOptionValue("Platinum"), testData.get("PriceValidation_Platinum"));
		
		opt.selectOption(testData.get("SelectOption"));
		opt.navaigateToSendQuote();
		sendQuote.enterInfoForSendingQuote();
		sendQuote.verifySuccessMessage("Sending e-mail success!");
	}
	
	//testData from row3
	@Test 
	public void VehicalInsuranceTest_dataDriven3() throws Exception {
		HashMap<String, String> testData = excel.getTestDataInHashmap(3);
		
		System.out.println(testData);
		HomePageObjects homePage = new HomePageObjects(driver);
		EnterVehicleDataPageObjects vehData = new EnterVehicleDataPageObjects(driver);  //remove these by doing object chaning
		EnterInsurantDataPageObjects insData = new EnterInsurantDataPageObjects(driver);
		EnterProductDataPageObjects prodData = new EnterProductDataPageObjects(driver);
		SelectPriceOptionsPageObjects opt = new SelectPriceOptionsPageObjects(driver);
		SendQuotePageObjects sendQuote = new SendQuotePageObjects(driver);
		
		homePage.selectNavigationMenu("Motorcycle");
		vehData.enterVehicleData(testData);
		insData.enterInsurantData(testData);
		prodData.enterProductData(testData);
		
		Assert.assertEquals(opt.getPriceOptionValue("Silver"), testData.get("PriceValidation_Silver"));
		Assert.assertEquals(opt.getPriceOptionValue("Gold"), testData.get("PriceValidation_Gold"));
		Assert.assertEquals(opt.getPriceOptionValue("Platinum"), testData.get("PriceValidation_Platinum"));
		
		opt.selectOption(testData.get("SelectOption"));
		opt.navaigateToSendQuote();
		sendQuote.enterInfoForSendingQuote();
		sendQuote.verifySuccessMessage("Sending e-mail success!");
	}

}
