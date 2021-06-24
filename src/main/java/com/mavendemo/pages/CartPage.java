package com.mavendemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mavendemo.base.TestBaseFlip;

public class CartPage extends TestBaseFlip{
	
	@FindBy(xpath="//span[text()='Place Order']")
	WebElement placeorderbutton;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatePriceAtCartPage() {
		return driver.getPageSource().contains(prop.getProperty("price"));
	}
	
public PaymentPage placeOrderButtonPageClick() {
		
	placeorderbutton.click();
		return new PaymentPage();
		
	}

}
