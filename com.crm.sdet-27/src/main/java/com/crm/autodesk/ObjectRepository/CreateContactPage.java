package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
	//step 2 ==>> Identify all the elements in page using @FindBy and Declare as private
		@FindBy(name = "lastname")
		private WebElement lastnameEdt;
		
		@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
		private WebElement orgNameLookUpImg;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement contactSaveBtn;
		
		@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
		private WebElement contactCancelBtn;
		
		@FindBy(id = "search_txt")
		private WebElement orgSearchdEdt;
		
		@FindBy(name = "search")
		private WebElement searchBtn;
		
		@FindBy(xpath = "//tr[@class='lvtColData']//a[1]")
		private WebElement orgNameLink;
		
		@FindBy(xpath = "//input[@name='account_id']/following-sibling::input")
		private WebElement deleteOrganizationImg;
		
		@FindBy(name = "donotcall")
		private WebElement checkBoxBtn;
		
		//step3 ==>> Provide the Initialization through constructor
		public CreateContactPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}


		//step4 ==> Utilize the WebElement using getters

		public WebElement getLastnameEdt() {
			return lastnameEdt;
		}


		public WebElement getOrgNameLookUpImg() {
			return orgNameLookUpImg;
		}


		public WebElement getContactSaveBtn() {
			return contactSaveBtn;
		}
		
		public WebElement getContactCancelBtn() {
			return contactCancelBtn;
		}
		
		public WebElement getOrgSearchdEdt() {
			return orgSearchdEdt;
		}


		public WebElement getSearchBtn() {
			return searchBtn;
		}


		public WebElement getOrgNameLink() {
			return orgNameLink;
		}
		
		public WebElement getCheckBoxBtn() {
			return checkBoxBtn;
		}


		public WebElement getDeleteImg() 
		{
			return deleteOrganizationImg;
		}


//step5 ==>> Developing the Business Libraries
		public void createContact(String lastname) {
			lastnameEdt.sendKeys(lastname);
			contactSaveBtn.click();
		}
		
		
		public void clickCancelContact(String lastname) {
			lastnameEdt.sendKeys(lastname);
			contactCancelBtn.click();
		}
		
		public void clickOnCheckBoxBtn(String lastname) 
		{
			lastnameEdt.sendKeys(lastname);
			checkBoxBtn.click();
			contactSaveBtn.click();
			
		}
		
		public void createContactWithOrgName(String lastname,String orgName, WebDriver driver) 
		{
			lastnameEdt.sendKeys(lastname);
			orgNameLookUpImg.click();
			switchToWindow(driver, "Accounts");
			orgSearchdEdt.sendKeys(orgName);
			searchBtn.click();
			driver.findElement(By.linkText(orgName)).click();
			switchToWindow(driver, "Contacts");
			contactSaveBtn.click();
		}
		
		public void deleteOrganization(String lastname,String orgName, WebDriver driver) 
		{
			lastnameEdt.sendKeys(lastname);
			orgNameLookUpImg.click();
			switchToWindow(driver, "Accounts");
			orgSearchdEdt.sendKeys(orgName);
			searchBtn.click();
			driver.findElement(By.linkText(orgName)).click();
			switchToWindow(driver, "Contacts");
			deleteOrganizationImg.click();
			contactSaveBtn.click();
		}


	}
	

