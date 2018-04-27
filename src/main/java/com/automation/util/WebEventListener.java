package com.automation.util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.automation.base.ConfigurationBase;

//needs workaround:

public class WebEventListener extends ConfigurationBase {

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
		try {
			TestUtilities.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
