package com.selenium.flipkart_automation.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.flipkart_automation.pages.LoginPage;
import com.selenium.flipkart_automation.utils.CommonUtils;

public class LoginPageTest extends BaseTest {

	// Work sheet Name used by all tests
	private String sheetName = prop.getProperty("loginPageSheetName");

	// HashMap to store data
	HashMap<String, String> testData = new HashMap<String, String>();

	// ______Testcase for Checking valid login Functionality_____
	@Test(groups = { "LoginPage"}, priority = 1, enabled = true)
	public void validLogIn() {
		String testName = "whenUserEntersValidMobileNumberAndPassword";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying the functionality of Valid Login page");

			// Fetching all test data from excel file
			testData = reader.getRowTestData(sheetName, testName);

			String mobileNumber = testData.get("UserName");
			String Password = testData.get("Password");
			String executionRequired = testData.get("Execution Required");
			String expectedResult = testData.get("Expected Result");

			// log all data
			CommonUtils.logTestData(sheetName, testName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);
			login.userLogin(mobileNumber, Password);

			logger.info("Login Button was clicked");
			String actualResult = driver.getTitle();
			Assert.assertTrue(actualResult.contains(expectedResult));

			extentTest.log(LogStatus.INFO, "Valid Login Functionality is working properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}
	}

	// ______Testcase for Checking invalid login Functionality_____
	@Test(groups = {"LoginPage"}, priority = 1, enabled = true)
	public void inValidLogIn() throws InterruptedException {
		String testName = "whenUserEntersValidMobileNumberAndInvalidPassword";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying the functionality of InValid Login page");

			// Fetching all test data from excel file
			testData = reader.getRowTestData(sheetName, testName);

			String mobileNumber = testData.get("UserName");
			String Password = testData.get("Password");
			String executionRequired = testData.get("Execution Required");
			String expectedResult = testData.get("Expected Result");


			// log all data
			CommonUtils.logTestData(sheetName, testName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);
			login.userLogin(mobileNumber, Password);
			logger.info("Login Button was clicked");
			
			Thread.sleep(4000);
			String actualResult = login.errorMessage.getText();
			Assert.assertTrue(actualResult.contains(expectedResult));
			
			extentTest.log(LogStatus.INFO, "InValid Login Functionality is working properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}
	}
}
