package com.DataDriven;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
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

public class CreateNewOrganizationVtiger 
{

	public static void main(String[] args) throws Throwable 
	{
		//Read Common data from properties File
		FileInputStream fis = new FileInputStream("./Data/commondata.properties");
		Properties pop = new Properties();
		pop.load(fis);
		
		String URL = pop.getProperty("url");
		String USERNAME = pop.getProperty("username");
		String PASSWORD = pop.getProperty("password");
		String BROWSER = pop.getProperty("browser");
		
		//Get Randum No
		 Random ran = new Random();
		int randmnm = ran.nextInt(1000);
		
		//Read test data from XL file
		FileInputStream fi = new FileInputStream("./Data/org.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet1");
		Row ro = sh.getRow(1);
		String orgName = ro.getCell(1).getStringCellValue()+ randmnm;  
		
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
		//step 2 Navigate to Organization Module
		driver.findElement(By.linkText("Organizations")).click();
		//step 3 Click on create Organization 
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//step 4 Enter all the organization details
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("button")).click();
		//Step 5
		String act = driver.findElement(By.className("dvHeaderText")).getText();
		if (act.contains(orgName)) {
			System.out.println("org is successfully created");
		}else {
			System.out.println("org is not created");
		}
		//Step 6
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		

	}

}
