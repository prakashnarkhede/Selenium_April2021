package com.demoOrg.VehInsCalc.Engines;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionEngine  extends TestEngine{
	
	
	
	public void do_Click(WebElement element, String objectName) {
		
		try {
			element.click();
			test.pass("Click operation on object "+objectName+"   is SUCCESSFUL");
		} catch (Exception e) {
			test.info("Click operation on object "+objectName+"   is FAILED, due to an exception: "+e.getStackTrace());
		}
		
	}
	
	public void do_SendKeys(WebElement element, String valueToBeEntered, String objectName) {
		try {
			element.sendKeys(valueToBeEntered);
			test.pass("Data typing action is SUCCESSFUL onobject "+objectName+"  Value entered is : "+valueToBeEntered);
		} catch (Exception e) {
			test.error("Data typing action is FAILED onobject "+objectName+"  Value entered is : "+valueToBeEntered);
		}
	}
	
	
	public void selectDropDownValue(WebElement element, String valueToBeSelected) throws Exception {
		if(valueToBeSelected == null || valueToBeSelected == " ") {
			throw new Exception("Dropdwon value to be sleected can not be spaces or null.")	;
		}
		try {
		Select os = new Select(element);
		os.selectByVisibleText(valueToBeSelected);
		test.pass("Dropdown vallue selection is SUCCESSFUL, Selected value is: "+valueToBeSelected);
		} catch(Exception e) {
		test.error("Dropdown vallue selection is FAILED, Selected value is: "+valueToBeSelected + " Exception is: "+e);

		}

	}


	public void selectRadioButton(List<WebElement> radioButtonLabelElements, String radioButtonToBeSelected) throws Exception {

		boolean flag = false;

		for (WebElement we : radioButtonLabelElements) {
			String currentRadioText = we.getText();
			if(currentRadioText.equalsIgnoreCase(radioButtonToBeSelected)) {
				we.click();
				flag = true;
			}
		}

		if(!flag) {
		}

	}

	public void selectCheckboxes(List<WebElement> webelementCheckList, String checkBoxToClick) throws Exception {
		
		boolean flag;
		String[] checkBoxToClick_arr =  checkBoxToClick.split(";");  ///speeding;Other;farming

		for(int i = 0; i < checkBoxToClick_arr.length; i++) {
			flag = false;
			String  ToCheck = checkBoxToClick_arr[i]; //farming
			for(int j = 0; j < webelementCheckList.size(); j++) {
				String check = webelementCheckList.get(j).getText();
				if(check.equalsIgnoreCase(ToCheck)) {
					webelementCheckList.get(j).click();
					flag = true;
				}
				if(!flag && j == (webelementCheckList.size()-1)) {
					throw new Exception("checkbox  is not selected with value: "+ToCheck);
				}
			}
		}
		
	}
	
	

}
