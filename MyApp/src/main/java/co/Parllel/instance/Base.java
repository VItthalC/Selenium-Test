package co.Parllel.instance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	private String browser;
	 WebDriverWait wait;
	
	public Base(String browser) {
		this.browser = browser;
	}
	
	public void setupDriver() {
		if (browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
		getDriver().manage().window().maximize();
	}
	
	public void tearDown() {
		if(getDriver()!=null) {
			getDriver().quit();
			driver.remove();
		}
	}
	public void waitForElement(By locator, int time) {
		wait= new WebDriverWait(getDriver(),Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public WebDriver getDriver() {
		return driver.get();
	}
	public String getBrowser() {
		return this.browser;
	}
}
