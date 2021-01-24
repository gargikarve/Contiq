package com.qa.contiq.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.contiq.factory.DriverFactory;
import com.qa.contiq.pages.CreateOpportunityPage;
import com.qa.contiq.pages.HomePage;
import com.qa.contiq.pages.LoginPage;

public class BaseTest {

	DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPg;
	public HomePage homePg;
	public CreateOpportunityPage createOpportunityPg;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_properties();
		String bName = prop.getProperty("browser");
		driver = df.init_driver(bName);
		driver.get(prop.getProperty("url"));
		loginPg= new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
