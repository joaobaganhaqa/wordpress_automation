package com.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.ConfigurationBase;
import com.automation.pages.AdminPage;
import com.automation.pages.LoginBackendPage;
import com.automation.pages.PostsPage;


public class PostsPageTest extends ConfigurationBase {
	LoginBackendPage loginBackend;
	AdminPage adminPage;
	PostsPage postsPage;
	
	
	public PostsPageTest() {
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
		
		
		//click on Posts Link:
		
		adminPage.clickOnPostsLink();
		
	}
	
	@Test(priority=1)
	public void selectAllPostsTest() {
		postsPage.selectAllPostsTitle();
	}
	
	
	@Test(priority=2)
	public void verfifyPostsPageTitle() {
		Assert.assertTrue(postsPage.verifyPostsTitle(), "Posts Title is missing");
	}
	
	@Test(priority=3)
	public void selectPostsTest() {
		postsPage.selectPostsByTitle("Post 1");
	}
	
	@Test(priority=4)
	public void selectMultiplePostsTest() {
		postsPage.selectPostsByTitle("Post 1");
		postsPage.selectPostsByTitle("Post 2");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
