package com.automation.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.ConfigurationBase;
import com.automation.pages.AddNewMediaPage;
import com.automation.pages.AdminPage;
import com.automation.pages.LoginBackendPage;
import com.automation.pages.MediaPage;
import com.automation.util.TestUtilities;

public class AddNewMediaTest extends ConfigurationBase {
	LoginBackendPage loginBackendPage;
	AdminPage adminPage;
	AddNewMediaPage addNewMediaPage;
	MediaPage mediaPage;
	TestUtilities testUtilities;
	Process process;
	
	String sheetName = "Images";
	String uploadScript = "osascript " + System.getProperty("user.dir") + "/src/main/java/com/automation/util/upload.scpt";
	

	public  AddNewMediaTest() {
		super(); 
	}
	
	@BeforeMethod
	public void setUp() {
		
		//Initialize the Browser Drivers and browser properties:
		
		intialization();
		loginBackendPage = new LoginBackendPage();
		adminPage = new AdminPage();
		mediaPage = new MediaPage();
		addNewMediaPage = new AddNewMediaPage();
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
	public void validateAddNewMedia(String images_url) throws IOException, InterruptedException {
		
		//Click on add new media button:
		
		mediaPage.clickOnAddNewMedia();
		
		addNewMediaPage.selectFiles();
		
		
		// Runtime.getRuntime().exec(uploadScript);
		
		Runtime runtime = Runtime.getRuntime();
		String appleScriptCommand = "tell app \"System Events\"\n" +
		
		"keystroke \"G\" using {command down, shift down}\n" +
		"delay 2\n" +
		"keystroke \"" + System.getProperty("user.dir") + images_url + "\"\n" +
		"delay 2\n" +
		"keystroke return\n" +
		"delay 2\n" +
		"keystroke return\n" +
		"end tell";
		
		String[] args = { "osascript", "-e", appleScriptCommand };
		process = runtime.exec(args);
	
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
	
}
