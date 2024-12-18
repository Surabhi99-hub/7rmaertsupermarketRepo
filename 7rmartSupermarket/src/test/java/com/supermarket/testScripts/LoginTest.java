package com.supermarket.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(description = "Verify the user is able to login with valid username and password", groups = { "Regression" })
	public void verifyTheUserCanLoginUsingValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue).clickSignin();
		boolean homepage = loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepage, Constants.HOMEPAGENOTFOUND);
	}

	@Test(description = "Verify the user is able to login with invalid username and password")
	public void verifyTheUserIsAbleToLoginUsingWrongUsername() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue).clickSignin();
		boolean alertmessage = loginpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage, Constants.INVALIDUSERNAMEALERT);
	}

	@Test(description = "Verify the user is able to login with valid username and invalid password")
	public void verifyTheUserIsAbleToLoginUsingWrongPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue).clickSignin();
		boolean alertmessage = loginpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage, Constants.INVALIDPASSWORDALERT);
	}

	@Test(description = "Verify the user is able to login with invalid username and password", dataProvider = "LoginProvider")
	public void verifyTheUserIsAbleToLoginUsingInvalidCredentials(String usernamevalue, String passwordvalue)
			throws IOException {
		// String usernamevalue = ExcelUtility.getStringData(4, 0, "LoginPage");
		// String passwordvalue = ExcelUtility.getStringData(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue).clickSignin();
		boolean alertmessage = loginpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage, Constants.INVALIDCREDENTIALSALERT);
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] {
				{ ExcelUtility.getStringData(4, 0, "LoginPage"), ExcelUtility.getStringData(4, 1, "LoginPage") } };
	}
}
