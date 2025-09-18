package com.Swaglabs.app.MyApp;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.BaseClass;

public class TestInvalidLogin extends BaseClass{

	@Test
	public void testInvalidLogin() {
		LoginPage login = new LoginPage(getDriver());
		login.loginAs("invalid", "secret_sauce");
		String errorMessage = login.getErrorMessage();
		Assert.assertTrue(errorMessage.contains("Username and password do not match any user in this service"), "Expected error message not displayed");
	}
	
	@Test
	public void testLockedOutUser() {
		LoginPage login = new LoginPage(getDriver());
		login.loginAs("locked_out_user", "secret_sauce");
		String errorMessage = login.getErrorMessage();
		Assert.assertTrue(errorMessage.contains("Sorry, this user has been locked out."), "Expected error message not displayed");
	
	}
														
}
