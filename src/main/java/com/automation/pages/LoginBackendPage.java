package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.ConfigurationBase;

public class LoginBackendPage extends ConfigurationBase {
	
	//Object Repository:
	
	@FindBy(name="log")
	WebElement username;
	
	@FindBy(name="pwd")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@title='Powered by WordPress']")
	WebElement wordpressLogo;
	
	
	//Initalizing the Object Repository
	
	public LoginBackendPage() {
		 PageFactory.initElements(driver, this);
	}
	
	// Actions to do:
		
	public String validateLoginBackendTitle() {
		return driver.getTitle();
	}
	
	public boolean validateWordpressLogo() {
		return wordpressLogo.isDisplayed();
	}
	
	public AdminPage login(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		return new AdminPage();
	}
	
}
