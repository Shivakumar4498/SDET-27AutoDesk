package com.crm.Autodesk.Contacts.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.crm.autodesk.ObjectRepository.ConatactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class DoNotCallCheckBoxTest {

	public static void main(String[] args) throws Throwable {
// create object to libraries
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
	    FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		
WebDriver driver = null;
		
				
		String BROWSER = fLib.getPropertyKeyValue("browser");
	    String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
//get random Number from utility
		 int randomNum = jLib.getRandomNumber();
		
	
//Read data from XL from utility
		String condetail = eLib.getDataFromExcel("Sheet1", 4, 2) + randomNum;
	  
		
	
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
		driver.manage().window().maximize();
//Wait for Page to load from utility
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		
		LoginPage lo= new LoginPage(driver);
		lo.login(USERNAME, PASSWORD);
		
		//step 2 Navigate to Contact Module
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		
		//step 3 click on create contact
		ConatactsPage cp =new ConatactsPage(driver);
		cp.clickOnCreateConatact();
		
		//step 4 enter contatct details
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.clickOnCheckBoxBtn(condetail);

		//step 5 Enable Do Not Cal Checkbox
		CreateContactPage ccp1 = new CreateContactPage(driver);
		ccp1.clickOnCheckBoxBtn(null);
		
		Assert.assertTrue( ccp1.isSel);
		
		/*if( ( ccp.is) 
		{
			System.out.println("checkbox is Enabled ==>> TEST CASE PASS");
		}
		else 
		{
			System.out.println("checkbox is not Enabled ==>> TEST CASE FAIL");
		}
		
		driver.findElement(By.name("button")).click();
		
		//Step 6 lognout from application
		
		hp.logout(driver);
		//close Browser
		
		driver.quit();*/

	}

}
