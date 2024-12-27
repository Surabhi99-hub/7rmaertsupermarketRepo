package com.supermarket.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.constants.Constants;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageContactPage;
import com.supermarket.utilities.ExcelUtility;

public class ManageContactTest extends Base {
	HomePage homepage;
	ManageContactPage managecontactpage;

	@Test(description = "Verify the user is able to update the contact details by filling the mandatory fields")
	public void verifyTheUserIsAbleToUpdateContact() throws IOException {
		String usernamefield = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordfield = ExcelUtility.getStringData(1, 1, "LoginPage");
		String phonefield = ExcelUtility.getIntegerData(1, 0, "ManageContact");
		String emailfield = ExcelUtility.getStringData(1, 1, "ManageContact");
		String addressfield = ExcelUtility.getStringData(1, 2, "ManageContact");
		String deliverytimefield = ExcelUtility.getIntegerData(1, 3, "ManageContact");
		String deliverychargefield = ExcelUtility.getIntegerData(1, 4, "ManageContact");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamefield).enterPassword(passwordfield);
		homepage = loginpage.clickSignin();
		managecontactpage = homepage.contactMoreInfo();
		managecontactpage.editButton().enterPhone(phonefield).enterEmail(emailfield).enterAddress(addressfield)
				.deliveryTime(deliverytimefield).deliveryChargeLimit(deliverychargefield).updateButton();
		boolean message = managecontactpage.isAlertDisplayed();
		Assert.assertTrue(message, Constants.UPDATECONTACT);
	}
}
