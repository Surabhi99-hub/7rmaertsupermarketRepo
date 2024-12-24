package com.supermarket.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.pages.LoginPage;
import com.supermarket.constants.Constants;
import com.supermarket.pages.HomePage;
import com.supermarket.utilities.ExcelUtility;

public class HomePageTest extends Base {
	HomePage homepage;

	@Test(description = "Verify whether the user can successfully logout from the homepage", groups = { "Regression" })
	public void verifyTheUserIsAbleToLogOut() throws IOException {
		String usernamefield = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordfield = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamefield).enterPassword(passwordfield);
		homepage = loginpage.clickSignin();
		homepage.clickAdmin().logoutButton();
		boolean login = homepage.isLoginPageDisplayed();
		Assert.assertTrue(login, Constants.LOGOUT);
	}
}
