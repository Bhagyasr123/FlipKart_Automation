package com.selenium.flipkart_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductOrderPage {
	public WebDriver driver;

	public ProductOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Locators

	// _________Order Page_______

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	public WebElement profileButton;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[4]/a[1]")
	public WebElement orderButton;
	
	@FindBy(how = How.CLASS_NAME, using = "_3FlDIa")
	public WebElement clearAllButton;
	
	//_______Order Status_________
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/label[1]/div[1]")
	public WebElement onTheWay;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[4]/label[1]/div[1]")
	public WebElement cancelled;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[5]/label[1]/div[1]")
	public WebElement retured;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[3]/label[1]/div[1]")
	public WebElement delivered;
	
	//_______Orders Time_________
	
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/label[1]/div[1]")
		public WebElement lastThirtyDays;
		
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[3]/label[1]/div[1]")
		public WebElement twentyTwenty;
		
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[4]/label[1]/div[1]")
		public WebElement twentyNineteen;
		
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[5]/label[1]/div[1]")
		public WebElement older;

	public void clickOnOrderButton() throws InterruptedException {
		Thread.sleep(3000);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		Thread.sleep(4000);
		orderButton.click();
		Thread.sleep(3000);
	}
	
	public void filterByOrderStatus() throws InterruptedException {
		Thread.sleep(3000);
		cancelled.click();
	}

}
