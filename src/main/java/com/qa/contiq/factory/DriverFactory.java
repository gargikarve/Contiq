package com.qa.contiq.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver;
	public static Properties prop;

	/**
	 * This method is responsible to initialize browser depending on browser name
	 * given in config file
	 * 
	 * @param browserName
	 * @return
	 */
	public WebDriver init_driver(String browserName) {

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			// tlDriver.set(new ChromeDriver(op.getChromeOptions()));
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("Please pass the correct browser name" + browserName);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		return driver;
	}

	/**
	 * This is used to read values from config file properties
	 * 
	 * @return properties object
	 */
	public Properties init_properties() {

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(".\\src\\test\\Resources\\contiq\\config\\config.properties");// src\test\Resources\contiq\config\config.properties
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}



	/**
	 * This method is responsible to take screenshot in case of test case failure
	 * @return path of local screenshot folder
	 */
	public String getScreenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotSRC = ts.getScreenshotAs(OutputType.FILE);//source of screenshot
		String path = System.getProperty("user.dir") + "\\screenshots\\" + System.currentTimeMillis() + ".png";

		File destination = new File(path);
		try {
			FileUtils.copyFile(screenshotSRC, destination);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return path;
	}

}
