package com.ecom_automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(linkText="Sign In")
	private WebElement signInOption;
	
	@FindBy(linkText="Create an Account")
	private WebElement registerOption;
	
	@FindBy(className = "showcart")
	private WebElement showCart;
	
	@FindBy(className = "subtitle")
	private WebElement noItemsInCartMsg;
	
	@FindBy(id = "top-cart-btn-checkout")
	private WebElement proceedToCheckOutButton;
	
	
	
	
	
	public void clickOnSignInOption()
	{
		signInOption.click();
	}
	public void clickOnRegisterOption()
	{
		registerOption.click();
	}
	
	public void clickOnShowCartOption()
	{
		showCart.click();
	}
	
	public String showEmptyCartMsg() {
		return noItemsInCartMsg.getText();
	}
	
	public void clickOnProceedToCheckOutButton()
	{
		proceedToCheckOutButton.click();
	}
}
