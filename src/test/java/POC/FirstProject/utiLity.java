package POC.FirstProject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class utiLity extends baseClass {

	protected WebDriver driver;
	protected Actions actions;

	public utiLity(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
	}


	public void WaitFor(WebElement Ell) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(Ell));
	}

	public void WaitForList(List<WebElement> ListEll) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(ListEll));
	}

	public static ExtentReports report() {
		String path = System.getProperty("user.dir") + "//AmazoneReports//reports.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("First Project Report");
		report.config().setDocumentTitle("First Project");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);

		extent.setSystemInfo("Tester Name > ", "Girijesh Pandey");

		return extent;
	}

	public static String takeScreenShot(String testCaseName, WebDriver driver) throws IOException {

		// Create screenshots folder path
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String pathSrc = System.getProperty("user.dir") + File.separator + "AmazoneReports" + File.separator
				+ testCaseName
				+ ".png";
		File destination = new File(pathSrc);
		FileUtils.copyFile(src, destination);
		System.out.println("Screenshot saved at: " + pathSrc);
		System.out.println("Screenshot file exists: " + destination.exists());
		return pathSrc;
	}


	public void hoverOver(WebElement ellement) {
		actions.moveToElement(ellement).perform();
	}

	public void dropDown(WebElement ell) {
		Select select = new Select(ell);
	}


}
