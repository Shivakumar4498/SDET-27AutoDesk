package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class ConatactsPage extends WebDriverUtility {// Step 1 Create a Seaparate class for Conatact Page
	
	//Step 2 Declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name = "submit")
	private WebElement searchNowBtn;
	
	//Step 3 Initialisation the elements using Constructor
	public ConatactsPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Step4

	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	//Bussiness Library
	public void clickOnCreateConatact()
	{
		createContactLookUpImg.click();
	}
	/*public String searchText()
	{
		searchTextEdt.getText();
	}*/
	public void searchNow() 
	{
		searchNowBtn.click();
	}
	
}