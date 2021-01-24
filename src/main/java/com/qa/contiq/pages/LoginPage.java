package com.qa.contiq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.contiq.util.ElementsUtil;


public class LoginPage {

	private WebDriver driver;
	private ElementsUtil util;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util= new ElementsUtil(driver);
	}

	// Locators for Login page
	private By email = By.xpath("//input[@name='email']");
	private By continueOp = By.xpath("//button[contains(text(),'Continue')]");
	private By passwd = By.xpath("//input[@name='password']");
	private By login = By.xpath("//button[contains(text(),'Log in') and @type='submit']");

	// Actions on Login page

	public HomePage clickLogin(String emailId, String paasword) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if (wait.until(ExpectedConditions.visibilityOfElementLocated(email)).isDisplayed()) {
			util.doSendKeys(email, emailId);
			util.getElement(continueOp).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(passwd));
			util.doSendKeys(passwd, paasword);
			util.getElement(login).click();

		} else {
			System.out.println("Page not loaded");
		}
		return new HomePage(driver);
	}
}
