package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signinbutton;
	@FindBy(xpath = "//p[text()='Admin Users']")
	private WebElement adminuser;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alert;

	public LoginPage enterUsername(String username) {
		usernamefield.sendKeys(username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		passwordfield.sendKeys(password);
		return this;
	}

	public HomePage clickSignIn() {
		signinbutton.click();
		return new HomePage(driver);
	}

	public boolean isHomePageDisplayed() {
		return adminuser.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
