package com.logicinvoice.generics;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class Utility implements IAutoConstant {
	public static Workbook wb;
	public static String getCellValue(String sheet, int row, int column){
		String cellValue = "";
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));//CTRL+1+ENTER
			cellValue = wb.getSheet(sheet).getRow(row).getCell(column).toString();
		} catch (Exception e) {
		} 
		return cellValue;
	}
public static int getRowCount(String sheet){
	int rowCount = 0;
	try {
		 wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));//CTRL+1+ENTER
		rowCount = wb.getSheet(sheet).getLastRowNum();
	} catch (Exception e) {
	} 
	return rowCount;
}
public static String getPropertyValue(String propertyName){
	String propertyValue ="";
	Properties prop = new Properties();
	try {
		prop.load(new FileInputStream(CONFIG_PATH));
		 propertyValue = prop.getProperty(propertyName);
	} catch (Exception e) {
	} 
	return propertyValue;
}
public static void mouseHover(WebDriver driver, WebElement element){
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();
}
public static void selectByVisibleText(WebElement element, String text){
	Select s = new Select(element);
	s.selectByVisibleText(text);
}
}
