package Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import DBConnection.DBConnection.*;

public class TestingDatabaseMethods {
	static File file_query = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\dbQueries\\maintainWireNotification.properties");
	static File file_db = new File(System.getProperty("user.dir")+"\\DB.properties");
	static FileInputStream fs_query;
	static FileInputStream fs_dbprop;
	static Properties prop;
	static Properties prop_dbproperties;
	@Test
	
	public void TestSQLQueries() {
		
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
		String sqlselectquery_output = db.executequery(prop_dbproperties.getProperty("dburl"),
				prop.getProperty("mxn_WX-T1134_Step06"), "Select", "Null");
		System.out.println(sqlselectquery_output);
		String sqlupdatequery_output = db.executequery(prop_dbproperties.getProperty("dburl"),
				prop.getProperty("mxn_WX-T1137_Step07"), "Update", "Null", "Himanshu", "1533");
		System.out.println(sqlupdatequery_output);
		String sqlquery_output = db.executequery(prop_dbproperties.getProperty("dburl"),
				prop.getProperty("mxn_WX-T1134_Step08"), "Select", "Null","1533");
		System.out.println(sqlquery_output);		
	}
}
