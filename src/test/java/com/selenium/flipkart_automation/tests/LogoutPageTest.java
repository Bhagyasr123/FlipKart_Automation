package com.selenium.flipkart_automation.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.flipkart_automation.pages.LoginPage;
import com.selenium.flipkart_automation.pages.LogoutPage;
import com.selenium.flipkart_automation.utils.CommonUtils;

public class LogoutPageTest extends BaseTest {
	// Work sheet Name used by all tests
	private String sheetName = prop.getProperty("logoutPageSheetName");

	// HashMap to store data
	HashMap<String, String> testData = new HashMap<String, String>();

	// ______Testcase for Checking logout Functioality_____
	@Test(groups = {"LogoutPage"}, priority = 1, enabled = true)
	public void userLogout() throws InterruptedException {

		String testName = "whenUserClickToLogout";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying the functionality of LogOut Button");

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
			Thread.sleep(2000);

			LogoutPage logout = new LogoutPage(driver);
			Thread.sleep(5000);

			logout.clickProfile();
			Thread.sleep(15000);
			logout.clickLogout();
			Thread.sleep(2000);

			logger.info("LogOut Button was clicked");

			Thread.sleep(4000);
			String actualResult = logout.logoutMessage.getText();
			extentTest.log(LogStatus.INFO, actualResult);
			Thread.sleep(2000);
			Assert.assertEquals(actualResult, expectedResult);

			extentTest.log(LogStatus.INFO, "Logout Functionality is working properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);	

		}
	}

}
