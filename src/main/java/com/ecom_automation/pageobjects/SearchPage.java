package com.ecom_automation.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	public SearchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "q")
	private WebElement searchBar;
	
	
	public void enterExistingProductNameInSearchBar() {
		searchBar.sendKeys("Radiant Tee");
	}
	public void enterNonExistingProductNameInSearchBar() {
		searchBar.sendKeys("honda");
	}
	public void pressEnter()
	{
		searchBar.sendKeys(Keys.ENTER);
	}
}
	
