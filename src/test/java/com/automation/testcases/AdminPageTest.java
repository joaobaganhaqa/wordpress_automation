package com.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.ConfigurationBase;
import com.automation.pages.AdminPage;
import com.automation.pages.LoginBackendPage;
import com.automation.pages.PostsPage;

public class AdminPageTest extends ConfigurationBase {
	LoginBackendPage loginBackendPage;
	AdminPage adminPage;
	PostsPage postsPage;
	
	public AdminPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		//Initialize the Browser Drivers and browser properties:
		
		intialization();
		
		//Login the Backend:
		
		loginBackendPage = new LoginBackendPage();
		postsPage = new PostsPage();
		adminPage = loginBackendPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyAdminPageTitle() {
		String adminPagetitle = adminPage.verifyAdminPageTitle();
		Assert.assertEquals(adminPagetitle, "Dashboard ‹ Automation Selenium — WordPress", "Title not found or not matched");
	}

	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(adminPage.verifyCorrectUsername());
	}

	@Test(priority=3)
	public void verifyContactsLinkTest() {
		postsPage = adminPage.clickOnPostsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
