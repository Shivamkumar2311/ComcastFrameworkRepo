package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;                          //Rule 3 :Object initialization
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	@FindBy(linkText="Organizations")
		private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;

	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

	
	
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
	
	public void navigateToCampaign() {
		Actions action=new Actions(driver);
		action.moveToElement(moreLink).perform();
		campaignsLink.click();
	}
	public void logout() {
	Actions act=new Actions(driver);
	act.moveToElement(adminImg).perform();
	signOutLink.click();
	}

}
