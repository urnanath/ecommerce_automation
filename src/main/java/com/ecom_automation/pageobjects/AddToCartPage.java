package com.ecom_automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	WebDriver driver;
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "product-item")
	WebElement productItem;
	
	@FindBy(id = "option-label-size-143-item-166")
	WebElement productSize;
	
	@FindBy(id = "option-label-color-93-item-57")
	WebElement productColor;
	
	@FindBy(id = "qty")
	WebElement productQty;
	

	@FindBy(id = "product-addtocart-button")
	WebElement addToCartButton;
	
	public void addProductToCart() 
	{
		productItem.click();
		productSize.click();
		productColor.click();
		productQty.clear();
		productQty.sendKeys("2");
		addToCartButton.click();
	}
	
	
	
}

