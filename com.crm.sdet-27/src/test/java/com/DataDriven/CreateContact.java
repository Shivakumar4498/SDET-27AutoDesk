package com.DataDriven;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;


public class CreateContact {

	public static void main(String[] args) throws Throwable {
		//Read Common data from properties File
		FileInputStream fis = new FileInputStream("./Data/commondata.properties");
		Properties pop = new Properties();
		pop.load(fis);
		
		String URL = pop.getProperty("url");
		String USERNAME = pop.getProperty("username");
		String PASSWORD = pop.getProperty("password");
		String BROWSER = pop.getProperty("browser");
		
		//Read data from XL
		FileInputStream fist = new FileInputStream("./Data/org.xlsx");
		Workbook wbs = WorkbookFactory.create(fist);
		Sheet shee = wbs.getSheet("Sheet1");
		Row rob = shee.getRow(1);
		String condetail = rob.getCell(2).getStringCellValue();
		
		WebDriver driver;
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if (BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}else {
			driver = new ChromeDriver();
		}
		//Step 1: Login
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//step 2 Navigate to Contact Module
		driver.findElement(By.linkText("Contacts")).click();
		//step 3 click on create contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//step 4 enter contatct details
		driver.findElement(By.name("lastname")).sendKeys(condetail);
		driver.findElement(By.name("button")).click();
			//Step 5
		String tex = driver.findElement(By.className("dvHeaderText")).getText();
		if (tex.contains(condetail)){
			System.out.println("Conatact detail added succesfully = pass");
		}
		else 
		{
			System.out.println("Conatact detail not added = fail");
		}
		//Step 6
				Actions ac = new Actions(driver);
				ac.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				driver.quit();

	}

}
