package POC.FirstProject;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGRunner extends baseClass {
	logIN login;

	@BeforeMethod
	public void baseSetup() throws IOException {
		landingPage();
		login = new logIN(driver);
	}

	@Test
	public void logIn() {
		login.Login();
		login.emailCredential();
	}

}
