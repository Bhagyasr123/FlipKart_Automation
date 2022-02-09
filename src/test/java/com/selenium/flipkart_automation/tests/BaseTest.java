package com.selenium.flipkart_automation.tests;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.flipkart_automation.pages.ScreenShots;
import com.selenium.flipkart_automation.utils.ExcelFileIO;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	// To initialize, select(Fire fox, Chrome, IE), open and quit browser.
	public static WebDriver driver;

	static String Browser;
	static File file = new File("./Resources/config.properties");
	static FileInputStream fis = null;
	static Properties prop = new Properties();

	public static ExtentReports extent;
	public static ExtentTest extentTest;
	// protected static Logger logger = LogManager.getLogger(BaseTest.class);
	public final static Logger logger = Logger.getLogger(BaseTest.class);

	// Excel File Test Data Reader
	public static ExcelFileIO reader = null;

	// Exception Handling for Prop
	static {
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Exception Handling for Excel File
		try {

			reader = new ExcelFileIO(prop.getProperty("testDataFileLocation"));
		} catch (Exception e) {

			logger.error(e.getMessage());
		}
	}

	@BeforeTest(groups = { "LoginPage", "LogoutPage", "HomePage", "ProductPage", "OderPage", "abc" })
	public void setExtent() {
		extent = new ExtentReports("./Reports/ExtentReport.html");
	}

	@AfterTest(groups = { "LoginPage", "LogoutPage", "HomePage", "ProductPage", "OderPage", "abc" })
	public void endReport() {
		extent.flush();
		extent.close();
	}

	@BeforeMethod(groups = { "LoginPage", "LogoutPage", "HomePage", "ProductPage", "OderPage", "abc" })
	public static void initializewebdriver() {

		Browser = prop.getProperty("browser");

		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			// WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();

			System.setProperty(prop.getProperty("firefoxDriverProperty"), prop.getProperty("firefoxDriverPath"));
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}else if(Browser.equalsIgnoreCase("chromehl")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1400,600");
			driver = new ChromeDriver(options);
			
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterMethod(groups = { "LoginPage", "LogoutPage", "HomePage", "ProductPage", "OderPage", "abc" })
	public void attachScreenshot(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ScreenShots.CaptureScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Successful");
		}
	}

	@BeforeMethod(groups = { "LoginPage", "LogoutPage", "HomePage", "ProductPage", "OderPage", "abc" })
	public static void openUrl() {
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod(groups = { "LoginPage", "LogoutPage", "HomePage", "ProductPage", "OderPage", "abc" })
	public static void closeBrowser(ITestResult result) {
		// for fail test cases
				if(result.getStatus() == ITestResult.FAILURE) {

					extentTest.log(LogStatus.FAIL, "TEST FAILED "+result.getName());
					extentTest.log(LogStatus.FAIL, "TEST FAILED THROWABLE EXC "+result.getThrowable());

					// adding screenshot
					String screenshotPath = ScreenShots.CaptureScreenshot(driver, result.getName());
					extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
				}

				else if(result.getStatus() == ITestResult.SKIP) {

					extentTest.log(LogStatus.SKIP, "TEST SKIPPED "+result.getName());
				}

				else if(result.getStatus() == ITestResult.SUCCESS) {

					extentTest.log(LogStatus.PASS, "TEST PASSED "+result.getName());
				}

				// end the testcase in the extent report
				extent.endTest(extentTest);

				// closing the driver
				driver.quit();
				logger.info("Browser closed...");
	}
}
