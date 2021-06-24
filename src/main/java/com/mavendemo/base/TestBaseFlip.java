package com.mavendemo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.mavendemo.util.TestUtil;

public class TestBaseFlip {
	protected static Logger log = Logger.getLogger(TestBaseFlip.class);
	
	public static WebDriver driver;
	
	public static Properties prop;
	
	public TestBaseFlip()  {
		
		  try {
			 
		
		 prop=new Properties(); 
		 FileInputStream inputstream= new FileInputStream("C:\\Eclipse\\eclipse\\mavendemo\\src\\main\\java\\com\\mavendemo\\config\\configdata.properties");
		prop.load(inputstream);
		
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	public static void Flipinitialization() {
		
		
		log.info("**************** Starting test cases execution  ******************");
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\chrome\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		 
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS) ;
		 
		 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS) ;
		 
		 driver.manage().window().maximize(); 
			
		 driver.get(prop.getProperty("URL"));
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
	

