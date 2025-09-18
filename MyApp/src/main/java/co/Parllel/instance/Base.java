package co.Parllel.instance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	private String browser;
	
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
	public WebDriver getDriver() {
		return driver.get();
	}
	public String getBrowser() {
		return this.browser;
	}
}
