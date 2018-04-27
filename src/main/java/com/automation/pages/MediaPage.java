package com.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.ConfigurationBase;

public class MediaPage extends ConfigurationBase {
	
	//Collecting Object Repository:
	
	@FindBy(xpath="//h1[@class='wp-heading-inline'][contains(text(),'Media Library')]")
	WebElement mediaPageTitle;
	
	@FindBy(xpath="//a[contains(@class, 'page-title-action')][contains(text(), 'Add New')]")
	WebElement addNewMedia;
	
	//Initializing the Page Objects:
	
	public MediaPage() {
		PageFactory.initElements(driver, this);
	}
		
	public boolean verifyMediaTitle() {
		return mediaPageTitle.isDisplayed();
	}
	
	
	public void clickOnAddNewMedia() throws IOException {
		
		addNewMedia.click();
			
	}
	
}
