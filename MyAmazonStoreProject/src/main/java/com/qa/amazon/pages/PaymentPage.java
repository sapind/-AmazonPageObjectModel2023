package com.qa.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.AmazonTestBase;

public class PaymentPage  extends AmazonTestBase{
	@FindBy(id="shipToThisAddressButton")
	WebElement confirmAddressBtn;
	
	
	public PaymentPage()
	{
		PageFactory.initElements(driver, this);
	
	}
	public void clickOnShippingAddress()
	{
		confirmAddressBtn.click();
	}

}
