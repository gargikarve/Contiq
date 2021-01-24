package com.qa.contiq.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.contiq.base.BaseTest;

public class HomePageTest extends BaseTest {
	@BeforeClass
	
	public void setUpHomePage() throws InterruptedException {
			homePg = loginPg.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	public void verifyTitleTest() {
		String title = homePg.verifyTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Contiq: AI-Powered Buyer Intelligence Platform", "title not matched");
	}

	@Test(priority = 2)
	public void doClickNewOpportunityTest() throws InterruptedException {
		homePg.doClickNewOpportunity();
		
	}
}
