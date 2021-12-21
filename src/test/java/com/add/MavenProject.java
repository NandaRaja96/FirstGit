package com.add;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

public class MavenProject {
	public static void main(String[] args) throws IOException {

		File f = new File("C:\\Users\\Nanda\\eclipse-workspace\\TestMaven\\src\\test\\java\\Excel\\ImportExcel.xlsx");
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Import");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement dDnSkills = driver.findElement(By.id("skills"));

		Select select = new Select(dDnSkills);
		List<WebElement> options = select.getOptions();

		for (int i = 0; i < options.size(); i++) {
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(options.get(i).getText());

		}
		FileOutputStream out = new FileOutputStream(f);
		workbook.write(out);
	
	}
}
