package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {//step1 ==>> create separate POM class

	
	//step 2 ==>> Identify all the elements in page using @FindBy and Declare as private
	@FindBy(className = "//span[@class='dvHeaderText']")////td[@id='mouseArea_Organization Name']/a
	private WebElement organizationCNFmsg;
	
	@FindBy(id = "dtlview_Type")
	private WebElement typeCNFmsg;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryCNFmsg;
	
	
	//step3 ==>> Provide the Initialization through constructor
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	//step4 ==> Utilize the WebElement using getters
	public WebElement getOrganizationCNFmsg() {
		return organizationCNFmsg;
	}
	
	public WebElement getTypeCNFmsg() {
		return typeCNFmsg;
	}
	
	public WebElement getIndustryCNFmsg() {
		return industryCNFmsg;
	}



	//step5 ==>> Developing the Business Libraries
	public String fetchConfirmationMessage()
	{
		return(organizationCNFmsg.getText());
	}
	
	public String fetchTypeName()
	{
		return(typeCNFmsg.getText());
	}
	
	public String fetchIndustryName()
	{
		return(industryCNFmsg.getText());
	}

}
