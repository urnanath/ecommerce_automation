package com.ecom_automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom_automation.base.Base;
import com.ecom_automation.pageobjects.HomePage;
import com.ecom_automation.pageobjects.SearchPage;

public class Search extends Base {
	WebDriver driver;
	
	
	@BeforeMethod
	  public void setUp() {
		 driver = initializeBrowserAndOpenApplication();
		 
	}
	
	@AfterMethod
	  public void tearDown() 
	  {
		driver.quit();	
	  }
	 @Test(priority=1)
	  public void verifySearchWithValidProductName()
	  {
		 SearchPage searchPage = new SearchPage(driver);
		 WebElement product = searchPage.enterExistingProductNameInSearchBar();
	
		 Assert.assertTrue(product.isDisplayed());
	  
	  }
	 
	 @Test(priority=2)
	  public void verifySearchWithInalidProductName()
	  {
		 SearchPage searchPage = new SearchPage(driver);
		 searchPage.enterNonExistingProductNameInSearchBar();

		 String actualNoticeMessage = driver.findElement(By.className("notice")).getText();
		 Assert.assertEquals(actualNoticeMessage, "Your search returned no results.");
	  
	  }
}
