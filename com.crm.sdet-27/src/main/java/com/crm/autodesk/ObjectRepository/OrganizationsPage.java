package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage { // Step 1 Create a saperate class for Org Page
	
	//Step 2 Declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name = "submit")
	private WebElement searchNowBtn;
	
	//Step 3 Initialisation the elements using Constructor
	public OrganizationsPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//Step 4 
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	//Bussiness library
	public void clickOnCreateOrgLookUpImg()
	{
		createOrgLookUpImg.click();
	}
	/*/public String searchText()
	{
		searchTextEdt.getText();
	}*/
	public void searchNow() 
	{
		searchNowBtn.click();
	}

}
