package com.qa.amazon.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.amazon.base.AmazonTestBase;

public class AmazonTestUtil extends AmazonTestBase {
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=10;
	
	public static String TESTDATA_SHEET_PATH="C:\\QA\\Selenium_workspace\\MyAmazonStoreProject\\src\\main\\java\\com\\qa\\amazon\\testdata\\DataSheetForSearchBox.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public void switchToFrame() {
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='a-box a-spacing-extra-large']")));
		
	}
	

	public static Object[][] getTestData(String sheetName){
		FileInputStream file=null;
		try {
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book =WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e) {
			e.printStackTrace();
			
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
		sheet=book.getSheet(sheetName);
		Object[][]data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++) {
	for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
		data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		
	}
	}
	return data;
	}
	public static void takesScreenshotAtEndOfTes() throws IOException
	{
		File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
