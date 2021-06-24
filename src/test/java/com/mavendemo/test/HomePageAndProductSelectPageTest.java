package com.mavendemo.test;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mavendemo.base.TestBaseFlip;
import com.mavendemo.pages.BuyPage;
import com.mavendemo.pages.HomePageAndProductSelectPage;
import com.mavendemo.pages.LoginPage;
import com.mavendemo.util.TestExcelUtil;

public class HomePageAndProductSelectPageTest extends TestBaseFlip{
	
	
	LoginPage loginPage;
	HomePageAndProductSelectPage homePageAndProductSelectPage;
	BuyPage buyPage;
	
	public HomePageAndProductSelectPageTest() throws IOException{
		super();
	}
	
	@BeforeMethod
	public void setup()  throws IOException, InterruptedException {
		
		
		Flipinitialization();
		
		 loginPage= new LoginPage(); 
		 homePageAndProductSelectPage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		
		
		log.info("****************** starting test case 1 ***********************");
		
		
		
		String homePageTitle=homePageAndProductSelectPage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, prop.getProperty("title"),"Home Page Title is not Matched");
		
		
		
		log.info("******** ending test case ******************");
	}
	
	@Test(priority=2)
	public void homeTest() throws InterruptedException, IOException {
		
		
		log.info("****************** starting test case 2 ***********************");
		
		
		
		
		Map<String,String>exceldata=TestExcelUtil.getData();
		buyPage= homePageAndProductSelectPage.homeProductSearchAndClick(exceldata.get("prod"));
		
		
		
		log.info("******** ending test case ******************");
	}
	
	@Test(priority=3)
	public void homePageUserTest() throws InterruptedException {
		
		
		log.info("****************** starting test case 3 ***********************");
		
		
		
	
		boolean flagforname=homePageAndProductSelectPage.validateHomePageUser();
		Assert.assertTrue(flagforname);
		
		
		
		
		log.info("******** ending test case ******************");
	}
	
	@Test(priority=4)
	public void ProductPageProductTest() throws InterruptedException {
		
		log.info("****************** starting test case 4 ***********************");
		
		
		
		
		boolean flagforprod=homePageAndProductSelectPage.validateProductTitle(prop.getProperty("prod"));
		Assert.assertTrue(flagforprod);
		
		
		
		log.info("******** ending test case ******************");
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		
		
		
		log.info("************* Browser is closed *************************");
	}
	
	
	}



