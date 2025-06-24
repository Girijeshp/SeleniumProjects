package POC.FirstProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listners.class)
public class testNGRunner extends baseClass {
	logIN login;

	@BeforeTest
	public void baseSetup() throws IOException {
		landingPage();
		login = new logIN(driver);
	}

	@Test
	public void logIn() {
		login.Login();
		login.emailCredential();
		 String actualMsg = login.getDisplayedMessage();
		    String expectedMsg = prop.getProperty("msg").trim();

		    Assert.assertEquals(actualMsg, expectedMsg, "The actual msg does not meet to expected!");
}
}
