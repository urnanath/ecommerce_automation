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
	
	public void enterValidEmail() 
	{
		emailEntry.sendKeys("janedoe1234@gmail.com");
	}
	public void enterValidPassword()
	{
		passwordEntry.sendKeys("jane@123");
	}
	public void enterInvalidEmail() 
	{
		emailEntry.sendKeys("janedoe12@gmail.com");
	}
	public void enterInvalidPassword()
	{
		passwordEntry.sendKeys("jane@1");
	}
	public void clickOnSignInButton() 
	{
		signInButton.click();
	}
}
