package com.Swaglabs.app.MyApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

	private WebDriver driver;
	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//By AddToCartBtn1 = By.id("add-to-cart-sauce-labs-backpack");
	By AddToCartBtn1 = By.xpath(".//button[contains(@id,'add-to-cart')]");
	By AddToCartBtn2 = By.id("add-to-cart-sauce-labs-bike-light");
	//By RemoveBtn1 = By.id("remove-sauce-labs-backpack");
	By RemoveBtn1 = By.xpath(".//button[contains(@id,'remove-')]");
	By RemoveBtn2 = By.id("remove-sauce-labs-bike-light");
	By ShoppingCartLink = By.className("shopping_cart_link");
	
	public void clickOnAddtoCartBtn() {
		driver.findElement(AddToCartBtn1).click();
		
	}
	public boolean validateProductAdded() {
		return driver.findElements(RemoveBtn1).size()>=1;
	}
	
	public void clickOnRemoveBtn() {
		
	}
	
	public void clickOnShoppingCart() {
		driver.findElement(ShoppingCartLink).click();
		
	}
}
