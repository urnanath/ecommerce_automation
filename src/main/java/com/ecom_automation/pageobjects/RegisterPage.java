package com.ecom_automation.pageobjects;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegisterPage {

	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "firstname")
	private WebElement firstName;
	
	@FindBy(id = "lastname")
	private WebElement lastName;
	
	@FindBy(name = "email")
	private WebElement email;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "password-confirmation")
	private WebElement passwordConfirmation;
	
	@FindBy(className = "primary")
	private WebElement registerButton;
	

	
	@FindBy(className = "messages")
	private WebElement message;
	
	public String registerWithRightCredentials() 
	{
		firstName.sendKeys("Bob");
		lastName.sendKeys("Deol");
		email.sendKeys(generateEmailWithTimestamp());
		password.sendKeys("bob@1234");
		passwordConfirmation.sendKeys("bob@1234");
		registerButton.click();
		
		return message.getText();
	}
	
	public String registerWithExistingCredentials() 
	{
		firstName.sendKeys("Bob");
		lastName.sendKeys("Deol");
		email.sendKeys("janedoe1234@gmail.com");
		password.sendKeys("bob@1234");
		passwordConfirmation.sendKeys("bob@1234");
		registerButton.click();
		
		return message.getText();
	}
	
	
	
	public static String generateEmailWithTimestamp() 
	  {
		  Date date = new Date();
		  String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		  return "bob" + timestamp + "@gmail.com";
	  }
	
}
