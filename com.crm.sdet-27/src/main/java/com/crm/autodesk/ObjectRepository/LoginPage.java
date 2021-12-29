package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Step 1 Create a separate class for Login Page
	
	//Step 2 Declaration
	@FindBy(name = "user_name")
	private WebElement usernameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Step3 Initialisation  the elements using constructor
	public LoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Step 4 Utilisation using getters method
	public WebElement getUsernameEdt() 
	{
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}

	//Business Library
	public void login(String username, String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
}
