package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class InventoryPage1 {

	private WebDriver driver;
	public InventoryPage1(WebDriver driver) {
		this.driver= driver;
		}
	
	By AppLogo = By.className("app_logo");
	By ShoppingCartLink = By.className("shopping_cart_link");
	By CheckoutBtn = By.id("checkout");
	By FirstNameInp = By.id("first-name");
	By LastNameInp = By.id("last-name");
	By ZipCodeInp = By.id("postal-code");
	By CountinueBtn = By.id("continue");
	By FinishBtn = By.id("finish");
	By CheckOUtMsg = By.xpath(".//div[@id='checkout_complete_container' and normalize-space('Thank you for your order!')]");
	By AddToCart = By.xpath(".//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item_description']//button");
	  
	//String addToCart = ".//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item_description']//button";
	
	public void addToCart() {
		
		driver.findElement(AddToCart).click();
		driver.findElement(ShoppingCartLink).click();
		driver.findElement(CheckoutBtn).click();
		driver.findElement(FirstNameInp).sendKeys("TestF");
		driver.findElement(LastNameInp).sendKeys("TestL");
		driver.findElement(ZipCodeInp).sendKeys("431278");
		driver.findElement(CountinueBtn).click();
		driver.findElement(FinishBtn).click();
		
	}
}
