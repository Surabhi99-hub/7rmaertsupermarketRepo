package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.FileUploadUtility;
import com.supermarket.utilities.PageUtility;

public class SubcategoryPage {
	WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public SubcategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement subcatnewbutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement category;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subcategory;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement image;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement subcatsavebutton;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss']//descendant::i)[5]")
	private WebElement subcatdeletebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	public SubcategoryPage clickNewButton() {
		subcatnewbutton.click();
		return this;
	}

	public SubcategoryPage enterCategory() {
		pageutility.selectByVisibleText(category, "cate1");
		return this;
	}

	public SubcategoryPage enterSubCategory(String Product) {
		subcategory.sendKeys(Product);
		return this;
	}

	public SubcategoryPage uploadImage() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendkeys(image, Constants.CHILLIPOWDERIMG);
		return this;
	}

	public SubcategoryPage clickSaveButton() {
		pageutility.clickElementUsingJSExecutor(driver, subcatsavebutton);
		return this;
	}

	public SubcategoryPage clickDeleteButton() {
		pageutility.clickElementUsingJSExecutor(driver, subcatdeletebutton);
		pageutility.acceptAlert(driver);
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
