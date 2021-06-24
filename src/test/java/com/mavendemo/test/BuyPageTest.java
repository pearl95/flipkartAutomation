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

public class BuyPageTest extends TestBaseFlip{
	
	
	
	LoginPage loginPage;
	HomePageAndProductSelectPage homePageAndProductSelectPage;
	BuyPage buyPage;
	CartPage cartPage;
	
	public BuyPageTest() throws IOException{
		super();
	}
	
	@BeforeMethod
	public void setup()  throws IOException, InterruptedException {
		
		
		Flipinitialization();
		
		 loginPage= new LoginPage(); 
		 homePageAndProductSelectPage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		 Thread.sleep(1000);
		 buyPage= homePageAndProductSelectPage.homeProductSearchAndClick(prop.getProperty("prod"));
		 
	}
	
	@Test(priority=1)
	public void buyPageTitleTest() throws InterruptedException {
		
		log.info("****************** starting test case 1 ***********************");
		
		
		
		Thread.sleep(1000);
		buyPage.childWindowChange();
		String buyPageTitle=buyPage.validateBuyPageTitle();
		Assert.assertEquals(buyPageTitle, prop.getProperty("titlebuypage"),"Buy Page Title is not Matched");
		
		
		
		
		log.info("******** ending test case ******************");
	}
	
	
	@Test(priority=2)
	public void buyPageBuyButtonClick() throws InterruptedException {
		log.info("****************** starting test case 2 ***********************");
		
		
		
		Thread.sleep(1000);
		buyPage.childWindowChange();
		 Thread.sleep(1000);
		cartPage=buyPage.addCartButton();
		
		
		
		
		log.info("******** ending test case ******************");
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		
		
		
		
		
		log.info("************* Browser is closed *************************");
	}
	

}
