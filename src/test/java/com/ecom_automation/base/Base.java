package com.ecom_automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecom_automation.pageobjects.AddToCartPage;



public class Base {
	 WebDriver driver;

	
	 public WebDriver initializeBrowserAndOpenApplication()
	 {
		 
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  driver.get("https://magento.softwaretestingboard.com/?ref=hackernoon.com");
		  
		  return driver;
	 }

	 
	 
	 
}
