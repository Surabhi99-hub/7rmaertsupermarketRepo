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

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and@class='small-box-footer']")
	private WebElement productmoreinfo;
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

	public ManageProductPage productMoreInfo() {
		productmoreinfo.click();
		return this;
	}

	public ManageProductPage clickNewButton() {
		newbutton.click();
		return this;
	}

	public ManageProductPage enterTitle(String name) {
		pageutility.sendTextUsingJSExecutor(driver, title, name);
		return this;
	}

	public ManageProductPage productType() {
		producttype.click();
		return this;
	}

	public ManageProductPage priceType() {
		pricetype.click();
		return this;
	}

	public ManageProductPage enterValue(String val) {
		pageutility.sendTextUsingJSExecutor(driver, value, val);
		return this;
	}

	public ManageProductPage enterUnit() {
		pageutility.selectByVisibleText(unit, "ml");
		return this;
	}

	public ManageProductPage enterMaxQuantity(String max) {
		pageutility.sendTextUsingJSExecutor(driver, maxquantity, max);
		return this;
	}

	public ManageProductPage clickSaveButton() {
		pageutility.clickElementUsingJSExecutor(driver, save);
		return this;
	}

	public String getAlertText() {
		return pageutility.getTextFromAlert(driver);
	}
}
