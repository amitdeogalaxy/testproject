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
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
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

	@BeforeSuite
	public void setup() {
		
		outputDirectory = "./test-output";
		System.out.println(outputDirectory.toString());
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(outputDirectory + "/" + "extent.html");
		htmlReporter.config().setDocumentTitle("ExtentReports - Created by TestNG Listener");
		htmlReporter.config().setReportName("ExtentReports - Created by TestNG Listener");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);	
		 
		
		
	}
	

	@Test
	public void ExecuteTests(Method method) {
		log = extent.createTest(method.getName());
		DBQuery query = new DBQuery();
		try {
			log.log(Status.INFO, "DBExecution method started");
			query.callingDBTest();
			log.log(Status.PASS, "DBExecution method passed");
			log.log(Status.INFO, "Google click method started");
			query.GoogleTest();
			log.log(Status.PASS, "Google click method passed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void teardown() {
		extent.flush();
	}

}
