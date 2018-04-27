package com.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.ConfigurationBase;
import com.automation.pages.AdminPage;
import com.automation.pages.LoginBackendPage;
import com.automation.pages.PostsPage;

public class EmptyTrashPostsTest extends ConfigurationBase {
	LoginBackendPage loginBackend;
	AdminPage adminPage;
	PostsPage postsPage;
	
	public EmptyTrashPostsTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		//Initialize the Browser Drivers and browser properties:
		
		intialization();
		loginBackend = new LoginBackendPage();
		postsPage = new PostsPage();
		
		//Login the Backend:
		
		adminPage = loginBackend.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
		//click on Posts Link
		adminPage.clickOnPostsLink();
	}
	
	@Test(priority=1)
	public void emptyTrashPosts() throws InterruptedException {
		
		//Click on Trash link:
		
		postsPage.clickOnTrashLink();
		
		//Empty Trash Actions:
		
		postsPage.selectAllPostsTitle();
		postsPage.bulkActionDeleteTrash();
		Thread.sleep(2000);
		postsPage.clickOnApplyButton();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
