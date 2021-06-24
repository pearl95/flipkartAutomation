package com.mavendemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mavendemo.base.TestBaseFlip;

public class LoginPage extends TestBaseFlip{
	
	
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement mailpath;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement passpath;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement subpath;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePageAndProductSelectPage login(String username,String password) throws InterruptedException
	{	
		Thread.sleep(1000);
		mailpath.sendKeys(username);
		passpath.sendKeys(password);
		subpath.click();
		return new HomePageAndProductSelectPage();
		
		
	}

}
