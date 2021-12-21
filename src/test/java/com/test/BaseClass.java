package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class BaseClass {
	
	public static WebDriver driver;

	public String getData(int rowNo, int cellNo) throws IOException {
		String data = null;
		File file = new File("C:\\Users\\Nanda\\eclipse-workspace\\TestMaven\\src\\test\\java\\Excel\\BaseClass.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();
		if (cellType == 1) {
			data = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
			data = dateFormat.format(date);
		} else {
			double d = cell.getNumericCellValue();
			long l = (long) d;
			data = String.valueOf(l);
		}
		return data;
	}

	public static void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}

	public static void loadUrl(String Url) {
		driver.get(Url);
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public WebElement findElementById(String data) {
		WebElement element = driver.findElement(By.id(data));
		return element;
	}

	public WebElement findELementByXpath(String data) {
		WebElement element = driver.findElement(By.xpath(data));
		return element;
	}

	public void clickBtn(WebElement element) {
		element.click();
	}

	public void SltOptions(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}

	public void typData(WebElement element, String data) {
		element.sendKeys(data);
	}

	public void newCell(int index, String data) throws IOException {
		File file = new File("C:\\Users\\Nanda\\eclipse-workspace\\TestMaven\\src\\test\\java\\Excel\\BaseClass.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		Cell createCell = row.createCell(index);
		createCell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}
	public static void close() {
		driver.close();
	}
	public static void verification(String msg,String expected,String actual) {
	Assert.assertEquals(msg, expected, actual);
	}
}
