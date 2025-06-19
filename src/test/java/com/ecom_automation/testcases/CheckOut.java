package com.ecom_automation.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
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
		addToCartPage.clickOnProductItem();
		addToCartPage.selectProductSize();
		addToCartPage.selectProductColor();
		addToCartPage.clearProductQty();
		addToCartPage.selectProductQty();
		addToCartPage.clickOnAddToCartButton();

		

		Thread.sleep(2000);
		
    	HomePage homePage = new HomePage(driver);
    	homePage.clickOnShowCartOption();
    	Thread.sleep(1000);
    	homePage.clickOnProceedToCheckOutButton();
    	Thread.sleep(2000);
    	CheckOutPage checkOutPage = new CheckOutPage(driver);
    	
    	checkOutPage.enterEmail();
    	checkOutPage.enterFirstName();
    	checkOutPage.enterLastName();
    	Select country = new Select(driver.findElement(By.name("country_id")));
    	country.selectByContainsVisibleText("India");
    	
    	Select state = new Select(driver.findElement(By.name("region_id")));
    	state.selectByContainsVisibleText("West Bengal");
    	checkOutPage.enterAddress();
    	checkOutPage.enterCity();
    	checkOutPage.enterPinCoode();
    	checkOutPage.enterPhNumber();
    	checkOutPage.clickOnRadioButton();

    	checkOutPage.clickOnNextButton();
    	
    	Thread.sleep(3000);
    	checkOutPage.clickOnPlaceOrderButton();
    	
    	
    }
	
    
	
	
	
}
