package com.crm.Autodesk.Contacts.Test;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ConatactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.CreateOrganizationsPage;
import com.crm.autodesk.ObjectRepository.HomePage;

import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.BaseClass;

public class CreateContactWithOrgDeleteOrgTest extends BaseClass{

	@Test
	public void createContactWithOrgDeleteOrgTest() throws Throwable {
	
		//get random Number
		 int randomNum = jLib.getRandomNumber();

		// Specify the Path in order to get the java representation object of the physical file
		String orgName = eLib.getDataFromExcel("Sheet1", 5, 1) + randomNum;
	    String conactName = eLib.getDataFromExcel("Sheet1", 5, 2) + randomNum;
		
	    //Wait fro page to load implicit
		wLib.waitForPageToLoad(driver);

		//Navigate to Organization Tab
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//click on Create Organization
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		//Enter the details and click on save
		CreateOrganizationsPage cop = new CreateOrganizationsPage(driver);
		cop.createOrganization(orgName);
		
		//Wait
		wLib.waitForElementToBeClickAble(driver, driver.findElement(By.className("dvHeaderText")));
		
		//Navigate to Conatct Tab
		hp.clickOnContactsLink();

		//click on Create contact
		ConatactsPage cp = new ConatactsPage(driver);
		cp.clickOnCreateConatact();

		//Enter the details and click on save
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.deleteOrganization(conactName, orgName, driver);
	}

}
