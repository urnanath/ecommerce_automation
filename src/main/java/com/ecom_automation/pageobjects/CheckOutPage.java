package com.ecom_automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {

WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "customer-email")
	WebElement email;
	
	@FindBy(name = "firstname")
	WebElement firstName;
	
	@FindBy(name = "lastname")
	WebElement lastName;
	
	@FindBy(name = "street[0]")
	WebElement address;
	
	@FindBy(name = "city")
	WebElement city;
	
	@FindBy(name = "postcode")
	WebElement pinCode;
	
	@FindBy(name = "telephone")
	WebElement phNumber;
	
	@FindBy(name = "ko_unique_1")
	WebElement radioButton;
	
	@FindBy(className = "button")
	WebElement nextButton;
	
	@FindBy(className ="checkout")
	WebElement placeOrderButton;
	
	@FindBy(name = "country_id")
	WebElement countryName;
	
	@FindBy(name = "country_id")
	WebElement stateName;
	
	
	public void checkOut() throws InterruptedException {
		email.sendKeys("urnanath123@gmail.com");
		firstName.sendKeys("Urna");
		lastName.sendKeys("Nath");
		address.sendKeys("Barowari Tala,Katwa");
		Select country = new Select(countryName);
    	country.selectByContainsVisibleText("India");
    	
    	Select state = new Select(stateName);
    	state.selectByContainsVisibleText("West Bengal");
		city.sendKeys("Katwa");
		pinCode.sendKeys("713130");
		phNumber.sendKeys("1230456789");
		radioButton.click();
		nextButton.click();
		Thread.sleep(3000);
		placeOrderButton.click();
	}
	
//	public void enterEmail() {
//		email.sendKeys("urnanath123@gmail.com");
//	}
//	public void enterFirstName() {
//		firstName.sendKeys("Urna");
//	}
//	public void enterLastName() {
//		lastName.sendKeys("Nath");
//	}
//	
//	public void enterAddress() {
//		address.sendKeys("Barowari Tala,Katwa");
//	}
//	public void enterCity() {
//		city.sendKeys("Katwa");
//	}
//	public void enterPinCoode() {
//		pinCode.sendKeys("713130");
//	}
//	public void enterPhNumber() {
//		phNumber.sendKeys("1230456789");
//	}
//	public void clickOnRadioButton() {
//		radioButton.click();
//	}
//	public void clickOnNextButton() {
//		nextButton.click();
//	}
//	public void clickOnPlaceOrderButton()
//	{
//	    placeOrderButton.click();
//	}
	
}
