package Testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import DBConnection.DBConnection.*;
public class TestAuto {
  @Test
  public void ExecuteTests() {
	  DBQuery query = new DBQuery();
	  try {
		query.callingDBTest();
		query.GoogleTest();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
 

}
