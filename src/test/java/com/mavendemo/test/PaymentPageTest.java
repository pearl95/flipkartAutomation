package com.mavendemo.test;

import java.io.IOException;
import java.util.Map;

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
import com.mavendemo.util.TestExcelUtil;

public class PaymentPageTest extends TestBaseFlip {
	
	LoginPage loginPage;
	HomePageAndProductSelectPage homePageAndProductSelectPage;
	BuyPage buyPage;
	CartPage cartPage;
	PaymentPage paymentPage;
	
	public PaymentPageTest() throws IOException{
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
		 
		 paymentPage=cartPage.placeOrderButtonPageClick();
	}
	
	@Test(priority=1)
	public void paymentPageTitleTest() throws InterruptedException {
		
		log.info("****************** starting test case 1 ***********************");
		
		
		
		Thread.sleep(1000);
		String paymentPageTitle=paymentPage.validatePaymentPageTitle();
		Assert.assertEquals(paymentPageTitle, prop.getProperty("titlepaymentpage"),"Payment Page Title is not Matched");
		
		
		log.info("******** ending test case ******************");
	}
	
	
	@Test(priority=2)
	public void creditCardPaymentTest() throws InterruptedException, IOException {
	
		log.info("****************** starting test case 2 ***********************");
		
		
	//	homePageAndProductSelectPage =loginPage.login(,exceldata.get("password"));
		
		Thread.sleep(1000);
	//	paymentPage.creditCardPayment(prop.getProperty("cardNumber"), prop.getProperty("cvv"), prop.getProperty("monthValue"), prop.getProperty("yearValue"));
	//	paymentPage.cardValidity(prop.getProperty("verification"));
		
		Map<String,String>exceldata=TestExcelUtil.getData();
		paymentPage.creditCardPayment(prop.getProperty("cardNumber"), exceldata.get("cvv"), prop.getProperty("monthValue"), prop.getProperty("yearValue"));
		boolean cardverify =paymentPage.cardValidity(prop.getProperty("verification"));
		if (cardverify) {
			
			log.error("Wrongcredit card number");
			
		}
		else {
			log.error("credit cardnumber successful");
		}
		
		
		log.info("******** ending test case ******************");
	}
	
	
	
	
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		
		
		
		log.info("************* Browser is closed *************************");
	}

}
