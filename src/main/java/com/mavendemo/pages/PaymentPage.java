package com.mavendemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mavendemo.base.TestBaseFlip;

public class PaymentPage extends TestBaseFlip {
	
	@FindBy(xpath="//button[text()='CONTINUE']")
	WebElement continueButton;
	
	@FindBy(xpath="//label[@for='CREDIT']")
	WebElement creditRadiobutton;
	
	@FindBy(xpath="//input[@name='cardNumber']")
	WebElement cardNumberField;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement cvvField;
	
	@FindBy(xpath="//select[@name='month']")
	WebElement monthDropdown;
	
	@FindBy(xpath="//select[@name='year']")
	WebElement yearDropdown;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement payButton;
	
	@FindBy(xpath="//span[text()='Not a valid card number']")
	WebElement invalid;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validatePaymentPageTitle() {
		return driver.getTitle();
	}
	
	public void creditCardPayment(String cardNumber, String cvv,String monthValue, String yearValue) throws InterruptedException {
		
		
		continueButton.click();
		Thread.sleep(1000);
		creditRadiobutton.click();
		cardNumberField.sendKeys(cardNumber);
		cvvField.sendKeys(cvv);
		
		Select drpMonth = new Select(monthDropdown);
		drpMonth.selectByVisibleText(monthValue);
		
		Select drpYear = new Select(yearDropdown);
		drpYear.selectByVisibleText(yearValue);
		payButton.click();
		
		
			}
	
	public String cardValidity()
	{
		String invalidMessage="";
		if(driver.findElements(By.xpath("//span[text()='Not a valid card number']")).size()>0) {
		System.out.println("error message found");
		invalidMessage=invalid.getText();
	      
	}
		else {
			System.out.println("error message not displayed");
		}
		return invalidMessage;
		
		
		
	}




	



}
