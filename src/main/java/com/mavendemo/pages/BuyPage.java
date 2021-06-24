package com.mavendemo.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mavendemo.base.TestBaseFlip;

public class BuyPage extends TestBaseFlip{


	@FindBy(xpath="//button[text()='GO TO CART']")
	WebElement gotocart;
	
	public BuyPage() {
		PageFactory.initElements(driver, this);
	}
	
	public CartPage childWindowChange() throws InterruptedException{
		
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		}
		}
		
		return new CartPage();
		}
	
	public String validateBuyPageTitle() {
		return driver.getTitle();
	}
	
	public CartPage addCartButton() throws InterruptedException {
		
		Thread.sleep(2000);
		gotocart.click();
		
		return new CartPage();
		

	}
	
	
}
