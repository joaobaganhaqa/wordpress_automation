package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.ConfigurationBase;

public class AddNewPostPage extends ConfigurationBase {
	
	//Collecting Object Repository:

	@FindBy(xpath="//a[@id='set-post-thumbnail']")
	WebElement selectFeaturedImageButton;
	
	@FindBy(xpath="//a[contains(@class, 'media-menu-item') and contains(text(),'Media Library')]")
	WebElement selectMediaLibraryButton;
	
	@FindBy(xpath="//button[@class='button media-button button-primary button-large media-button-select']")
	WebElement setFeaturedImageButton;
	
	@FindBy(xpath="//input[contains(@name, 'post_title')]")
	WebElement postTitle;
	
	@FindBy (xpath="//body[contains(@class, 'mce-content-body')]")
	WebElement textArea;
	
	@FindBy (xpath="//input[@data-wp-taxonomy='post_tag']")
	WebElement tagArea;
	
	@FindBy(xpath="//input[@class='button tagadd']")
	WebElement addTagButton;
	
	@FindBy(xpath="//input[contains(@name, 'save') and contains(@id, 'save-post')]")
	WebElement saveButton;
	
	@FindBy(xpath="//a[contains(@class, 'preview button') and contains(@id, 'post-preview')]")
	WebElement previewButton;
	
	@FindBy (xpath="//input[@type='submit' and @value='Publish']")
	WebElement publishButton;
	
	//Initializing the Page Objects:
	
	public AddNewPostPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectThumbnailImage() {
		selectFeaturedImageButton.click();
	}
	
	public void changeToMediaLibrary() {
		selectMediaLibraryButton.click();
	}
	
	public void imageThumbnailSelected (String thumbnail) {
		driver.findElement(By.xpath("//li[@aria-label='"+thumbnail+"']//parent::div//preceding-sibling::div")).click();
	}
	
	public void  saveThumbnailImage() {
		setFeaturedImageButton.click();
	}
	
	public void fillTitle(String title) {
		postTitle.sendKeys(title);
	}
	
	public void fillTextArea(String text) {
		textArea.sendKeys(text);
	}
	
	public void tagArea(String tag) {
		tagArea.sendKeys(tag);
	}

	public void addTag() {
		addTagButton.click();
	}
	
	public void publishPost() {
		publishButton.click();
	}
	
}
