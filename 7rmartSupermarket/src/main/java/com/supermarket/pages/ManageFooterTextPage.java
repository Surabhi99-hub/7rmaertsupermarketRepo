package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.PageUtility;

public class ManageFooterTextPage {
	WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")
	private WebElement updatebutton;
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement address;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phone;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	public ManageFooterTextPage actionButton() {
		updatebutton.click();
		return this;
	}

	public ManageFooterTextPage enterAddress(String addressvalue) {
		address.clear();
		pageutility.sendTextUsingJSExecutor(driver, address, addressvalue);
		return this;
	}

	public ManageFooterTextPage enterEmail(String emailvalue) {
		email.clear();
		pageutility.sendTextUsingJSExecutor(driver, email, emailvalue);
		return this;
	}

	public ManageFooterTextPage enterPhone(String number) {
		phone.clear();
		phone.sendKeys(number);
		return this;
	}

	public ManageFooterTextPage updateButton() {
		pageutility.clickElementUsingJSExecutor(driver, update);
		return this;
	}

	public boolean isUpdateButtonPresent() {
		return updatebutton.isDisplayed();
	}

	public boolean isAlert() {
		return alert.isDisplayed();
	}
}
