package com.supermarket.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.constants.Constants;
import com.supermarket.pages.AdminUserPage;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.ExcelUtility;

public class AdminUserTest extends Base {
	HomePage homepage;
	AdminUserPage adminuserpage;

	@Test(description = "Verify the user is able to add new admin user by filling the manadatory fields")
	public void verifyTheUserIsAbleToAddNewAdminUser() throws IOException {
		String usernamefield = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordfield = ExcelUtility.getStringData(1, 1, "LoginPage");
		String username = ExcelUtility.getStringData(1, 0, "AdminUsers");
		String password = ExcelUtility.getIntegerData(1, 1, "AdminUsers");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamefield).enterPassword(passwordfield);
		homepage = loginpage.clickSignIn();
		adminuserpage = homepage.clickAdminUserMoreInfo();
		adminuserpage.clickNewButton().enterUserName(username).enterPassword(password).enterUserType()
				.clickSaveButton();
		boolean alertmessage = adminuserpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage, Constants.ADDNEWUSER);
	}
}
