package com.selenium.flipkart_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	//Locators
		
	//________Login________
		
	@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	public WebElement enterValidMobileeNumber;
	
	@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")
	public WebElement enterValidPassword;
	
	@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")
	public WebElement loginButton;
	
	@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/span[3]/span[1]")
	public WebElement errorMessage;
	
	public void userLogin(String phoneNumber, String password) {
		enterValidMobileeNumber.sendKeys(phoneNumber);
		enterValidPassword.sendKeys(password);
		loginButton.click();
		
	}
}


