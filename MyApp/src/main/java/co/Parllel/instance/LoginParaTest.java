package co.Parllel.instance;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginParaTest extends Base{

	public LoginParaTest(String browser) {
		super(browser);
	}
	@BeforeMethod(alwaysRun = true)
    public void init() {
        setupDriver(); // initialize here!
    }
	@Test
	public void loginTest() {
		getDriver().get("https://www.saucedemo.com/");
        LoginParaPage login = new LoginParaPage(getDriver());
        System.out.println(getBrowser());
		
		login.loginAs("standard_user", "secret_sauce");
		
		Assert.assertTrue(getDriver().getCurrentUrl().contains("inventory"), "Login failed");
		
	}
	@AfterMethod
	public void cleanUp() {
		tearDown();
	}
}
