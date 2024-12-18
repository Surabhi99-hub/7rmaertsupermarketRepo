package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.PageUtility;

public class ManageContactPage {
	WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")
	private WebElement contactmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	private WebElement edit;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phone;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement address;
	@FindBy(xpath = "//textarea[@name='del_time']")
	private WebElement time;
	@FindBy(xpath = "//input[@id='del_limit']")
	private WebElement chargelimit;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	public ManageContactPage contactMoreInfo() {
		pageutility.clickElementUsingJSExecutor(driver, contactmoreinfo);
		return this;
	}

	public ManageContactPage editButton() {
		edit.click();
		return this;
	}

	public ManageContactPage enterPhone(String number) {
		phone.clear();
		pageutility.sendTextUsingJSExecutor(driver, phone, number);
		return this;
	}

	public ManageContactPage enterEmail(String emailvalue) {
		email.clear();
		pageutility.sendTextUsingJSExecutor(driver, email, emailvalue);
		return this;
	}

	public ManageContactPage enterAddress(String addressvalue) {
		address.clear();
		pageutility.sendTextUsingJSExecutor(driver, address, addressvalue);
		return this;
	}

	public ManageContactPage deliveryTime(String timevalue) {
		time.clear();
		pageutility.sendTextUsingJSExecutor(driver, time, timevalue);
		return this;
	}

	public ManageContactPage deliveryChargeLimit(String chargevalue) {
		chargelimit.clear();
		pageutility.sendTextUsingJSExecutor(driver, chargelimit, chargevalue);
		return this;
	}

	public ManageContactPage updateButton() {
		pageutility.clickElementUsingJSExecutor(driver, update);
		return this;
	}

	public boolean isAlert() {
		return alert.isDisplayed();
	}
}
