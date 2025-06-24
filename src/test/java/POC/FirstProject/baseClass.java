package POC.FirstProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseClass {

	protected static WebDriver driver;
	protected static Properties prop;

	public void setUp() throws IOException {
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//POC//FirstProject//base.properties");
		prop = new Properties();
		prop.load(file);

		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else {
			throw new IllegalArgumentException("Unexpected browser: " + browser);
		}

		driver.get(prop.getProperty("baseURL"));
		driver.manage().window().maximize();
	}

	public void landingPage() throws IOException {
		setUp();
		driver.navigate().to(prop.getProperty("mainRUL"));
	}

}
