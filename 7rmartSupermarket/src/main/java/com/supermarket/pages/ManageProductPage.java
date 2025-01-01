package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.PageUtility;

public class ManageProductPage {
	WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newbutton;
	@FindBy(xpath = "//input[@id='title' and @type='text']")
	private WebElement title;
	@FindBy(xpath = "//input[@value='Others']")
	private WebElement producttype;
	@FindBy(xpath = "//input[@id='purpose2']")
	private WebElement pricetype;
	@FindBy(xpath = "//input[@id='l_minimum']")
	private WebElement value;
	@FindBy(xpath = "//select[@id='l_unit']")
	private WebElement unit;
	@FindBy(xpath = "//input[@id='l_max']")
	private WebElement maxquantity;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save;

	public ManageProductPage clickNewButton() {
		newbutton.click();
		return this;
	}

	public ManageProductPage enterTitle(String name) {
		pageutility.sendTextUsingJSExecutor(driver, title, name);
		return this;
	}

	public ManageProductPage clickProductType() {
		producttype.click();
		return this;
	}

	public ManageProductPage clickPriceType() {
		pricetype.click();
		return this;
	}

	public ManageProductPage enterValue(String litrevalue) {
		pageutility.sendTextUsingJSExecutor(driver, value, litrevalue);
		return this;
	}

	public ManageProductPage enterUnit() {
		pageutility.selectByVisibleText(unit, "ml");
		return this;
	}

	public ManageProductPage enterMaxQuantity(String quantity) {
		pageutility.sendTextUsingJSExecutor(driver, maxquantity, quantity);
		return this;
	}

	public ManageProductPage clickSaveButton() {
		pageutility.clickElementUsingJSExecutor(driver, save);
		return this;
	}

	public String isGetAlertText() {
		return pageutility.getTextFromAlert(driver);
	}
}
