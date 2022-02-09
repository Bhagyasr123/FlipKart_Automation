package com.selenium.flipkart_automation.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.flipkart_automation.pages.LoginPage;
import com.selenium.flipkart_automation.pages.ProductOrderPage;
import com.selenium.flipkart_automation.utils.CommonUtils;


public class ProductOrderPageTest extends BaseTest {

	// Work sheet Name used by all tests
	private String sheetName = prop.getProperty("orderPageSheetName");

	// HashMap to store data
	HashMap<String, String> testData = new HashMap<String, String>();

	// ______Testcase for Checking Order Button Functionality_____
	@Test(groups = { "OrderPage"}, priority = 1, enabled = true)
	public void clickFunctionality() throws InterruptedException {
		String testName = "whenUserClickOnOrderButton";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying that User is able to see their Ordered Products");


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
		
		ProductOrderPage orderPage = new ProductOrderPage(driver); 
		orderPage.clickOnOrderButton();
		
		logger.info("Order Button was clicked");
		
		String actualResult = driver.getTitle();
		extentTest.log(LogStatus.INFO, actualResult);
		Assert.assertEquals(actualResult, expectedResult);
		
		extentTest.log(LogStatus.INFO, "User is able to see their orders properly");
		extent.endTest(extentTest);
	} catch (AssertionError e) {
		extentTest.log(LogStatus.FAIL, title);
		extent.endTest(extentTest);

	}
	}
	
	// ______Testcase for Checking filters available on Order Page_______
		@Test(groups = { "OrderPage"}, priority = 1, enabled = true)
		public void filterByOrderStatus() throws InterruptedException {
			String testName = "whenUserFilterByOrderStatus";
			String title = "";

			try {
				extentTest = extent.startTest("Verifying that User is able to filter order by their status");


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
			
			ProductOrderPage orderPage = new ProductOrderPage(driver); 
			orderPage.clickOnOrderButton();
			Thread.sleep(3000);
			orderPage.filterByOrderStatus();
			
			logger.info("Status Button was clicked");
			Thread.sleep(2000);
			String actualResult = orderPage.clearAllButton.getText();
			extentTest.log(LogStatus.INFO, actualResult);
			Assert.assertEquals(actualResult, expectedResult);
			
			extentTest.log(LogStatus.INFO, "Orders are filter by their status is done successfully");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}
		}
}
