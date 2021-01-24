package com.qa.contiq.tests;

import org.testng.annotations.Test;

import com.qa.contiq.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test
	public void clickLoginTest() throws InterruptedException {
		loginPg.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
}
