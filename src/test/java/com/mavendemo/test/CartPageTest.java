package com.mavendemo.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mavendemo.base.TestBaseFlip;
import com.mavendemo.pages.BuyPage;
import com.mavendemo.pages.CartPage;
import com.mavendemo.pages.HomePageAndProductSelectPage;
import com.mavendemo.pages.LoginPage;
import com.mavendemo.pages.PaymentPage;

public class CartPageTest extends TestBaseFlip{
	

	
	LoginPage loginPage;
	HomePageAndProductSelectPage homePageAndProductSelectPage;
	BuyPage buyPage;
	CartPage cartPage;
	PaymentPage paymentPage;
	
	public CartPageTest() throws IOException{
		super();
	}
	
	@BeforeMethod
	public void setup()  throws IOException, InterruptedException {
		
		
		Flipinitialization();
		
		 loginPage= new LoginPage(); 
		 homePageAndProductSelectPage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		 Thread.sleep(1000);
		 buyPage= homePageAndProductSelectPage.homeProductSearchAndClick(prop.getProperty("prod"));
		 
		 cartPage=buyPage.childWindowChange();
		 
		 cartPage=buyPage.addCartButton();
	}
	
	@Test(priority=1)
	public void cartPagePriceTest() throws InterruptedException {
		
		
		log.info("****************** starting test case 1 ***********************");
		
		
		
		
		Thread.sleep(1000);
		boolean flagforprice=cartPage.validatePriceAtCartPage();
		Assert.assertTrue(flagforprice);
		
		
		
		
		log.info("******** ending test case ******************");
		
	}
	
	@Test(priority=2)
	public void placeOrderButtonClick() throws InterruptedException {
		
		
		log.info("****************** starting test case 2 ***********************");
		
		
		
		
		
		Thread.sleep(1000);
		paymentPage=cartPage.placeOrderButtonPageClick();
		
		
		
		log.info("******** ending test case ******************");
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		
		
		log.info("************* Browser is closed *************************");
	}

}
