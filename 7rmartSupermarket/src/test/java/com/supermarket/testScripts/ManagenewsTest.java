package com.supermarket.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.constants.Constants;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManagenewsPage;
import com.supermarket.utilities.ExcelUtility;

public class ManagenewsTest extends Base {
	HomePage homepage;
	ManagenewsPage managenewspage;

	@Test(description = "Verify the user is able to add the new news")
	public void verifyTheUserIsAbleToAddNews() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String news = ExcelUtility.getStringData(2, 0, "Managenews");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage = loginpage.clickSignin();
		managenewspage = homepage.newsMoreInfo();
		managenewspage.newButton().enterNews(news).saveButton();
		boolean alertmessage = managenewspage.isAlertDisplayed();
		Assert.assertTrue(alertmessage, Constants.ADDNEWS);
	}
}
