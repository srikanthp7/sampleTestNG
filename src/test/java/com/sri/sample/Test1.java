package com.sri.sample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Test1 {
  WebDriver driver;
  @DataProvider(name = "addMethodDataProvider")
  public Object[][] dataProvider() {
      return new Object[][] { { 2, 5, 6 }, { 3, 7, 10 }, { 4, 5, 9 } };
  }
  @BeforeClass

 
	  public void beforeClass() {
	
	  System.out.println("Before- class");
	  }
 
  @BeforeMethod
  @Parameters({"url","browser"})
  
  public void beforeTest(String url,String browser) {
	  System.setProperty("webdriver.firefox.marionette", browser);
		 
//	  	FirefoxOptions options = new FirefoxOptions();
//		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); //Location where Firefox is installed
//
//		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		capabilities.setCapability("moz:firefoxOptions", options);
		//set more capabilities as per your requirements

		 //driver = new FirefoxDriver(capabilities);
	  	 
  	 driver = new FirefoxDriver();
		 driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	  System.out.println("before- Method");
  }
  @Test(priority=3)
  public void f3() {
	  System.out.println("in Test3");
  }
 
  
  @Test(priority=2)
  public void f1() {
	  System.out.println("in Test2");
  }
  
  

  @Test(dataProvider = "addMethodDataProvider",priority=1)
  public void testAddMethod(int a, int b, int result) {
      Calculator calculator = new Calculator();
      Assert.assertEquals(calculator.add(a, b), result);
  }

  @AfterMethod
  public void afterTest() {
	  System.out.println("in AfterMethod");
  }
  @AfterClass
  public void afterClass() {
	  System.out.println("in After Class");
	 // driver.quit();
  }

}
