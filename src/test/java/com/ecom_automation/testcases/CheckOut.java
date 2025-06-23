package com.ecom_automation.testcases;


import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom_automation.base.Base;
import com.ecom_automation.pageobjects.AddToCartPage;
import com.ecom_automation.pageobjects.CheckOutPage;
import com.ecom_automation.pageobjects.HomePage;

public class CheckOut extends Base {

    WebDriver driver;
	
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
	
	@Test(priority=2)
    public void clickOnEmptyCart() {
    	HomePage homePage = new HomePage(driver);
    	homePage.clickOnShowCartOption();
    	String emptyCartMsg = homePage.showEmptyCartMsg();
    	Assert.assertEquals(emptyCartMsg, "You have no items in your shopping cart.");
    	
    }
	@Test(priority = 1)
	public void clickOnFullCartAndCheckOutWithOutSigningIn() throws InterruptedException {
		
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		addToCartPage.addProductToCart();


		Thread.sleep(2000);
		
    	HomePage homePage = new HomePage(driver);
    	homePage.clickOnShowCartOption();
    	Thread.sleep(1000);
    	homePage.clickOnProceedToCheckOutButton();
    	Thread.sleep(2000);
    	CheckOutPage checkOutPage = new CheckOutPage(driver);
    	
    	checkOutPage.checkOut();
    	
    	
    }
	
    
	
	
	
}
