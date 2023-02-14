package com.qa.amazon.pages;


import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

import com.qa.amazon.base.AmazonTestBase;

public class AddItemToCartPage extends AmazonTestBase {
	
	/*@FindBy(xpath="//select[@id='native_dropdown_selected_size_name']")
	WebElement size;
	@FindBy(xpath="//span[@class='selection hover']")
    WebElement colorList;
	*/
	@FindBy(xpath="//select[@id='quantity']")
	WebElement quantity;
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement addCart;
	@FindBy(xpath="//input[@value='Proceed to checkout']")
	WebElement proceed;
	public AddItemToCartPage()
	{
		PageFactory.initElements(driver, this);
	
	}
	
	/*public void sizeDropDown(String sizetype)
	{
		Select shoeSize=new Select(driver.findElement(By.xpath("//select[@id='native_dropdown_selected_size_name']")));
		shoeSize.selectByVisibleText(sizetype);
		
	}
	public void colorSelectList() {
		
		
		
	}
	*/
	public void qtyselect(String qty)
	{
		//Actions act=new Actions(driver);
		//act.moveToElement(quantity).build().perform();
		Select  Qty=new Select(driver.findElement(By.xpath("//select[@id='quantity']")));
		Qty.selectByVisibleText(qty);
		//quantity.click();
	}
	public void clickOnAddToCart()
	{
		addCart.click();
	}
	public void clickOnProceed()
	{
		proceed.click();
	}
	
		
	
}
