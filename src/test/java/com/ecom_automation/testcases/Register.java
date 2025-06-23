package com.ecom_automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom_automation.base.Base;
import com.ecom_automation.pageobjects.HomePage;
import com.ecom_automation.pageobjects.RegisterPage;

public class Register extends Base {
	WebDriver driver;

	 @BeforeMethod
	  public void setUp() {
		 driver = initializeBrowserAndOpenApplication();
		 HomePage homePage = new HomePage(driver);
		 homePage.clickOnRegisterOption();
		 
	  }

	 @AfterMethod
	  public void tearDown() 
	  {
		driver.quit();	
	  }
	 
	  @Test(priority=1)
	  public void verifyRegisterWithAllFields()
	  {
		  RegisterPage registerPage = new RegisterPage(driver);
		  registerPage.registerWithRightCredentials();
		  String actualSuccessMessage = driver.findElement(By.className("messages")).getText();
		  Assert.assertEquals(actualSuccessMessage,"Thank you for registering with Main Website Store.");
	  }
	  
	  @Test(priority=2)
	  public void verifyRegisterWithExistingEmail()
	  {
		  RegisterPage registerPage = new RegisterPage(driver);
		  
		  registerPage.registerWithExistingCredentials();
		  
		  
		  String actualWarningMessage = driver.findElement(By.className("messages")).getText();
		  Assert.assertEquals(actualWarningMessage,"There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
	  }
	  
	  
	  
	  
	  //register with no fields
	  //password less than 8 characters
	  //password and confirm password does not match

}
