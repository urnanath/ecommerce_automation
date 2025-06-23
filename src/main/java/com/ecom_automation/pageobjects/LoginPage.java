package com.ecom_automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	


	@FindBy(id = "email")
	private WebElement emailEntry;
	
	@FindBy(id = "pass")
	private WebElement passwordEntry;
	
	@FindBy(name = "send")
	private WebElement signInButton;
	
	@FindBy(className = "logged-in")
	private WebElement verification;
	
	@FindBy(className = "message-error")
	private WebElement warning;
	
	public WebElement loginWithValidCredentials()
	{
		emailEntry.sendKeys("janedoe1234@gmail.com");
		passwordEntry.sendKeys("jane@123");

		signInButton.click();
		return verification;
	}
	
	public String loginWithInvalidCredentials()
	{
		emailEntry.sendKeys("janedoe12@gmail.com");
		passwordEntry.sendKeys("jane@1");
		
		signInButton.click();
		return warning.getText()
;	}
	
}
