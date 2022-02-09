package com.selenium.flipkart_automation.pages;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public WebDriver driver;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Locators

	// _________Add To Cart_______

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")
	public WebElement cartButton;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]")
	public WebElement removeButton;

	// ________Add To Compare_______

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/a[1]/span[1]")
	public WebElement compareButton;
	
	@FindBy(how = How.CLASS_NAME, using = "_1hpezz")
	public WebElement checkboxShowDiffrence;

	// ________Ask Expert_________

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/button[1]")
	public WebElement chatWithExpertButton;

    //______Filter Product By its Size________
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[5]/div[1]/*[name()='svg'][1]")
	public WebElement screenSizeButton;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[5]/div[2]/div[1]/div[2]/div[1]/label[1]/div[1]")
	public WebElement thirtyNineToFourtyThreeInch;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[5]/div[2]/div[1]/div[3]/div[1]/label[1]/div[1]")
	public WebElement twentyEightToThirtyTwoInch;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[5]/div[2]/div[1]/div[4]/div[1]/label[1]/div[1]")
	public WebElement fourtyEightToFiftyFiveInch;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/span[1]")
	public WebElement clearAllButton;

	// ________Searching________

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")
	public WebElement navigateToSearchBox;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]/*[name()='svg'][1]")
	public WebElement searchIcon;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/button[1]")
	public WebElement closeLogin;
	
	//________SAve For Later________
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]")
	public WebElement saveforLaterButton;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
	public WebElement saveforLaterMessage;
	
	@FindBy(how = How.CLASS_NAME, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
	public WebElement scrollDown;
	
	//_____Remove Items_________
	
	@FindBy(how = How.CLASS_NAME, using = "_1LCJ1U")
	public WebElement emptyCartMessage;
	
	

	public void clickOnProduct() throws InterruptedException {

		List<WebElement> list = driver.findElements(By.className("_4rR01T"));
		list.get(list.size() - 1).click();
	}

	public void addProductIntoCart() throws InterruptedException {

		String currentHandle = driver.getWindowHandle();
		Set<String> handleSet = driver.getWindowHandles();
		for (String handle : handleSet) {
			if (!handle.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		cartButton.click();
		Thread.sleep(3000);
	}

	public void scrollScreen() throws InterruptedException {
		Thread.sleep(3000);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(scrollDown).perform();
	}
	public void saveForLaterProductfromCart() throws InterruptedException {
		List<WebElement> saveForLaterBtnList = driver.findElements(By.className("_3dsJAO"));
		Thread.sleep(3000);
		saveForLaterBtnList.get(saveForLaterBtnList.size() - 2).click();
		Thread.sleep(2000);
	}

	public void removeProductFromCart() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> RemoveBtnList = driver.findElements(By.className("_3dsJAO"));
		Thread.sleep(3000);
		RemoveBtnList.get(RemoveBtnList.size() - 1).click();
		Thread.sleep(3000);
		removeButton.click();
	}

	public void addToCompare() throws InterruptedException {
		List<WebElement> list = driver.findElements(By.className("_24_Dny"));
		Thread.sleep(2000);
		list.get(list.size() - 1).click();
		Thread.sleep(2000);
		list.get(list.size() - 2).click();
		Thread.sleep(2000);
		compareButton.click();
		Thread.sleep(3000);
	}

	public void switchWindow() throws InterruptedException {
		String currentHandle = driver.getWindowHandle();
		Set<String> handleSet = driver.getWindowHandles();
		for (String handle : handleSet) {
			if (!handle.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		Thread.sleep(3000);
	}

	public void clickOnAskExpertButton() throws InterruptedException {
		chatWithExpertButton.click();
		Thread.sleep(3000);
	}

	public void clickOnScreenSizeButton(String productName) throws InterruptedException {
		Thread.sleep(2000);
		navigateToSearchBox.sendKeys(productName);
		searchIcon.click();
		Thread.sleep(3000);
	
		screenSizeButton.click();
		Thread.sleep(3000);
		Actions mov = new Actions(driver);
		Action action = (Action) mov.dragAndDropBy(fourtyEightToFiftyFiveInch, 30, 0).build();
		action.perform();
		
		Thread.sleep(3000);
		twentyEightToThirtyTwoInch.click();
		Thread.sleep(3000);
	}

}
