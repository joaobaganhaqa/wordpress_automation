package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.ConfigurationBase;

public class RemoveMediaPage extends ConfigurationBase{
	
	//Object Repository:
	
	@FindBy(xpath="//button[contains(@class, 'button-link delete-attachment') and contains(text(), 'Delete Permanently')]")
	WebElement deletePermanentlyButton;
	
		//Initializing the Page Objects:
		public RemoveMediaPage() {
			PageFactory.initElements(driver, this);
		}
		
	public void imageThumbnailSelected (String thumbnail) {
		driver.findElement(By.xpath("//li[@aria-label='"+thumbnail+"']//parent::div//preceding-sibling::div")).click();
	}
	
	public void clickOnDeletePermanently() {
		deletePermanentlyButton.click();
	}

}
