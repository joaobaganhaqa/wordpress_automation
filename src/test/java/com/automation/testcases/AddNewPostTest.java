package com.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.ConfigurationBase;
import com.automation.pages.AddNewPostPage;
import com.automation.pages.AdminPage;
import com.automation.pages.LoginBackendPage;
import com.automation.pages.PostsPage;
import com.automation.util.TestUtilities;

public class AddNewPostTest extends ConfigurationBase {
	
	LoginBackendPage loginBackendPage;
	AdminPage adminPage;
	PostsPage postsPage;
	AddNewPostPage addNewPostPage;
	TestUtilities testUtilities;
	
	String sheetName = "Posts";
	
	
	public  AddNewPostTest() {
		super(); 
	}
	
	@BeforeMethod
	public void setUp() {
		
		//Initialize the Browser Drivers and browser properties:
		
		intialization();
		loginBackendPage = new LoginBackendPage();
		postsPage = new PostsPage();
		adminPage = new AdminPage();
		addNewPostPage = new AddNewPostPage();
		testUtilities = new TestUtilities();
		
		//Login the Backend:
		
		adminPage = loginBackendPage.login(prop.getProperty("username"), prop.getProperty("password"));
		postsPage = adminPage.clickOnPostsLink();
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtilities.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getTestData")
	public void validateAddNewPost(String title, String post, String tags, String thumbnail) throws InterruptedException {
		
		//Click on New Post Button:
		
		postsPage.clickOnAddNewPost();
		
		//Add a thumbnail image:
		
		addNewPostPage.selectThumbnailImage();
		addNewPostPage.changeToMediaLibrary();
		addNewPostPage.imageThumbnailSelected(thumbnail);
		Thread.sleep(5000);
		addNewPostPage.saveThumbnailImage();
		
		//Fill the tags:
		
		addNewPostPage.tagArea(tags);
				
		//click on Add tag Button:
		
		addNewPostPage.addTag();
		
		addNewPostPage.fillTitle(title);
		
		//Switching to iframe wordpress Post Area:
		
		testUtilities.switchToFrame();
		
		//Fill the content:
		
		addNewPostPage.fillTextArea(post);
		
		//Switching again to exit iframe wordpress Post Area:
		
		testUtilities.switchToDefaultContent();
			
		//click on Publish Button to publish the post:
		
		addNewPostPage.publishPost();
		
	} 
	
	 /* public void validateAddNewPost() {
		addNewPostPage.clickOnAddNewPost();
		addNewPostPage.fillTitle("Post 4");
		
		//Switching to iframe wordpress Post Area
		driver.switchTo().frame("content_ifr");
		
		//inserting the content
		addNewPostPage.fillTextArea("Lorem Ipsum");
		
	} */
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
	

