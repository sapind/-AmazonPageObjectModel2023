package com.qa.amazon.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.amazon.base.AmazonTestBase;
import com.qa.amazon.pages.CreateNewAccountPage;
//import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.LoginPage;
import com.qa.amazon.util.AmazonTestUtil;

public class CreateNewAccountPageTest extends AmazonTestBase{
	
	LoginPage loginPage;
	AmazonTestUtil amazonTestUtil;
	//HomePage homePage;
	CreateNewAccountPage createNewAcoountPage;
	//String sheetName="newaccount";
	
	
	
	public CreateNewAccountPageTest()
	{
		super();
		
	}
	@BeforeMethod
	public void setUp()
	{
		initialization();
		
		loginPage=new LoginPage();
		amazonTestUtil=new AmazonTestUtil();
		//homePage=loginPage.Login(prop.getProperty("email"),prop.getProperty("password"));
		createNewAcoountPage=loginPage.clickOnCreateNewAccountBtn();
		
	}
	@Test(priority=1)
	public void validateRegistrationPageTitle()
	
	{
	String title =createNewAcoountPage.validateRegistrationPageTitle();
	Assert.assertEquals(title, "Amazon Registration");
	}
//	@DataProvider
//	public Object[][] getDataSheetTestData(){
//		Object data[][]=AmazonTestUtil.getTestData(sheetName);
//		return data;
//	}
//	@Test(priority=2, dataProvider="getDataSheetTestData")
//	public void validateCreateNewAccountTest(String flName,String email,String pwd,String checkPwd)
//	{
//		loginPage.clickOnCreateNewAccountBtn();
//		
//	createNewAcoountPage.create(flName, email, pwd, checkPwd);
//	createNewAcoountPage.clickOnVerifyBtn();
//	}
//	
//	
	@Test(priority=2)
	public void create()
	{
		createNewAcoountPage.create("Tom","test@gmail.com","abcdef", "abcdef");
		 
	}
	
    
@Test(priority=3)
      public void clickOnVerifyBtnTest()
     {		
	   createNewAcoountPage.clickOnVerifyBtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	}

