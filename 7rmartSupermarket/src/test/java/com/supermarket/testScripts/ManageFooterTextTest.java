package com.supermarket.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.constants.Constants;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageFooterTextPage;
import com.supermarket.utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {
	HomePage homepage;
	ManageFooterTextPage managefootertextpage;

	@Test(description = "Verify the user is able to update the foooter text information by filling the manadatory fields")
	public void verifyTheUserIsAbleToUpdateFooterTextInformation() throws IOException {
		String usernamefield = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordfield = ExcelUtility.getStringData(1, 1, "LoginPage");
		String address = ExcelUtility.getStringData(1, 0, "FooterText");
		String email = ExcelUtility.getStringData(1, 1, "FooterText");
		String phone = ExcelUtility.getStringData(1, 2, "FooterText");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamefield).enterPassword(passwordfield);
		homepage = loginpage.clickSignin();
		managefootertextpage = homepage.footerTextMoreInfo();
		managefootertextpage.actionButton().enterAddress(address).enterEmail(email).enterPhone(phone).updateButton();
		boolean alertmessage = managefootertextpage.isAlert();
		Assert.assertTrue(alertmessage, Constants.UPDATEFOOTERTEXT);
	}

	@Test(description = "Verify whether the update button is present or not in manage footer text section")
	public void verifyWhetherTheUpdateButtonIsPresent() throws IOException {
		String usernamefield = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordfield = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamefield).enterPassword(passwordfield);
		homepage = loginpage.clickSignin();
		managefootertextpage = homepage.footerTextMoreInfo();
		boolean updatebutton = managefootertextpage.isUpdateButtonPresent();
		Assert.assertTrue(updatebutton, Constants.UPDATEBUTTONPRESENTORNOT);
	}
}
