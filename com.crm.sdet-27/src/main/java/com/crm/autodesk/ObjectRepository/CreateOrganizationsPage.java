package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateOrganizationsPage extends WebDriverUtility {// Step 1 Create a Seaparate class for Create org Page
	//Step 2 Declaration
		@FindBy(name = "accountname")
		private WebElement organizationNameEdit;
		
		@FindBy(name = "industry")
		private WebElement industryDropDown;
		
		@FindBy(name = "accounttype")
		private WebElement typeDropDown;
		
		@FindBy(name = "button")
		private WebElement saveBtn;
		
		@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
		private WebElement cancelBtn;
		
		//Step 3 Initialisation the elements using Constructor
		public CreateOrganizationsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//Step 4
		public WebElement getOrganizationNameEdit() 
		{
			return organizationNameEdit;
		}

		public WebElement getIndustryDropDown()
		{
			return industryDropDown;
		}

		public WebElement getTypeDropDown()
		{
			return typeDropDown;
		}

		public WebElement getSaveBtn() 
		{
			return saveBtn;
		}
		
		public WebElement getCancelBtn()
		{
			return cancelBtn;
		}
		//Bussiness Library
		public void createOrganization(String orgName)
		{
			organizationNameEdit.sendKeys(orgName);
			saveBtn.click();
		}
		//Bussiness Library for create Org with Industry drop down
		public void createOrgWithIndustryAndType(String orgName, String industry, String type)
		{
			organizationNameEdit.sendKeys(orgName);
			select(industryDropDown, industry );
			select(typeDropDown, type);	
			saveBtn.click();
		}
		
	}



