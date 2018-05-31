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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Test2 {
  WebDriver driver;
 
  @BeforeClass

   public void beforeClass() {

	  System.out.println("Before- class");
	  }
 
  @BeforeMethod
  @Parameters({"url","browser"})
  
  public void beforeTest(String url,String browser) {
	  
	  if(browser.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.firefox.marionette", "igeckodriver-v0.20.1-win64\\\\geckodriver.exe");
		  
		  driver = new FirefoxDriver();
	 
	  // If browser is IE, then do this	  
	 
	  }else if (browser.equalsIgnoreCase("ie")) { 
	 
		  // Here I am setting up the path for my IEDriver
	 
		  System.setProperty("webdriver.ie.driver", "C:\\Users\\SPodishe\\Downloads\\IEDriverServer_x64_3.8.0\\IEDriverServer.exe");
	 
		  driver = new InternetExplorerDriver();
	 
	  } 
	  
	 
		 driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	  System.out.println("before- Method");
  }
  @Test(priority=1)
  public void f3() {
	  System.out.println("in Test1");
  }
  @Test(priority=2)
  public void f2() {
	  System.out.println("in Test2");
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
