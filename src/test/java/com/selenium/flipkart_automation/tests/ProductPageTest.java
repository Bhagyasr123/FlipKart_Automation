package com.selenium.flipkart_automation.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.flipkart_automation.pages.HomePage;
import com.selenium.flipkart_automation.pages.LoginPage;
import com.selenium.flipkart_automation.pages.ProductPage;
import com.selenium.flipkart_automation.utils.CommonUtils;

public class ProductPageTest extends BaseTest {

	// Work sheet Name used by all tests
	private String sheetName = prop.getProperty("productPageSheetName");

	// HashMap to store data
	HashMap<String, String> testData = new HashMap<String, String>();

	// ______Testcase for Checking Add To Compare Functionality_____
	@Test(groups = { "ProductPage" }, priority = 1, enabled = true)
	public void clickOnAddToCompare() throws InterruptedException {
		String testName = "whenUserClickOnAddToCompareButton";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying the Product Compare Functionality");

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

			ProductPage product = new ProductPage(driver);
			Thread.sleep(4000);
			product.addToCompare();
			Thread.sleep(3000);

			logger.info("Compare Button was clicked");

			Thread.sleep(3000);
			String actualResult = product.checkboxShowDiffrence.getText();
			extentTest.log(LogStatus.INFO, actualResult);
			Assert.assertEquals(actualResult, expectedResult);

			extentTest.log(LogStatus.INFO, "Product Compare functionality is working properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}

	}

	// ______Testcase for Checking Click Functionality_____
	@Test(groups = { "ProductPage" }, priority = 1, enabled = true)
	public void clickFunctionality() throws InterruptedException {
		String testName = "whenUserClickOnProduct";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying that User is able to click on the product");

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

			ProductPage product = new ProductPage(driver);
			Thread.sleep(4000);
			product.clickOnProduct();
			Thread.sleep(3000);

			logger.info("Product was clicked");

			Thread.sleep(3000);
			String actualResult = driver.getTitle();
			extentTest.log(LogStatus.INFO, actualResult);
			Assert.assertEquals(actualResult, expectedResult);

			extentTest.log(LogStatus.INFO, "Clicking Functionality is working properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}
	}

	// ______Testcase for Checking Add To Cart Functionality_____
	@Test(groups = { "ProductPage" }, priority = 1, enabled = true)
	public void addToCart() throws InterruptedException {
		String testName = "whenUserClickOnAddToCart";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying that User is able to add the product into the cart");

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

			ProductPage product = new ProductPage(driver);
			Thread.sleep(4000);
			product.clickOnProduct();
			product.addProductIntoCart();
			Thread.sleep(2000);

			logger.info("Add to Cart Button was clicked");

			Thread.sleep(3000);
			String actualResult = driver.getTitle();
			extentTest.log(LogStatus.INFO, actualResult);
			Assert.assertEquals(actualResult, expectedResult);

			extentTest.log(LogStatus.INFO, "Add To Cart Functionality is working properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}
	}

	// ______Testcase for Checking Save for later Functionality_____
	@Test(groups = { "ProductPage" }, priority = 1, enabled = true)
	public void saveForLaterItemFromCart() throws InterruptedException {
		String testName = "whenUserClickToSaveForLater";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying that User is able to move the product into Save For Later");

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

			ProductPage product = new ProductPage(driver);
			Thread.sleep(4000);
			product.clickOnProduct();
			product.addProductIntoCart();
			Thread.sleep(2000);
			product.saveForLaterProductfromCart();

			logger.info("Save for later Button was clicked");

			Thread.sleep(5000);

			String actualResult = product.saveforLaterMessage.getText();
			extentTest.log(LogStatus.INFO, actualResult);
			Assert.assertEquals(actualResult, expectedResult);

			extentTest.log(LogStatus.INFO, "Save For Later functionality is working properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}

	}

	// ______Testcase for Checking Remove Items from cart Functionality_____
	@Test(groups = { "ProductPage" }, priority = 1, enabled = true)
	public void removeItemFromCart() throws InterruptedException {
		String testName = "whenUserClickToRemoveItemFromCart";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying that User is able to remove product from the cart");

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

			ProductPage product = new ProductPage(driver);
			Thread.sleep(4000);
			product.clickOnProduct();
			Thread.sleep(3000);
			product.addProductIntoCart();
			Thread.sleep(2000);
			product.removeProductFromCart();
			Thread.sleep(3000);

			logger.info("Remove Button was clicked");

			Thread.sleep(4000);
			String actualResult = product.emptyCartMessage.getText();
			Thread.sleep(3000);
			extentTest.log(LogStatus.INFO, actualResult);
			Assert.assertEquals(actualResult, expectedResult);

			extentTest.log(LogStatus.INFO, "User is able to Remove the Product from the cart properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}

	}

	// ______Testcase for Checking Ask Expert Functionality_____
	@Test(groups = { "ProductPage" }, priority = 1, enabled = true)
	public void clickOnAskExpertButton() throws InterruptedException {
		String testName = "whenUserClickOnAskExpertButton";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying that User is able to access the Ask Expert Functionality");

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
			Thread.sleep(3000);

			ProductPage product = new ProductPage(driver);
			Thread.sleep(3000);
			product.clickOnProduct();
			product.switchWindow();
			product.clickOnAskExpertButton();
			Thread.sleep(5000);

			logger.info("Ask Expert Button was clicked");

			Thread.sleep(3000);
			String actualResult = driver.getTitle();
			extentTest.log(LogStatus.INFO, actualResult);
			Assert.assertEquals(actualResult, expectedResult);

			extentTest.log(LogStatus.INFO, "Ask Expert Functionality is working properly");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}

	}

	// ______Testcase for Checking Changing Size of the Product Functionality_____
	@Test(groups = { "ProductPage" }, priority = 1, enabled = true)
	public void changeProductSize() throws InterruptedException {
		String testName = "whenUserClickOnChangeSizeFilter";
		String title = "";

		try {
			extentTest = extent.startTest("Verifying that User is able to filter products by their size");

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

			ProductPage product = new ProductPage(driver);
			Thread.sleep(4000);

			product.clickOnScreenSizeButton(productName);
			Thread.sleep(5000);

			logger.info("Size Button was clicked");

			Thread.sleep(3000);
			String actualResult = product.clearAllButton.getText();
			extentTest.log(LogStatus.INFO, actualResult);
			Assert.assertEquals(actualResult, expectedResult);

			extentTest.log(LogStatus.INFO, "Product Filter by their size done successfully");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, title);
			extent.endTest(extentTest);

		}

	}

}
