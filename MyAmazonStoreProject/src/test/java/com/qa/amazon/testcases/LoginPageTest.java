package com.qa.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.qa.amazon.base.AmazonTestBase;
import com.qa.amazon.pages.CreateNewAccountPage;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.LoginPage;


public class LoginPageTest extends AmazonTestBase {
	LoginPage loginPage;
	CreateNewAccountPage createNewAcoountPage;
	HomePage homePage;
	public LoginPageTest()
	{
		super();
		
	}
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage= new LoginPage();
		
	}
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title =loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Amazon Sign In");
	}
	@Test(priority=2)
	public void AmazonLogoTest()
	{
		boolean flag=loginPage.validateAmazonLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest()
	{
		homePage=loginPage.Login(prop.getProperty("email"),prop.getProperty("password"));
	}
	
	@Test(priority=4)
	public void verifyCreateNewAccountTest()
	{
		createNewAcoountPage=loginPage.clickOnCreateNewAccountBtn();
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
