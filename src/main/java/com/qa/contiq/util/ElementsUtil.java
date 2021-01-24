package com.qa.contiq.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsUtil {
	private static WebDriver driver;
/**
 * This class contains wrapper method for driver actions
 * @param driver
 */
	public ElementsUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}

	public void doSendKeys(By locator, String value) {
		WebElement ele= getElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean isElementDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public String doGetText(By locator) {
		return driver.findElement(locator).getText();
	}
}
