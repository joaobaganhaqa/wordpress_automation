package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.ConfigurationBase;

public class AdminPage extends ConfigurationBase {
	
	//Collecting Object Repository:
	
	@FindBy(xpath="//span[contains(@class,'display-name')][contains(text(),'c3po')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//div[@class='wp-menu-name'][contains(text(),'Posts')]")
	WebElement postsLink;
	
	@FindBy(xpath="//div[@class='wp-menu-name'][contains(text(),'Media')]")
	WebElement mediaLink;
	
	
	//Initializing the Object Repository
	
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyAdminPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername() {
		return userNameLabel.isDisplayed();
	}
	
	public PostsPage clickOnPostsLink() {
		postsLink.click();
		return new PostsPage();
	}
	
	public MediaPage clickOnMediaLink() {
		mediaLink.click();
		return new MediaPage();
	}
		
}



