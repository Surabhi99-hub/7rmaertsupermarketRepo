package com.supermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	// methods for selecting value using dropdown
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
		;
	}

	// methods for Mouse-based interactions
	public void moveToElemet(WebElement dragableItem, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(dragableItem);
	}

	public void rightClick(WebElement dragableItem, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(dragableItem);
	}

	public void doubleClick(WebElement dragableItem, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(dragableItem);
	}

	public void dragAndDrop(WebElement dragableItem, WebElement dropitem, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(dragableItem, dropitem);
	}

	// methods for alerthandling(OK,CANCEL and TEXT)
	public void acceptAlert(WebDriver driver) {// click ok
		driver.switchTo().alert().accept();
	}

	public void dismissAlert(WebDriver driver) {// click cancel
		driver.switchTo().alert().dismiss();
	}

	public void sendTextToAlertPrompt(WebDriver driver, String text) {// send text to alert
		driver.switchTo().alert().sendKeys(text);
	}

	public String getTextFromAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	// methods to scroll and click an element using javascript executer
	public void scrollByPixelUsingJSExecutor(WebDriver driver, int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0]);", pixel);
	}

	public void scrollToBottomUsingJSExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
	}

	public void clickElementUsingJSExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void sendTextUsingJSExecutor(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1]", element, value);
	}
}
