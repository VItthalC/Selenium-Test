package utils;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import listeners.TestExtentReporter;
import listeners.TestListener;

@Listeners({TestExtentReporter.class})

public class BaseClass {
 //protected static WebDriver driver;
 TestListener testlistener;
 private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Class started");
      WebDriverManager.chromedriver().setup();
	  
	  ChromeOptions option = new ChromeOptions();
	  //option.addArguments("--headless");
	  option.addArguments("--incognito");
	  WebDriver webDriver = new ChromeDriver(option);
	  driver.set(webDriver);
	  getDriver().manage().window().maximize();
	  getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  getDriver().get("https://www.saucedemo.com/");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Test started");
	 
  }
  
  @AfterTest
  public void afterTest() {
	  System.out.println("Test finished");
  }
  @BeforeMethod
  public void beforeMethode() {
	  System.out.println("Method started");
	  
	 	  
  }

  @AfterMethod
  public void afterMethod() {
	  
  }
  @AfterClass
  public void afterClass() {
	  if(getDriver()!=null) {
			getDriver().quit();
			driver.remove();
		}
  }
  public static WebDriver getDriver() {
      return driver.get();
  }

}
