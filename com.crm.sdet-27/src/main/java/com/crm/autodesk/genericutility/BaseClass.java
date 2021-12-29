package com.crm.autodesk.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;

public class BaseClass {
	
	public DataBaseUtility dLib = new DataBaseUtility();
	public JavaUtility jLib= new JavaUtility();
	public FileUtility fLib= new FileUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public WebDriverUtility wLib= new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups ="SmokeSuite")
	public void dbConnection()
	{
		dLib.connectToDB();
		System.out.println("DataBase Connected Successfully....");
	}
	@BeforeClass(groups ="SmokeSuite")
	public void launchBrowser() throws Throwable
	{
		//Read The Data
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		
		sdriver=driver;
		
		wLib.waitForPageToLoad(driver);
		wLib.maximizeWindow(driver);
		driver.get(URL);
		System.out.println("=========>Browser Launched===========>");
	}
	@BeforeMethod(groups ="SmokeSuite")
	public void loginToApp() throws Throwable
	{
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("===========>Login Successfull=========>");
	}
	@AfterMethod(groups ="SmokeSuite")
	public void logoutOfApp()
	{
		HomePage hp = new HomePage(driver);
		hp.logout(driver);
		System.out.println("===========>Logout Successfull=========>");
	}
	@AfterClass(groups ="SmokeSuite")
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("===========>Browser closed=========>");
	}
	@AfterSuite(groups ="SmokeSuite")
	public void closeDbConnection()
	{
		dLib.closeDB();
		System.out.println("===========>DataBase connection closed=========>");
	}
	}


