package com.girish.dealsdray.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
	public String readStringExcelvalue(WebDriver driver,String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Cities.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String cellDataValue = workbook.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		workbook.close();
		return cellDataValue;
	}
	
	public double readNumericExcelValue(WebDriver driver,int rownum,String sheetname,int cellnum) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Cities.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		double cellDataValue = workbook.getSheet(sheetname).getRow(rownum).getCell(cellnum).getNumericCellValue();
		workbook.close();
		return cellDataValue;
	}

}
