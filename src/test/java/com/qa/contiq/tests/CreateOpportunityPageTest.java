package com.qa.contiq.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.contiq.base.BaseTest;

public class CreateOpportunityPageTest extends BaseTest {
	@BeforeClass
	public void setUpCreateOppPage() throws InterruptedException {
		homePg = loginPg.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
		createOpportunityPg = homePg.doClickNewOpportunity();
	}

	@Test(priority = 1)
	public void doCreateAndVerifyNewOpportunityTest() throws InterruptedException {

		String actualOppText = createOpportunityPg.doCreateAndVerifyNewOpportunity("Selenium Test",
				"Selenium Test Acc");
		Assert.assertEquals(actualOppText, "Selenium Test Selenium Test Acc");
	}

}
