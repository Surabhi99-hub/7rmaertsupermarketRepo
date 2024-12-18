package com.supermarket.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.constants.Constants;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.SubcategoryPage;
import com.supermarket.utilities.ExcelUtility;

public class SubcategoryTest extends Base {
	HomePage homepage;
	SubcategoryPage subcategorypage;

	@Test(description = "Verify the user is able to add new products by adding all the mandatory fields")
	public void verifyTheUserIsAbleToAddNewSubCategoryProducts() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String productname = ExcelUtility.getStringData(1, 0, "SubCategory");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage = loginpage.clickSignin();
		subcategorypage.subCategoryMoreInfo().newButton().enterCategory().enterSubCategory(productname).uploadImage()
				.saveButton();
		boolean alertmessage = subcategorypage.isAlertDisplayed();
		Assert.assertTrue(alertmessage, Constants.ADDSUBCATEGORY);
	}

	@Test(description = "Verify the user is able to delete the products from the existing product table")
	public void verifyTheUserIsAbleToDeleteNewSubCategoryProducts() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage = loginpage.clickSignin();
		subcategorypage.subCategoryMoreInfo().deleteButton();
		boolean alertmessage = subcategorypage.isAlertDisplayed();
		Assert.assertTrue(alertmessage, Constants.DELETESUBCATEGORY);
	}

}
