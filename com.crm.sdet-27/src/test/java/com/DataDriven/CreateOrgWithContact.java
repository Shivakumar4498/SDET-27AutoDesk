package com.DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

public class CreateOrgWithContact {
	
public static void main(String[] args) throws Throwable 
{
//Read Common data From properties file
	FileInputStream fin = new FileInputStream("./Data/commondata.properties");
	Properties prop = new Properties();
	prop.load(fin);
	
	String URL = prop.getProperty("url");
	String USERNAME = prop.getProperty("username");
	String PASSWORD = prop.getProperty("password");
	String BROWSER = prop.getProperty("browser");
	
//Get Randum No
	 Random ran = new Random();
	 	int randmnm = ran.nextInt(1000);
	
	 Random ran1 = new Random();
		int randmnm2 = ran1.nextInt(1000);
	
//Read data from XL
	FileInputStream finstream = new FileInputStream("./Data/org.xlsx");
	Workbook fac = WorkbookFactory.create(finstream);
	Sheet hee = fac.getSheet("Sheet1");
	Row rap = hee.getRow(2);
	String orName = rap.getCell(1).getStringCellValue()+randmnm; 
	Row rope = hee.getRow(2);
	String ropename = rope.getCell(2).getStringCellValue()+randmnm2;
	
	WebDriver driver = null;
	if(BROWSER.equals("chrome"))
	{
		driver = new ChromeDriver();
	}
	else if (BROWSER.endsWith("firefox")) 
	{
		driver = new FirefoxDriver();
	}
	else if (BROWSER.equals("ie")) 
	{
		driver = new InternetExplorerDriver();
	}
	//else 
	//{
		//driver = new ChromeDriver();
	//}
	
	
	//Step 1: Login to Vtiger
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);
			//Enter login details
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
	//Step 2: Click on organization Module
			driver.findElement(By.linkText("Organizations")).click();
	//Step 3: Click on create Organization 
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	//Step 4: Enter org Details
			driver.findElement(By.name("accountname")).sendKeys(orName);
			driver.findElement(By.name("button")).click();
	//Step 5:Get text after creation of org name
			String act = driver.findElement(By.className("dvHeaderText")).getText();
	//Verification
			if (act.contains(orName)) 
			{
				System.out.println("org is successfully created");
			}
			else 
			{
				System.out.println("org is not created");
			}
//Contact 	
	//step1 Navigate to Contact Module
			driver.findElement(By.linkText("Contacts")).click();
	//step 2 click on create contact
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	//step 3 enter contatct details
			driver.findElement(By.name("lastname")).sendKeys(ropename);
	//Step Select org name
			driver.findElement(By.xpath("//img[@alt='Select'][1]")).click();
	
		String parentwindow = driver.getWindowHandle();
		
		Set<String> child=driver.getWindowHandles();
				child.remove(parentwindow);
				for (String b : child)
				{
					driver.switchTo().window(b);
				}	
		driver.findElement(By.linkText(orName)).click();
		driver.switchTo().window(parentwindow);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
//Step 6 signout
			Actions ac = new Actions(driver);
			ac.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();

	
	
	
}
}
