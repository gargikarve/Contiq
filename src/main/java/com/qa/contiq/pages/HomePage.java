package com.qa.contiq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.contiq.util.ElementsUtil;


public class HomePage {
	private WebDriver driver;
	private ElementsUtil util;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		util = new ElementsUtil(driver);
	}

	// Locators for HomePage
	private By newOpp = By.id("btn-create-collabspace");
	
	// Actions for HomePage

	public String verifyTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Contiq: AI-Powered Buyer Intelligence Platform"));
		String titleTx = util.getTitle();
		return titleTx;
	}

	public CreateOpportunityPage doClickNewOpportunity() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(newOpp));
		util.getElement(newOpp).click();
		return new CreateOpportunityPage(driver);
		}
	
}
