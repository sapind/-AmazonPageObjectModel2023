package com.qa.amazon.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.amazon.base.AmazonTestBase;
import com.qa.amazon.pages.AddItemToCartPage;

import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.LoginPage;
import com.qa.amazon.pages.PaymentPage;
import com.qa.amazon.pages.SearchPage;

public class PaymentPageTest extends AmazonTestBase {
	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	AddItemToCartPage addItemToCartPage;
	
	PaymentPage paymentPage;
	
	public PaymentPageTest()
	{
		super();
	}
	@BeforeMethod
	public void Setup()
	{
		initialization();
		
		loginPage=new LoginPage();
		homePage=loginPage.Login(prop.getProperty("email"),prop.getProperty("password"));
	    homePage.clickOnSearchTextBox();
	    
		homePage.enterItemName("Book");
		homePage.clickOnsearchBtn();
		
		searchPage=new SearchPage();
		searchPage.clickOnSelectItem();
		addItemToCartPage=new AddItemToCartPage();
		addItemToCartPage.clickOnAddToCart();
		addItemToCartPage.clickOnProceed();
		paymentPage=new PaymentPage();
		
	}
	@Test(priority=1)
	public void confirmAddressTest()
	{
		paymentPage.clickOnShippingAddress();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
