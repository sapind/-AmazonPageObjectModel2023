package com.qa.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.AmazonTestBase;

public class LoginPage extends AmazonTestBase {
	// @page factory
	@FindBy(xpath="//i[@aria-label='Amazon']")
	@CacheLookup
	WebElement amazonLogo;
	@FindBy(name="email")
	@CacheLookup
	WebElement emailText;
	@FindBy(id="continue")
	@CacheLookup
	WebElement continueBtn;
	@FindBy(id="ap_password")
	@CacheLookup
	WebElement passwordText;
	@FindBy(id="auth-signin-button")
	@CacheLookup
	WebElement signBtn;
	@FindBy(xpath="//a[@id='createAccountSubmit']")
	@CacheLookup
	WebElement createAccountBtn;
	
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean validateAmazonLogo()
	{
		return amazonLogo.isDisplayed();
		
	}
	
	 public CreateNewAccountPage clickOnCreateNewAccountBtn()
	  	{
		 createAccountBtn.click();
	  		return new CreateNewAccountPage();
	  	}
    public String validateLoginPageTitle()
	{
		return driver.getTitle();	
	}
    public HomePage Login(String email, String pwd)
    
    {
    	emailText.sendKeys(email);
    	continueBtn.click();
    	passwordText.sendKeys(pwd);
    	signBtn.click();
    	
		return new HomePage();
    }
		
    	
    }
	
	
