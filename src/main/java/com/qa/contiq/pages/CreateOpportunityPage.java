package com.qa.contiq.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.contiq.util.ElementsUtil;

public class CreateOpportunityPage {

	private WebDriver driver;
	private ElementsUtil util;

	public CreateOpportunityPage(WebDriver driver) {
		this.driver = driver;
		util= new ElementsUtil(driver);
	}
	
	// Locators for CreateOpportunityPage

	private By oppName = By.xpath("//input[@ng-reflect-name='title']");
	private By accName = By.xpath("//input[@ng-reflect-name='accountname']");
	private By createBtn = By.xpath("//button[contains(text(),' Create ')]");
	private By editCollabSp = By.xpath("//div[@id='mat-dialog-title-0']/span");
	private By closeEditCollabSp = By.xpath("//i[@class='icon-close font-18']");
	private By tableContent= By.xpath("//div[@class='buyer-engagement-table']//tbody[@role='rowgroup']/tr");

	// Actions for CreateOpportunityPage

	public String doCreateAndVerifyNewOpportunity(String opportunityName, String companyName) throws InterruptedException {
		String actualtxt="";
		util.doSendKeys(oppName, opportunityName);
		util.doSendKeys(accName, companyName);
		util.getElement(createBtn).click();
		Thread.sleep(5000);
		util.getElement(closeEditCollabSp).click();
		Thread.sleep(10000);		
		List<WebElement> contentList= util.getElements(By.xpath("//tbody[@role='rowgroup']/tr/td[1]"));
		System.out.println(contentList.size());
		for (WebElement e : contentList)
		{
			actualtxt= e.getText();
			actualtxt=actualtxt.replaceAll("[\n]", " "); // removing \n char from the string value
			actualtxt=actualtxt.trim();
			if(actualtxt.contains(opportunityName)) {
				System.out.println("Txt present- NewOpportunity created");
			}
			break;
		}
		System.out.println(actualtxt);
		return actualtxt;

	}
	


}
