package co.Parllel.instance;

import org.testng.annotations.Factory;

public class LoginFactory {

	@Factory
	public Object[] createTests() {
		System.out.println("In Factory class");
		return new Object[] {new LoginParaTest("chrome"),new LoginParaTest("firefox")};
	}
}
