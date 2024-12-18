package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.PageUtility;

public class HomePage {
	WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	private WebElement adminmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")
	private WebElement contactmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	private WebElement footermoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']")
	private WebElement managenewsmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and@class='small-box-footer']")
	private WebElement productmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category' and @class=' nav-link']")
	private WebElement subcatmoreinfo;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")
	private WebElement logout;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signin;

	public AdminUserPage adminUserMoreInfo() {
		pageutility.clickElementUsingJSExecutor(driver, adminmoreinfo);
		return new AdminUserPage(driver);
	}

	public ManageContactPage contactMoreInfo() {
		contactmoreinfo.click();
		return new ManageContactPage(driver);
	}

	public ManageFooterTextPage footerTextMoreInfo() {
		pageutility.clickElementUsingJSExecutor(driver, footermoreinfo);
		return new ManageFooterTextPage(driver);
	}

	public ManagenewsPage newsMoreInfo() {
		managenewsmoreinfo.click();
		return new ManagenewsPage(driver);
	}

	public ManageProductPage productMoreInfo() {
		productmoreinfo.click();
		return new ManageProductPage(driver);
	}

	public SubcategoryPage subCategoryMoreInfo() {
		subcatmoreinfo.click();
		return new SubcategoryPage(driver);
	}

	public HomePage clickAdmin() {
		admin.click();
		return this;
	}

	public LoginPage logoutButton() {
		logout.click();
		return new LoginPage(driver);
	}

	public boolean isLoginPageDisplayed() {
		return signin.isDisplayed();
	}
}
