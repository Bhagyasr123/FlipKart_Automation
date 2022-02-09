package com.selenium.flipkart_automation.tests;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.flipkart_automation.pages.HomePage;
import com.selenium.flipkart_automation.pages.LoginPage;
import com.selenium.flipkart_automation.utils.CommonUtils;

public class HomePageTest extends BaseTest {


	// Work sheet Name used by all tests
	private String sheetName = prop.getProperty("homePageSheetName");

	// HashMap to store data
	HashMap<String, String> testData = new HashMap<String, String>();

	// ______Testcase for Checking Search Functionality_____
	@Test(groups = { "HomePage"}, priority = 1, enabled = true)
	public void searchFunctionality() throws InterruptedException {
		String testName = "whenUserSearchTheProduct";

		try {
			extentTest = extent.startTest("Verifying the Search functionality");

			// Fetching all test data from excel file
			testData = reader.getRowTestData(sheetName, testName);

			String mobileNumber = testData.get("UserName");
			String Password = testData.get("Password");
			String productName = testData.get("Product Name");
			String executionRequired = testData.get("Execution Required");
			String expectedResult = testData.get("Expected Result");


			// log all data
			CommonUtils.logTestData(sheetName, testName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);
			login.userLogin(mobileNumber, Password);
			Thread.sleep(3000);

			HomePage homepage = new HomePage(driver);
			homepage.searchProduct(productName);

			logger.info("Search Icon Button was clicked");
			Thread.sleep(1000);
			String actualResult = driver.getTitle();
			extentTest.log(LogStatus.INFO, actualResult);

			Assert.assertTrue(actualResult.contains(expectedResult));

			
			extentTest.log(LogStatus.INFO, "Search Functionality is working properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL,"Failed");
			extent.endTest(extentTest);

		}
	}

	// ______Testcase for Checking Sort Functionality_____
	@Test(groups = { "HomePage"}, priority = 1, enabled = true)
	public void sortingFunctionality() throws InterruptedException {
		String testName = "whenUserSortTheProduct";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying the Sorting functionality");

			// Fetching all test data from excel file
			testData = reader.getRowTestData(sheetName, testName);

			String mobileNumber = testData.get("UserName");
			String Password = testData.get("Password");
			String productName = testData.get("Product Name");
			String executionRequired = testData.get("Execution Required");
			String expectedResult = testData.get("Expected Result");


			// log all data
			CommonUtils.logTestData(sheetName, testName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);
			login.userLogin(mobileNumber, Password);
			Thread.sleep(3000);

			HomePage homepage = new HomePage(driver);
			
			homepage.sortProduct(productName);
			Thread.sleep(3000);
			
			logger.info("Sorting Button was clicked");
		    String actualResult = homepage.sortByPrice_HighToLow.getText();
			extentTest.log(LogStatus.INFO, actualResult);
			Assert.assertEquals(actualResult,expectedResult);

			extentTest.log(LogStatus.INFO, "Sorting Functionality is working properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}
	}

	// ______Testcase for Checking LogoButton Functionality_____

	@Test(groups = { "HomePage"}, priority = 1, enabled = true)
	public void logoButtonFunctionality() throws InterruptedException {

		String testName = "whenUserClickOnLogoButton";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying the Logo Button functionality");

			// Fetching all test data from excel file
			testData = reader.getRowTestData(sheetName, testName);

			String mobileNumber = testData.get("UserName");
			String Password = testData.get("Password");
			String productName = testData.get("Product Name");
			String executionRequired = testData.get("Execution Required");
			String expectedResult = testData.get("Expected Result");


			// log all data
			CommonUtils.logTestData(sheetName, testName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);
			login.userLogin(mobileNumber, Password);
			Thread.sleep(3000);

			HomePage homepage = new HomePage(driver);
			homepage.sortProduct(productName);
			homepage.goBackToHome();
			Thread.sleep(3000);

			logger.info("Logo Button was clicked");
			
			String actualResult = driver.getTitle();
			extentTest.log(LogStatus.INFO, actualResult);

			Assert.assertTrue(actualResult.contains(expectedResult));
			
			extentTest.log(LogStatus.INFO, "Logo Button Functionality is working properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}
	}

	// ______Testcase for Checking Wish List Functionality_____
	@Test(groups = { "HomePage"}, priority = 1, enabled = true)
	public void wishlistFunctionality() throws InterruptedException {
		String testName = "whenUserAddProductIntoWishlist";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying the Wishlist functionality");

			// Fetching all test data from excel file
			testData = reader.getRowTestData(sheetName, testName);

			String mobileNumber = testData.get("UserName");
			String Password = testData.get("Password");
			String productName = testData.get("Product Name");
			String executionRequired = testData.get("Execution Required");
			String expectedResult = testData.get("Expected Result");


			// log all data
			CommonUtils.logTestData(sheetName, testName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);
			login.userLogin(mobileNumber, Password);
			Thread.sleep(3000);
			HomePage homepage = new HomePage(driver);
			homepage.searchProduct(productName);
			Thread.sleep(3000);
			homepage.addProductIntoWishlist();
			Thread.sleep(3000);

			logger.info("Wishlist Button was clicked");
			
			String actualResult = driver.getTitle();
			extentTest.log(LogStatus.INFO, actualResult);

			Assert.assertTrue(actualResult.contains(expectedResult));
			extentTest.log(LogStatus.INFO, "Wishlist Functionality is working properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}

	}

	// ______Testcase for Checking Customer Rating Filter of the Product
	// Functionality_____
	@Test(groups = { "HomePage"}, priority = 1, enabled = true)
	public void changePriceByFilter() throws InterruptedException {
		String testName = "whenUserClickOnCustomerRating";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying the Product Filter by the Ratings");

			// Fetching all test data from excel file
			testData = reader.getRowTestData(sheetName, testName);

			String mobileNumber = testData.get("UserName");
			String Password = testData.get("Password");
			String productName = testData.get("Product Name");
			String executionRequired = testData.get("Execution Required");
			String expectedResult = testData.get("Expected Result");


			// log all data
			CommonUtils.logTestData(sheetName, testName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);
			login.userLogin(mobileNumber, Password);
			Thread.sleep(2000);
			HomePage homepage = new HomePage(driver);
			homepage.searchProduct(productName);

			Thread.sleep(2000);
			homepage.setProductByCustomerRatings();
			Thread.sleep(2000);

			logger.info("Filter Button was clicked");
			
			String actualResult = homepage.filterRatingMessage.getText();
			extentTest.log(LogStatus.INFO, actualResult);
			Assert.assertEquals(actualResult,expectedResult);

			extentTest.log(LogStatus.INFO, "Product Filter by Rating Functionality is working properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}
	}

	// ______Testcase for Checking user should be able to see Rating and Reviews of
	// Product_____
	@Test(groups = { "HomePage"}, priority = 1, enabled = true)
	public void checkReviewsAndRating() throws InterruptedException {
		String testName = "whenUserHoverOnReviewIcon";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying the User is able to see Ratings and Reviews of the products");

			// Fetching all test data from excel file
			testData = reader.getRowTestData(sheetName, testName);

			String mobileNumber = testData.get("UserName");
			String Password = testData.get("Password");
			String productName = testData.get("Product Name");
			String executionRequired = testData.get("Execution Required");
			String expectedResult = testData.get("Expected Result");


			// log all data
			CommonUtils.logTestData(sheetName, testName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);
			login.userLogin(mobileNumber, Password);
			Thread.sleep(2000);
			HomePage homepage = new HomePage(driver);
			homepage.searchProduct(productName);
			Thread.sleep(2000);
			homepage.hoverOnReviewIcon();
			Thread.sleep(2000);

			logger.info("Rating and Review Icon was hover");

			Thread.sleep(5000);
			boolean result = homepage.scrollBar.isDisplayed();
			String actualResult='"'+String.valueOf(result).toLowerCase()+'"';
			extentTest.log(LogStatus.INFO, actualResult);
			Assert.assertEquals(actualResult,expectedResult);
			extentTest.log(LogStatus.INFO, expectedResult);
			
			extentTest.log(LogStatus.INFO, "User is able to see the ratings and reviews of the product properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}
	}

	// ______Testcase for Checking BAck To Top Button Functionality_____
	@Test(groups = { "HomePage"}, priority = 1, enabled = true)
	public void clickOnBackToButton() throws InterruptedException {
		String testName = "whenUserClickOnBackToTopButton";

		try {
			extentTest = extent.startTest(
					"Verifying the functionality of Back To Top Button which is present on the Product page");

			// Fetching all test data from excel file
			testData = reader.getRowTestData(sheetName, testName);

			String mobileNumber = testData.get("UserName");
			String Password = testData.get("Password");
			String productName = testData.get("Product Name");
			String executionRequired = testData.get("Execution Required");
			String expectedResult = testData.get("Expected Result");


			// log all data
			CommonUtils.logTestData(sheetName, testName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);
			login.userLogin(mobileNumber, Password);
			Thread.sleep(2000);
			HomePage homepage = new HomePage(driver);
			homepage.searchProduct(productName);
			homepage.clickBAckToTop();
			Thread.sleep(3000);

			logger.info("Back To Top Button was clicked");
			
			String actualResult = homepage.message.getText();	
			extentTest.log(LogStatus.INFO, actualResult);
			Assert.assertEquals(actualResult,expectedResult);
			
			extentTest.log(LogStatus.INFO, "Back To Top Button Functionality is working properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, "Failed");
			extent.endTest(extentTest);

		}

	}

	// ______Testcase for Checking User should be able to go on Next Page_____
	@Test(groups = { "HomePage"}, priority = 1, enabled = true)
	public void clickOnNextPageButtons() throws InterruptedException {
		String testName = "whenUserClickOnNextPageButton";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying that User is able to change the Next Page");

			// Fetching all test data from excel file
			testData = reader.getRowTestData(sheetName, testName);

			String mobileNumber = testData.get("UserName");
			String Password = testData.get("Password");
			String productName = testData.get("Product Name");
			String executionRequired = testData.get("Execution Required");
			String expectedResult = testData.get("Expected Result");


			// log all data
			CommonUtils.logTestData(sheetName, testName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);
			login.userLogin(mobileNumber, Password);
			Thread.sleep(3000);
			HomePage homepage = new HomePage(driver);
			homepage.searchProduct(productName);
			Thread.sleep(2000);
			homepage.clickToNextPage();
			Thread.sleep(3000);

			logger.info("Next Page Button was clicked");
			
			String actualResult = homepage.previousButton.getText();	
			extentTest.log(LogStatus.INFO, actualResult);
			Assert.assertEquals(actualResult,expectedResult);
			
			extentTest.log(LogStatus.INFO, "Next Page is changed successfully");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}

	}

}
