package com.selenium.flipkart_automation.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

//Locators

//________Searching________

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")
	public WebElement navigateToSearchBox;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]/*[name()='svg'][1]")
	public WebElement searchIcon;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/button[1]")
	public WebElement closeLogin;

//___________Sorting________

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]")
	public WebElement sortByRelavance;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]")
	public WebElement sortByPopularity;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]")
	public WebElement sortByPrice_LowToHigh;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[4]")
	public WebElement sortByPrice_HighToLow;

	// _________Go Back To Home_______

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/img[1]")
	public WebElement clickOnLogoButton;

	// ________Wish List_______

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[5]/a[1]")
	public WebElement checkWishlist;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	public WebElement profileButton;

	// _________Customer Rating Filter_______

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[5]/div[2]/div[1]/div[1]/div[1]/label[1]/div[1]")
	public WebElement fourStarAndAbove;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[5]/div[2]/div[1]/div[2]/div[1]/label[1]/div[1]")
	public WebElement threeStarAndAbove;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[5]/div[2]/div[1]/div[3]/div[1]/label[1]/div[1]")
	public WebElement twoStarAndAbove;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[5]/div[2]/div[1]/div[4]/div[1]/label[1]/div[1]")
	public WebElement oneStarAndAbove;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[5]/div[2]/div[1]/div[4]/div[1]/label[1]/div[1]")
	public WebElement item;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[2]")
	public WebElement afterFilter;

	// _________Rating & Reviews__________

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[6]/div[2]/div[1]/div[1]/div[1]/label[1]/div[1]")
	public WebElement offerButton;
	
	@FindBy(how = How.CLASS_NAME, using = "_3LWZlK")
	public WebElement scrollBar;
	

	// Back To Top Move_________
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/span[1]")
	public WebElement backToTop;
	
	//_____Move to Next Page_____

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[42]/div[1]/div[1]/nav[1]/a[1]")
	public WebElement pageOneButton;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[42]/div[1]/div[1]/nav[1]/a[2]")
	public WebElement pageTwoButton;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[42]/div[1]/div[1]/nav[1]/a[3]")
	public WebElement pageThreeButton;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[42]/div[1]/div[1]/nav[1]/a[4]")
	public WebElement pageFourButton;
	
	@FindBy(how = How.CLASS_NAME, using = "_2IfVM8")
	public WebElement message;
	
	@FindBy(how = How.CLASS_NAME, using = "_1LKTO3")
	public WebElement previousButton;
	
	//_____Filter By CUstomer Ratings_______
	
	@FindBy(how = How.CLASS_NAME, using = "HbxufK")
	public WebElement filterRatingMessage;
	
	
	

	public void searchProduct(String productName) throws InterruptedException {
		Thread.sleep(7000);
		navigateToSearchBox.sendKeys(productName);
		Thread.sleep(3000);
		searchIcon.click();
		Thread.sleep(3000);
	}

	public void sortProduct(String productName) throws InterruptedException {
		navigateToSearchBox.sendKeys(productName);
		Thread.sleep(2000);
		searchIcon.click();
	
		Thread.sleep(3000);
		sortByPrice_HighToLow.click();
	}

	public void goBackToHome() {
		clickOnLogoButton.click();
	}
	
	
	public void addProductIntoWishlist() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.className("_36FSn5"));
		list.get(list.size() - 1).click();
		Thread.sleep(6000);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		Thread.sleep(7000);
		checkWishlist.click();

	}

	public void setProductByCustomerRatings() throws InterruptedException {
		fourStarAndAbove.click();
		Thread.sleep(5000);
		twoStarAndAbove.click();
		Thread.sleep(5000);
		Actions mov = new Actions(driver);
		Action action = (Action) mov.dragAndDropBy(item, 30, 0).build();
		action.perform();
		Thread.sleep(3000);
	}

	public void hoverOnReviewIcon() throws InterruptedException {

		List<WebElement> reviewIcon = driver.findElements(By.className("_3LWZlK"));
		for (WebElement reviewButton : reviewIcon) {
			Thread.sleep(3000);
			Actions mov = new Actions(driver);
			Action action = (Action) mov.dragAndDropBy(offerButton, 30, 0).build();
			action.perform();
			Thread.sleep(2000);
			Actions actionProvider = new Actions(driver);
			actionProvider.moveToElement(reviewButton).perform();
			Thread.sleep(3000);
			break;
		}

	}

	public void clickBAckToTop() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions mov = new Actions(driver);
		Action action = (Action) mov.dragAndDropBy(pageOneButton, 30, 0).build();
		action.perform();
		Thread.sleep(3000);
		backToTop.click();
		Thread.sleep(2000);
	}

	public void clickToNextPage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions mov = new Actions(driver);
		Action action = (Action) mov.dragAndDropBy(pageOneButton, 30, 0).build();
		action.perform();
		Thread.sleep(4000);
		pageTwoButton.click();
		Thread.sleep(3000);
		action.perform();
		Thread.sleep(3000);
	}



}
