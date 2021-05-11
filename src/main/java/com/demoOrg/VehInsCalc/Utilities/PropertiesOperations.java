package com.demoOrg.VehInsCalc.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesOperations {
	
	static String filePath = System.getProperty("user.dir")+ "/src/main/resources/config.properties";
	static FileInputStream fis = null;


	
	public static String getPropertyValueByKey(String key) throws Exception {
		File propFile = new File(filePath);
		
		try {
			fis = new  FileInputStream(propFile);
		} catch (FileNotFoundException e) {
			throw new Exception("Properties file not found at location: "+filePath);
		}
		
	Properties prop = new Properties();
	
	prop.load(fis);
	
	String propValue = prop.getProperty(key);
	
	if(propValue == null) {
		throw new Exception("No value found for key: "+key + " in properties file at location: "+filePath);
	}
	fis.close();
	
	return propValue;
	}

}
