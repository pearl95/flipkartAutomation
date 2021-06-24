package com.mavendemo.pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mavendemo.base.TestBaseFlip;
import com.mavendemo.util.TestExcelUtil;

public class HomePageAndProductSelectPage extends TestBaseFlip{
	
	@FindBy(xpath="//input[@name='q']")
	WebElement searchpath;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement subbutt;
	
	@FindBy(xpath="//div[contains(text(),'SAMSUNG 198 L Direct Cool Single Door 5 Star Refrigerator with Base Drawer')]")
	WebElement phoneclick;
	
	
	public HomePageAndProductSelectPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public Boolean validateHomePageUser() {
		return driver.getPageSource().contains(prop.getProperty("usern"));
	}
	
	public BuyPage homeProductSearchAndClick(String Phn) throws InterruptedException {
		Thread.sleep(1000);
	
		
		searchpath.sendKeys(Phn);
		Thread.sleep(1000);
		subbutt.click();
		phoneclick.click();
		return new BuyPage();
		
	}
	
	
	
	public Boolean validateProductTitle(String Phnname) throws InterruptedException {
		searchpath.sendKeys(Phnname);
		subbutt.click();
		Thread.sleep(1000);
		return driver.getPageSource().contains(prop.getProperty("product"));
	}


}
