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
	
	@FindBy(linkText = "Radiant Tee")
	private WebElement product;
	
	@FindBy(className = "notice")
	private WebElement notice;
	
	public WebElement enterExistingProductNameInSearchBar() {
		searchBar.sendKeys("Radiant Tee");
		searchBar.sendKeys(Keys.ENTER);
		
		return product;
	}
	public String enterNonExistingProductNameInSearchBar() {
		searchBar.sendKeys("honda");
		searchBar.sendKeys(Keys.ENTER);
		
		return notice.getText();
	}
	
}
	
