package com.selenium.flipkart_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	public WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//Locators
	
	//________Logout________
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	public WebElement profileButton;
	
	@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[10]/a[1]")
	public WebElement logoutButton;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[5]/button[1]")
	public WebElement closeLogin;
	
	@FindBy(how = How.CLASS_NAME, using = "_14Me7y")
	public WebElement logoutMessage;

	
	public void clickProfile() {
	
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();

		}
		public void clickLogout() throws InterruptedException {
			Thread.sleep(5000);
			logoutButton.click();
		}

}
