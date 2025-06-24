package POC.FirstProject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logIN extends utiLity {

	public logIN(WebDriver driver) throws IOException {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-nav-ref='nav_ya_signin']")
	WebElement loginIcon; // This element locates the “Account & Lists” or “Sign In” area in Amazon's top
							// navigation bar;

	@FindBy(xpath = "//div[@id='nav-flyout-accountList']")
	List<WebElement> accountList; // This locates the flyout/dropdown panel that appears when you hover over the
									// login icon;

	@FindBy(xpath = "//span[contains(text(),'Sign in')]")
	WebElement signIN; // This element locates the actual "Sign in" button/link within the flyout;

	@FindBy(xpath = "//input[@type='email']")
	WebElement email;// This element finds the email input field on a web page;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement continuebtn; // for continue button.

	@FindBy(xpath = "//h1[contains(text(),'Looks like you are new to Amazon')]")
	WebElement msg;

	public void Login() {

		WaitFor(loginIcon);
		hoverOver(loginIcon);
		// loginIcon.click();

		WaitForList(accountList);
		signIN.click();

	}

	public void emailCredential() {
		WaitFor(email);
		email.sendKeys(prop.getProperty("email"));
		continuebtn.click();
	}

	public String getDisplayedMessage() {
		WaitFor(msg);
		return msg.getText().trim();
	}

	}
