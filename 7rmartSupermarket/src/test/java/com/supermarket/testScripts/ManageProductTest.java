package com.supermarket.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.constants.Constants;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageProductPage;

import com.supermarket.utilities.ExcelUtility;

public class ManageProductTest extends Base {
	HomePage homepage;
	ManageProductPage manageproductpage;

	@Test(description = "Verify whether the alert is prompted while saving the product page without filling the manadetory fields ")
	public void verifyWhetherTheAlertPromptIsDisplayed() throws IOException {
		String usernamefield = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordfield = ExcelUtility.getStringData(1, 1, "LoginPage");
		String titlefield = ExcelUtility.getStringData(1, 0, "ManageProduct");
		String valuefield = ExcelUtility.getIntegerData(1, 1, "ManageProduct");
		String quantityfield = ExcelUtility.getIntegerData(1, 2, "ManageProduct");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamefield).enterPassword(passwordfield);
		homepage = loginpage.clickSignin();
		manageproductpage = homepage.productMoreInfo();
		manageproductpage.clickNewButton().enterTitle(titlefield).productType().priceType().enterValue(valuefield)
				.enterUnit().enterMaxQuantity(quantityfield).clickSaveButton();
		String actualalerttext = manageproductpage.getAlertText();
		String expectedalerttext = ExcelUtility.getStringData(1, 4, "ManageProduct");
		Assert.assertEquals(actualalerttext, expectedalerttext, Constants.PRODUCTALERTPROMPTDISPLAYED);
	}
}
