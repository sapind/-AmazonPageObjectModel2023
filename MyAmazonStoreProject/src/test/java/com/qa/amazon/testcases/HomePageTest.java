package com.qa.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.qa.amazon.base.AmazonTestBase;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.LoginPage;


public class HomePageTest extends AmazonTestBase{
	LoginPage loginPage;
	HomePage homePage;
	public HomePageTest()
	{
		super();
		
	}
	@BeforeMethod
	public void Setup()
	{
		initialization();
		
		loginPage=new LoginPage();
		homePage=loginPage.Login(prop.getProperty("email"),prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitle()
	{
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle,  "Your Account","Home page title not matched");	
		
	}
	
	@Test(priority=2)
	public void validatesearchboxTest() {
		
		boolean flag = homePage.validatesearchbox();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void validateSearchBtnTest()
	{
		boolean flag=homePage.validateSearchBtn();
		Assert.assertTrue(flag);
	}
	@Test(priority=4)
	public void validateaccountListTest()
	{
		boolean flag=homePage.validateAccountList();
		Assert.assertTrue(flag);
	}
	@Test(priority=5)
	public void validateReturnOrderTest()
	{
		boolean flag=homePage.validateReturnOrder();
		Assert.assertTrue(flag);
	}
	@Test(priority=6)
	public void validateCartTest()
	{
		boolean flag=homePage.validateCart();
		Assert.assertTrue(flag);
	}
	@Test(priority=7)
	public void validateAddressLinkTest()
	{
		boolean flag=homePage.validateAddressLink();
		Assert.assertTrue(flag);
	}
	@Test(priority=8)
	public void verifySearchTextBoxTest()
	{
		
		homePage.clickOnSearchTextBox();
	}
	@Test(priority=9)
	public void searchItemTest()
	{
		
		homePage.enterItemName("Book");
		homePage.clickOnsearchBtn();
	}
	@Test(priority=10)
	public void clickOnAccountListTest()
	{
		homePage.clickOnAccountListLink();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
