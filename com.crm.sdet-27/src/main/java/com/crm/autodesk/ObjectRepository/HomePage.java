package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {//Step 1 Create a separate class for Home Page
	
	//Step 2 Declaration
	@FindBy(linkText="Organizations")
	private WebElement oganizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	//Step 3 Initialisation the elements using Constructor
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	//Step 4 Utilisation using getters Method
	public WebElement getRganizationsLnk() {
		return oganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getAdministratorImg() 
	{
		return administratorImg;
	}
	public WebElement getSignoutBtn() {
		return signOutLnk;
	}
	
	//Business Library to click on Organizations
	public void clickOnOrganizationLink() 
	{
		oganizationsLnk.click();
	}
	//Business Library to click on Contacts
	public void clickOnContactsLink() 
	{
		contactsLnk.click();
	}
	//Business Library for Logout
	public void logout(WebDriver driver)
	{
		mouseOverOnElemnet(driver, administratorImg);
		signOutLnk.click();
	}

}
