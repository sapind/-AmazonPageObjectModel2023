package com.qa.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.AmazonTestBase;

public class HomePage extends AmazonTestBase {
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	@CacheLookup
	WebElement textBox;
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	@CacheLookup
	WebElement searchBtn;
	@FindBy(xpath="//a[@aria-label='Amazon.ca']")
	@CacheLookup
	WebElement homeLogolink;
	@FindBy(xpath="//span[@id='nav-global-location-data-modal-action']")
	@CacheLookup
	WebElement addresslink;
    @FindBy(xpath="//a[@id='nav-link-accountList']")
    @CacheLookup
    WebElement accountList;
    @FindBy(xpath="//a[@id='nav-orders']")
    @CacheLookup
    WebElement returnOrder;
    @FindBy(xpath="//div[@id='nav-cart-text-container']")
    WebElement cart;
   
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String validateHomePageTitle()
	
	{
		return driver.getTitle();
		
	}
	
	public boolean validatesearchbox(){
		return textBox.isDisplayed();
		
	}
	public boolean validateSearchBtn() {
		return searchBtn.isDisplayed();
		
	}
	public boolean validateAddressLink()
	{
		return addresslink.isDisplayed();
		
	}
	public boolean validateHomePageLogo()
	{
		return homeLogolink.isDisplayed();
		
	}
	public boolean validateAccountList()
	{
		return accountList.isDisplayed();
		
	}
	public boolean validateReturnOrder()
	{
		return returnOrder.isDisplayed();
		
	}
	public boolean validateCart()
	{
		return cart.isDisplayed();
		 
	}
	public void clickOnSearchTextBox()
	{
		Actions action=new Actions(driver);
		action.moveToElement(textBox).build().perform();
		
	}
	public void enterItemName(String itemName)
	{
		textBox.sendKeys(itemName);
	}
	public void clickOnsearchBtn()
	{
		searchBtn.click();
	}
	public void clickOnAccountListLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(accountList).build().perform();
		accountList.click();
	}
	
	
	
	
	
	
	
	
	
	

	
}
