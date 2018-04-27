package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.ConfigurationBase;

public class PostsPage extends ConfigurationBase {
	
	//Collecting Object Repository:
	
	@FindBy(xpath="//h1[@class='wp-heading-inline'][contains(text(),'Posts')]")
	WebElement postsPageTitle;
	
	@FindBy(xpath="//div[@class='wp-menu-name'][contains(text(),'Posts')]")
	WebElement postsLink;
	
	@FindBy(xpath="//a[contains(@class, 'page-title-action')][contains(text(), 'Add New')]")
	WebElement addNewPost;

	@FindBy(xpath="//input[@id='doaction']")
	WebElement applyButton;
	
	@FindBy(xpath="//a[@href='edit.php?post_status=trash&post_type=post']")
	WebElement trashLink;

	//Initializing the Page Objects:
	
	public PostsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyPostsTitle() {
		return postsPageTitle.isDisplayed();
	}
	
	public PostsPage clickOnPostsLink() {
		postsLink.click();
		return new PostsPage();
	}
	
	public void clickOnAddNewPost() {
		addNewPost.click();
	}
	
	public void selectAllPostsTitle() {
		driver.findElement(By.xpath("//input[contains(@id, 'cb-select-all-1')]")).click();
	}
	
	//Handling checkbox:
	
	public void selectPostsByTitle(String id_title) {
		driver.findElement(By.xpath("//a[contains(@class, 'row-title')][contains(text(), '"+id_title+"')]//parent::strong//parent::td//preceding-sibling::th//input")).click();
	}
	
	public void bulkActionMoveToTrash() {
		Select select = new Select(driver.findElement(By.name("action")));
		select.selectByVisibleText("Move to Trash");
	}
	
	public void clickOnApplyButton() {
		applyButton.click();
	}
	
	public void clickOnTrashLink() {
		trashLink.click();
	}
	
	public void bulkActionDeleteTrash() {
		Select select = new Select(driver.findElement(By.name("action")));
		select.selectByVisibleText("Delete Permanently");
	}
	
}
