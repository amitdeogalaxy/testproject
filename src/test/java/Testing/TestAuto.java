package Testing;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import DBConnection.DBConnection.*;

public class TestAuto {

	String outputDirectory;
	ExtentReports extent;
	ExtentTest log;
	WebDriver driver;
	String nameofCurrMethod;

	@BeforeSuite
	public void setup() {
		outputDirectory = "./test-output";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(outputDirectory + "/" + "extent.html");
		htmlReporter.config().setDocumentTitle("ExtentReports - Created by TestNG Listener");
		htmlReporter.config().setReportName("ExtentReports - Created by TestNG Listener");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}

	public WebDriver gettingbrowser(String browser_value) {
		WebDriver driver = null;
		nameofCurrMethod = null;

		if (browser_value.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\adeo\\Desktop\\WireXchange\\WireXChangeTest\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser_value.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\adeo\\Desktop\\WireXchange\\WireXChangeTest\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser_value.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\adeo\\Desktop\\WireXchange\\WireXChangeTest\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browser_value.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\adeo\\Desktop\\WireXchange\\WireXChangeTest\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("No browser value provided");
		}
		return driver;

	}

	@Test(priority = 1, groups = { "smoke", "sanity", "regression" })
	@Parameters("browser")
	public void ExecuteTest(String browser) {

		driver = gettingbrowser(browser);
		nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		DBQuery query = new DBQuery();
		try {
			query.callingDBTest();
			query.GoogleTest(driver);
			driver.close();
		} catch (InterruptedException e) { // TODO Auto-generated
			e.printStackTrace();
		}
	}

	@Test(priority = 2, groups = { "regression", "sanity" })
	@Parameters("browser")
	public void ExecuteTestssecond(String browser) {

		driver = gettingbrowser(browser);
		nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		DBQuery query = new DBQuery();
		try {
			query.callingDBTest();
			query.GoogleTest(driver);
			driver.close();
		} catch (InterruptedException e) { // TODO Auto-generated
			e.printStackTrace();
		}

	}

	@Test(priority = 3, groups = { "smoke", "regression" })

	@Parameters("browser")
	public void ExecuteTeststhird(String browser) {
		driver = gettingbrowser(browser);
		nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		DBQuery query = new DBQuery();
		try {
			query.callingDBTest();
			query.GoogleTest(driver);
			driver.close();
		} catch (InterruptedException e) { // TODO Auto-generated
			e.printStackTrace();
		}
	}

	@Test(priority = 4, groups = { "smoke", "sanity" })

	@Parameters("browser")
	public void ExecuteTestsfourth(String browser) {
		driver = gettingbrowser(browser);
		nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		DBQuery query = new DBQuery();
		try {
			query.callingDBTest();
			query.GoogleTest(driver);
			driver.close();
		} catch (InterruptedException e) { // TODO Auto-generated
			e.printStackTrace();
		}
	}

	@Test(priority = 5, groups = { "smoke" })

	@Parameters("browser")
	public void ExecuteTestsfifth(String browser) {
		driver = gettingbrowser(browser);
		nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		DBQuery query = new DBQuery();
		try {
			query.callingDBTest();
			query.GoogleTest(driver);
			driver.close();
		} catch (InterruptedException e) { // TODO Auto-generated
			e.printStackTrace();
		}
	}

	@Test(priority = 6, groups = { "regression" })

	@Parameters("browser")
	public void ExecuteTestssixth(String browser) {
		driver = gettingbrowser(browser);
		nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		DBQuery query = new DBQuery();
		try {
			query.callingDBTest();
			query.GoogleTest(driver);
			driver.close();
		} catch (InterruptedException e) { // TODO Auto-generated
			e.printStackTrace();
		}
	}

	@Test(priority = 7, groups = { "sanity" })

	@Parameters("browser")
	public void ExecuteTestsseventh(String browser) {
		driver = gettingbrowser(browser);
		nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		DBQuery query = new DBQuery();
		try {
			query.callingDBTest();
			query.GoogleTest(driver);
			driver.close();
		} catch (InterruptedException e) { // TODO Auto-generated
			e.printStackTrace();
		}
	}

	@Test(priority = 8, groups = { "regression", "sanity" })

	@Parameters("browser")
	public void ExecuteTestseigth(String browser) {
		driver = gettingbrowser(browser);
		nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		DBQuery query = new DBQuery();
		try {
			query.callingDBTest();
			query.GoogleTest(driver);
			driver.close();
		} catch (InterruptedException e) { // TODO Auto-generated
			e.printStackTrace();
		}
	}

	@Test(priority = 9, groups = { "smoke", "regression" })

	@Parameters("browser")
	public void ExecuteTestsnineth(String browser) {
		driver = gettingbrowser(browser);
		nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		DBQuery query = new DBQuery();
		try {
			query.callingDBTest();
			query.GoogleTest(driver);
			driver.close();
		} catch (InterruptedException e) { // TODO Auto-generated
			e.printStackTrace();
		}
	}

	@Test(priority = 10)

	@Parameters("browser")
	public void ExecuteTeststenth(String browser) {
		driver = gettingbrowser(browser);
		nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		DBQuery query = new DBQuery();
		try {
			query.callingDBTest();
			query.GoogleTest(driver);
			driver.close();
		} catch (InterruptedException e) { // TODO Auto-generated
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
		extent.flush();
	}

}
