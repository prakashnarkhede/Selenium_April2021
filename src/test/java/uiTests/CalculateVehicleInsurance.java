package uiTests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.demoOrg.VehInsCalc.Engines.ActionEngine;
import com.demoOrg.VehInsCalc.PageObjects.EnterInsurantDataPageObjects;
import com.demoOrg.VehInsCalc.PageObjects.EnterProductDataPageObjects;
import com.demoOrg.VehInsCalc.PageObjects.EnterVehicleDataPageObjects;
import com.demoOrg.VehInsCalc.PageObjects.HomePageObjects;
import com.demoOrg.VehInsCalc.PageObjects.SelectPriceOptionsPageObjects;
import com.demoOrg.VehInsCalc.PageObjects.SendQuotePageObjects;
import com.demoOrg.VehInsCalc.Utilities.ExcelOperations;


public class CalculateVehicleInsurance extends ActionEngine{
	
	ExcelOperations excel = new ExcelOperations("InsurancePremium");
	
	@Test (dataProvider = "insCalTesData")
	public void VehicalInsuranceTest_dataDriven(Object obj1) throws Exception {
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		
		test.log(Status.INFO, "Test Data used for this execution run: "+testData);
		
		HomePageObjects homePage = new HomePageObjects(driver);
		
		EnterVehicleDataPageObjects vehData  = homePage.selectNavigationMenu("Motorcycle");
		EnterInsurantDataPageObjects insData = vehData.enterVehicleData(testData);
		EnterProductDataPageObjects prodData = 	insData.enterInsurantData(testData);
		SelectPriceOptionsPageObjects opt = prodData.enterProductData(testData);
		
		Assert.assertEquals(opt.getPriceOptionValue("Silver"), testData.get("PriceValidation_Silver"));
		Assert.assertEquals(opt.getPriceOptionValue("Gold"), testData.get("PriceValidation_Gold"));
		Assert.assertEquals(opt.getPriceOptionValue("Platinum"), testData.get("PriceValidation_Platinum"));
		
		opt.selectOption(testData.get("SelectOption"));
		SendQuotePageObjects sendQuote= 	opt.navaigateToSendQuote();
		sendQuote.enterInfoForSendingQuote();
		sendQuote.verifySuccessMessage("Sending e-mail success!");
	}
	
	
	@DataProvider(name = "insCalTesData")
	public Object[][] testDataSupplied() throws EncryptedDocumentException, IOException {
	//	Object[][] obj = new Object[excel.getRowCount()][1];
		Object[][] obj = new Object[1][1];

		Map<String, String> testData;
	//	for(int i = 1; i <=excel.getRowCount(); i++) {	
			for(int i = 1; i <=1; i++) {		

			testData = excel.getTestDataInHashmap(i);
			obj[i-1][0] = testData;
		}
		return obj;
		
	}


}
