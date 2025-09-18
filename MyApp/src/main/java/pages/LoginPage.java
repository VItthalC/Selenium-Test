package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By UserNamefield = By.id("user-name");
	By Passwordfield = By.id("password");
	By LoginButton = By.id("login-button");
	By errorMessage = By.xpath(".//div[starts-with(@class,'error')]");
	
	public void enterUserName(String username) {
		 
		driver.findElement(UserNamefield).clear();
		driver.findElement(UserNamefield).sendKeys(username);
		
	}
	
	public void enterPassword(String pass) {
		driver.findElement(Passwordfield).clear();
		driver.findElement(Passwordfield).sendKeys(pass);
	}
	
	public void clickLoginButton() {
		driver.findElement(LoginButton).click();
	}
	public String getErrorMessage() {
		String message = driver.findElement(errorMessage).getText();
		return message;
	}
	public void loginAs(String userName,String pass) {
		enterUserName(userName);
		enterPassword(pass);
		clickLoginButton();
	}
}
