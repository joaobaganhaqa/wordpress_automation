package com.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.ConfigurationBase;

import com.automation.pages.AdminPage;
import com.automation.pages.LoginBackendPage;
import com.automation.pages.MediaPage;
import com.automation.pages.RemoveMediaPage;
import com.automation.util.TestUtilities;

public class RemoveMediaTest extends ConfigurationBase {
	LoginBackendPage loginBackendPage;
	AdminPage adminPage;
	MediaPage mediaPage;
	RemoveMediaPage removeMediaPage;
	TestUtilities testUtilities;
	
	String sheetName = "ImagesRemove";
	
	public  RemoveMediaTest() {
		super(); 
	}
	
	@BeforeMethod
	public void setUp() {
		//Initialize the Browser Drivers and browser properties:
		
		intialization();
		loginBackendPage = new LoginBackendPage();
		removeMediaPage = new RemoveMediaPage();
		testUtilities = new TestUtilities();
		
		//Login the Backend:
		
		adminPage = loginBackendPage.login(prop.getProperty("username"), prop.getProperty("password"));
		mediaPage = adminPage.clickOnMediaLink();
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtilities.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getTestData")
	public void validateRemoveMedia(String title) throws InterruptedException {
		
		removeMediaPage.imageThumbnailSelected(title);
		Thread.sleep(2000);
		removeMediaPage.clickOnDeletePermanently();
		Thread.sleep(2000);
		testUtilities.alertAccept();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.quit();
	}

}
