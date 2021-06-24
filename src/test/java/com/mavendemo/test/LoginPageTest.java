package com.mavendemo.test;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mavendemo.base.TestBaseFlip;
import com.mavendemo.pages.HomePageAndProductSelectPage;
import com.mavendemo.pages.LoginPage;
import com.mavendemo.util.TestExcelUtil;

public class LoginPageTest extends TestBaseFlip{
	
	
	LoginPage loginPage;
	HomePageAndProductSelectPage homePageAndProductSelectPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		
		Flipinitialization();
		
		 loginPage= new LoginPage(); 
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		log.info("****************** starting test case 1 ***********************");
		
		
		
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, prop.getProperty("title"),"Login Page Title is not matched");
		
		
		
		log.info("******** ending test case ******************");
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException, IOException {
		
		
		log.info("****************** starting test case 2 ***********************");
	
		
		
		Map<String,String>exceldata=TestExcelUtil.getData();
		homePageAndProductSelectPage =loginPage.login(exceldata.get("username"),exceldata.get("password"));
		
		
		
		log.info("******** ending test case ******************");
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
		
		
		log.info("************* Browser is closed *************************");
	}

}
