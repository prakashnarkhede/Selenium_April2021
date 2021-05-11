package com.demoOrg.VehInsCalc.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoOrg.VehInsCalc.Engines.ActionEngine;
import com.demoOrg.VehInsCalc.Engines.TestEngine;

public class HomePageObjects extends ActionEngine {
	WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	//all locators
	public static final By nav_motorcycleLocator = By.id("nav_motorcycle");
	public static final By nav_automobileLocator = By.name("Navigation Automobile");
	public static final By nav_truckLocator = By.xpath("//*[@id=\"nav_truck\"]");
	public static final By nav_camperLocator = By.id("nav_camper");
	
	
	public EnterVehicleDataPageObjects selectNavigationMenu(String menu) {
		
		switch (menu) {
		case "Automobile":
			driver.findElement(nav_automobileLocator).click();
			break;
		case "Truck":
			driver.findElement(nav_truckLocator).click();
			break;
		case "Motorcycle":
			do_Click(driver.findElement(nav_motorcycleLocator), "MotorCycle Link");
		//	driver.findElement(nav_motorcycleLocator).click();
			return new EnterVehicleDataPageObjects(driver);
		case "Camper":
			driver.findElement(nav_camperLocator).click();
			break;
		default:
			break;
		}
		return null;
		
	}
}
