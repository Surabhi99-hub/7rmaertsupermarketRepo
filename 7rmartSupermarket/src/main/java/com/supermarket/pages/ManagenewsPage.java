package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.PageUtility;

public class ManagenewsPage {
	WebDriver driver;
	PageUtility pageutility=new PageUtility();

	public ManagenewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']")
	private WebElement managenewsmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	private WebElement newsbuttonnew;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement textfield;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement newsbuttonsave;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	public ManagenewsPage newsMoreInfo() {
		pageutility.clickElementUsingJSExecutor(driver, managenewsmoreinfo);
		return this;
	}

	public ManagenewsPage newButton() {
		newsbuttonnew.click();
		return this;
	}

	public ManagenewsPage enterNews(String text) {
		textfield.sendKeys(text);
		return this;
	}

	public ManagenewsPage saveButton() {
		newsbuttonsave.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
