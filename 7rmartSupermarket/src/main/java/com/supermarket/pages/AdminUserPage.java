package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class AdminUserPage {
	WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement adminnewbutton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement adminusername;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement adminpassword;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement adminusertype;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement adminsavebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	public AdminUserPage newButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, adminnewbutton);
		adminnewbutton.click();
		return this;
	}

	public AdminUserPage enterUsername(String username) {
		adminusername.sendKeys(username);
		return this;
	}

	public AdminUserPage enterPassword(String password) {
		adminpassword.sendKeys(password);
		return this;
	}

	public AdminUserPage enterUserType() {
		pageutility.selectByVisibleText(adminusertype, "Staff");
		return this;
	}

	public AdminUserPage saveButton() {
		adminsavebutton.click();
		return this;
	}

	public boolean isAlert() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForAlertToBeVisible(driver);
		return alert.isDisplayed();
	}
}
