package com.supermarket.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.constants.Constants;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageFooterTextPage;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.FakerUtility;

public class ManageFooterTextTest extends Base {
	HomePage homepage;
	ManageFooterTextPage managefootertextpage;

	@Test(description = "Verify the user is able to update the foooter text information by filling the manadatory fields")
	public void verifyTheUserIsAbleToUpdateFooterTextInformation() throws IOException {
		FakerUtility fakerutility = new FakerUtility();
		String usernamefield = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordfield = ExcelUtility.getStringData(1, 1, "LoginPage");
		// String address = ExcelUtility.getStringData(1, 0, "FooterText");
		String email = ExcelUtility.getStringData(1, 1, "FooterText");
		String phone = ExcelUtility.getIntegerData(1, 2, "FooterText");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamefield).enterPassword(passwordfield);
		homepage = loginpage.clickSignIn();
		managefootertextpage = homepage.clickFooterTextMoreInfo();
		String institutionname = fakerutility.getFakeFirstName();
		managefootertextpage.clickActionButton().enterAddress(institutionname).enterEmail(email).enterPhone(phone)
				.clickUpdateButton();
		boolean alertmessage = managefootertextpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage, Constants.UPDATEFOOTERTEXT);
	}

	@Test(description = "Verify whether the update button is present or not in manage footer text section")
	public void verifyWhetherTheUpdateButtonIsPresent() throws IOException {
		String usernamefield = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordfield = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamefield).enterPassword(passwordfield);
		homepage = loginpage.clickSignIn();
		managefootertextpage = homepage.clickFooterTextMoreInfo();
		boolean updatebutton = managefootertextpage.isUpdateButtonPresent();
		Assert.assertTrue(updatebutton, Constants.UPDATEBUTTONPRESENTORNOT);
	}
}
