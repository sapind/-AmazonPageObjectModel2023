package com.qa.amazon.pages;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.amazon.base.AmazonTestBase;

public class CreateNewAccountPage extends AmazonTestBase {
	
	@FindBy(name="customerName")
	WebElement firstLastName;
	@FindBy(name="email")
	WebElement enterEmail;
	@FindBy(name="password")
	WebElement enterPassword;
	@FindBy(name="passwordCheck")
	WebElement checkPassword;
	@FindBy(xpath="//input[@id='continue']")
	WebElement verifyBtn;
	 public CreateNewAccountPage()
     {
   	 
		PageFactory.initElements(driver,this); 
		
	}
	 public String validateRegistrationPageTitle()
	 {
		 return driver.getTitle();
	 }
	
 public void create(String flName,String email,String pwd,String checkPwd)
	 {
	 
	
	firstLastName.sendKeys(flName);
		enterEmail.sendKeys(email);
		enterPassword.sendKeys(pwd);
		checkPassword.sendKeys(checkPwd);
		
		
	 }
 public void clickOnVerifyBtn()
{
	 verifyBtn.click();
     

	}

	
}
 
	 
 


