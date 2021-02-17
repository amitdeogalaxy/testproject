/*@Author: Amit Kumar Deo
  @Creation Date: 08/02/2020*/
package DBConnection.DBConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DBQuery {

	static File file_query = new File(
			System.getProperty("user.dir") + "\\src\\main\\resources\\dbQueries\\maintainWireNotification.properties");
	static File file_db = new File(System.getProperty("user.dir") + "\\DB.properties");

	static FileInputStream fs_query;
	static FileInputStream fs_dbprop;
	static Properties prop;
	static Properties prop_dbproperties;
	public static WebDriver Driver;

	public void callingDBTest() throws InterruptedException {
		try {
			fs_query = new FileInputStream(file_query);
			fs_dbprop = new FileInputStream(file_db);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			prop = new Properties();
			prop.load(fs_query);
			prop_dbproperties = new Properties();
			prop_dbproperties.load(fs_dbprop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TestDB db = new TestDB();
		String sqlquery_outputlt = db.executequery(prop_dbproperties.getProperty("dburl"),
				prop.getProperty("mxn_WX-T1134_Step06"), "Select", "Null");
		System.out.println(sqlquery_outputlt);
		sqlquery_outputlt = db.executequery(prop_dbproperties.getProperty("dburl"),
				prop.getProperty("mxn_WX-T1137_Step07"), "Update", "Null", "Ashutosh", "2571");
		System.out.println(sqlquery_outputlt);

	}

	public void GoogleTest(WebDriver Driver) throws InterruptedException {

		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver.get("https://www.google.com/");

		Thread.sleep(5000);
		Driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		Thread.sleep(5000);
		WebElement sign_in = Driver.findElement(By.xpath("//input[@type='email']"));
		if (sign_in.isDisplayed()) {
			System.out.println("Sign In page is displayed for Google");
		} else {
			System.out.println("Sign In page is not displayed for google");

		}

	}
	/*
	 * public static void main(String[] args) {
	 * System.out.println(System.getProperty("user.dir"));
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
	 * WebDriver driver = new ChromeDriver(); driver.get("https://www.google.com");
	 * driver.quit();
	 * 
	 * System.out.println(System.getProperty("user.dir")+
	 * "\\src\\main\\resources\\dbQueries\\maintainWireNotification.properties");
	 * System.out.println(System.getProperty("user.dir")+"\\DB.properties"); }
	 */

}
