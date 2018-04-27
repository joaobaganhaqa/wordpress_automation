package com.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.ConfigurationBase;
import com.automation.pages.AdminPage;
import com.automation.pages.LoginBackendPage;

public class LoginBackendTest extends ConfigurationBase {
	
	LoginBackendPage loginBackendPage;
	AdminPage adminPage;
	
	public LoginBackendTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		//Initialize the Browser Drivers and browser properties:
		
		intialization();
				
		loginBackendPage = new LoginBackendPage();
	}
	
	@Test(priority=1)
	public void loginBackendTestTitle() {
		String title = loginBackendPage.validateLoginBackendTitle();
		Assert.assertEquals(title, "Log In ‹ Automation Selenium — WordPress");
	}
	
	@Test(priority=2)
	public void wordpressLogoTest() {
		boolean flag = loginBackendPage.validateWordpressLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		adminPage = loginBackendPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		
}