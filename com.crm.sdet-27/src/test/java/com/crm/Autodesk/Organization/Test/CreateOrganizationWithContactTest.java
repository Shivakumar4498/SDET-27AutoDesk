package com.crm.Autodesk.Organization.Test;


import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ConatactsPage;
import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.CreateOrganizationsPage;
import com.crm.autodesk.ObjectRepository.HomePage;

import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.BaseClass;


public class CreateOrganizationWithContactTest extends BaseClass{
	@Test
	public void createOrganizationWithContactTest() throws Throwable {

		//get random Number from utility
		int randomNumber = jLib.getRandomNumber();

		//Fetch the data from Excel from Utility
		 String testdata_org = eLib.getDataFromExcel("Sheet1", 3, 1)+randomNumber;
		 String testdata_conctact = eLib.getDataFromExcel("Sheet1", 3, 2)+randomNumber;

		//Wait 		
		wLib.waitForPageToLoad(driver);
		//wLib.waitForElementToBeClickAble(driver, null);
		
		//Navigate to Organization Tab
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();

		//click on Create Organization
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Enter the details and click on save
		CreateOrganizationsPage cop = new CreateOrganizationsPage(driver);
		cop.createOrganization(testdata_org);
		
		//////////////////////////
		wLib.waitForElementToBeClickAble(driver, driver.findElement(By.className("dvHeaderText")));
		
		//Navigate to Organization Tab
		hp.clickOnContactsLink();
		

		//click on Create contact
		ConatactsPage cp = new ConatactsPage(driver);
		cp.clickOnCreateConatact();
		
		//Enter the details and click on save
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createContactWithOrgName(testdata_conctact, testdata_org, driver);
		
		Assert.assertTrue(testdata_org.contains(testdata_org));
		System.out.println(testdata_org+ "Expected Organization Name");

		ContactInfoPage cio= new ContactInfoPage(driver);
		String actual_Contact= cio.fetchConfirmationMessage();
		
		//Verify the Confirmation Message
		Assert.assertTrue(actual_Contact.contains(testdata_conctact));
		System.out.println(actual_Contact + "==> actual Organization Name");

		//System.out.println(actual_Contact+" is visible ==>> TEST CASE PASS");
		/*if(actual_Contact.contains(testdata_conctact))
		{
			System.out.println(actual_Contact+" is visible ==>> TEST CASE PASS");
		}
		else
		{
			System.out.println(actual_Contact+" is not visible ==>> TEST CASE FAIL");
		}*/
		
	wLib.waitForElementToBeClickAble(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		///wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='themes/softed/images/user.PNG']")));

	}
}


	