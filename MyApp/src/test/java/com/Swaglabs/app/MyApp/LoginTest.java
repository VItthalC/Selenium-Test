package com.Swaglabs.app.MyApp;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseClass;

public class LoginTest extends BaseClass{

	
	@Test(dataProvider = "users",priority=1)
	public void validLoginTest(String userName, String pass) {
		
		LoginPage login = new LoginPage(getDriver());
		
		
		//login.loginAs("standard_user", "secret_sauce");
		login.loginAs(userName, pass);
		Assert.assertTrue(getDriver().getCurrentUrl().contains("inventory"), "Login failed");
	}
	
	@Test(priority=2,dependsOnMethods= {"validLoginTest"})
	public void testAddProductToCart() {
		InventoryPage inventory = new InventoryPage(getDriver());
		inventory.clickOnAddtoCartBtn();
		
		Assert.assertEquals(inventory.validateProductAdded(), true, "Not Present");
		inventory.clickOnShoppingCart();
	}
	@DataProvider(name="users")
	public Object[][] dataProvider(){		
		return new Object[][] {{"standard_user","secret_sauce"}};
	}
}
