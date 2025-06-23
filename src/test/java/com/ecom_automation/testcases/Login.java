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
import com.ecom_automation.pageobjects.LoginPage;

public class Login extends Base{
	
  WebDriver driver;
  
  @BeforeMethod
  public void setUp() {
	  driver = initializeBrowserAndOpenApplication();
	  HomePage homePage = new HomePage(driver);
	  homePage.clickOnSignInOption();
	  
	  
  }
  
  @AfterMethod
  public void tearDown() 
  {
	driver.quit();	
  }

  @Test(priority=1)
  public void verifyLoginWithValidCredentials()
  {
	  LoginPage loginPage = new LoginPage(driver);  
	  WebElement verify = loginPage.loginWithValidCredentials();
	  Assert.assertTrue(verify.isDisplayed());

  }
  
  @Test(priority=2)
  public void verifyLoginWithInalidCredentials()
  {
	  LoginPage loginPage = new LoginPage(driver);  
	  String actualWarningMsg = loginPage.loginWithInvalidCredentials();
	  Assert.assertEquals(actualWarningMsg, "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
	  

  }
}
