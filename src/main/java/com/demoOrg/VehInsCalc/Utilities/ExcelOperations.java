package com.demoOrg.VehInsCalc.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {

	Workbook wb;
	Sheet sh;

	public ExcelOperations(String sheetName) {
		String filePath = System.getProperty("user.dir")+"/src/test/resources/TestData/VehicleInsuranceCalcualator_TestData.xlsx";
		File testDataFile = new File(filePath);

		try {
			wb = WorkbookFactory.create(testDataFile);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sh = wb.getSheet(sheetName);

	}


	public HashMap<String, String> getTestDataInHashmap(int rowNum) throws EncryptedDocumentException, IOException {
		HashMap<String, String> testData = new HashMap<String, String>();

		for(int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			String key = sh.getRow(0).getCell(i).toString();
			String value = sh.getRow(rowNum).getCell(i).toString();
			testData.put(key, value);

		}

		return testData;

	}
	
	
	public int getRowCount() {
		return sh.getLastRowNum();
	}

}
