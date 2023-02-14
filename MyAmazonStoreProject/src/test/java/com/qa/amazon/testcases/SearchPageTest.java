package com.qa.amazon.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.amazon.base.AmazonTestBase;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.LoginPage;
import com.qa.amazon.pages.SearchPage;

public class SearchPageTest extends AmazonTestBase {
	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	
	
	public SearchPageTest()
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
		
	
	}
	@Test(priority=1)
	public void searchField()
	{
		boolean flag=searchPage.verifySearchField();
		Assert.assertTrue(flag);
	}
	@Test(priority=2)
	public void verifySearchItem()
	{
		
		
		searchPage.getVerifySearchItem();
		
			Assert.assertTrue(true);
			
		}
	@Test(priority=3)
	public void clickOnSelectItemTest()
	{
	searchPage.clickOnSelectItem();	
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}



