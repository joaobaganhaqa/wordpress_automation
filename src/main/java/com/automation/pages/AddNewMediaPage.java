package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.ConfigurationBase;

public class AddNewMediaPage extends ConfigurationBase {
	
	//Object Repository:
	
	@FindBy(xpath="//button[@type='button'][contains(text(),'Select Files')]")
	WebElement selectFilesButton;
	
	//Initializing the Page Objects:
	
		public AddNewMediaPage() {
			PageFactory.initElements(driver, this);
		}
		
		public void selectFiles() {

			selectFilesButton.click();
			
		}

}
