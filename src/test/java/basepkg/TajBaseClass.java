package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TajBaseClass {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void setUpReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/Tajreport.html");
		reporter.config().setDocumentTitle("Taj Automation Report");
		reporter.config().setReportName("Taj Functional Test");
		reporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "local host");
		extent.setSystemInfo("os", "Windows10");
		extent.setSystemInfo("testername", "abc");
		extent.setSystemInfo("browsername", "chrome");
	}

	@BeforeMethod
	public void setUp() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.tajhotels.com/en-in");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "test case failed is " + result.getName());
			test.log(Status.FAIL, "test case failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "test case skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "test case passed is " + result.getName());
		}
		driver.quit();
	}

	@AfterSuite
	public void flushReport() {
		extent.flush();
	}
}
