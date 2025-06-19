package com.ecom_automation.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom_automation.base.Base;
import com.ecom_automation.pageobjects.AddToCartPage;


public class AddToCart extends Base{
 
	static WebDriver driver;
	
	@BeforeMethod
	public void setUp() 
	{
		driver = initializeBrowserAndOpenApplication();
	}
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
	
	
	@Test
	public static void addProductToCart()
	{
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		addToCartPage.clickOnProductItem();
		addToCartPage.selectProductSize();
		addToCartPage.selectProductColor();
		addToCartPage.clearProductQty();
		addToCartPage.selectProductQty();
		addToCartPage.clickOnAddToCartButton();
		
	}
}
