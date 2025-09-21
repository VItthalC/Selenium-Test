package com.Swaglabs.app.MyApp;

import org.testng.annotations.Test;

import pages.InventoryPage1;
import pages.LoginPage;
import utils.BaseClass;

public class InventoryTest extends BaseClass{

	@Test
	public void testProductPurchaseFlow() {
		LoginPage login = new LoginPage(getDriver());
		InventoryPage1 inventory = new InventoryPage1(getDriver());
		
		login.loginAs("standard_user","secret_sauce");
		inventory.addToCart();
	}
}
