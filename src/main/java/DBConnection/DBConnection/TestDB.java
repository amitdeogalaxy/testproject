/*@Author: Amit Kumar Deo
  @Creation Date: 08/02/2020*/
package DBConnection.DBConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestDB {

	File file = new File("C:\\Users\\adeo\\Desktop\\Project\\DBConnection\\DB.properties");
	FileInputStream fs;
	int type = 0;
	int count = 0;
	String query_result = null;

	public String executequery(String dburl, String query, String query_type, String column, String... parameters) {
		
		int parameter_count = parameters.length;
		List<String> adding_parametervalues = new ArrayList<String>();
		for (String val : parameters) {
			adding_parametervalues.add(val.toString());

		}
		try {
			fs = new FileInputStream(file);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fs);
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		try {
			Class.forName(prop.getProperty("dbclassname"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		if ((query_type == "Select") && ((query.contains("Select")) || (query.contains("SELECT")))) {
			type = 1;
		} else if ((query_type == "Insert") && ((query.contains("Insert")) || (query.contains("INSERT")))) {
			type = 2;
		} else if ((query_type == "Delete") && ((query.contains("Delete")) || (query.contains("DELETE")))) {
			type = 3;
		} else if ((query_type == "Update") && ((query.contains("Update")) || (query.contains("UPDATE")))) {
			type = 4;
		} else {
			System.out.println("Incorrect SQL Query: '" + query + "' Provided for Query Type ==> " + query_type);
			System.exit(1);
		}

		try {
			Connection con = DriverManager.getConnection(dburl);
			PreparedStatement stmt;
			ResultSet results;

			switch (type) {
			case 1:

				stmt = con.prepareStatement(query);

				switch (parameter_count) {
				case 1:
					stmt.setString(1, adding_parametervalues.get(0));
					break;
				case 2:
					stmt.setString(1, adding_parametervalues.get(0));
					stmt.setString(2, adding_parametervalues.get(1));
					break;
				case 3:
					stmt.setString(1, adding_parametervalues.get(0));
					stmt.setString(2, adding_parametervalues.get(1));
					stmt.setString(3, adding_parametervalues.get(2));
					break;
				case 4:
					stmt.setString(1, adding_parametervalues.get(0));
					stmt.setString(2, adding_parametervalues.get(1));
					stmt.setString(3, adding_parametervalues.get(2));
					stmt.setString(4, adding_parametervalues.get(3));
					break;
				case 5:
					stmt.setString(1, adding_parametervalues.get(0));
					stmt.setString(2, adding_parametervalues.get(1));
					stmt.setString(3, adding_parametervalues.get(2));
					stmt.setString(4, adding_parametervalues.get(3));
					stmt.setString(5, adding_parametervalues.get(4));
					break;

				default:
					//System.out.println("");
				}

				results = stmt.executeQuery();
				ResultSetMetaData rsmd = results.getMetaData();

				List<String> list = new ArrayList<String>();
				while (results.next()) {
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						if (!(i == rsmd.getColumnCount())) {
							list.add(results.getString(i));
						} else {
							list.add(results.getString(i));
						}
					}
				}
				if (!column.equalsIgnoreCase("Null")) {
					int value = Integer.parseInt(column);
					String element = list.get(value);
					query_result = element.toString();
				} else {

					query_result = list.toString();
				}

				break;			
			
			case 4:
				try {
					stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

					switch (parameter_count) {
					case 1:
						stmt.setString(1, adding_parametervalues.get(0));
						break;
					case 2:
						stmt.setString(1, adding_parametervalues.get(0));
						stmt.setString(2, adding_parametervalues.get(1));
						break;
					case 3:
						stmt.setString(1, adding_parametervalues.get(0));
						stmt.setString(2, adding_parametervalues.get(1));
						stmt.setString(3, adding_parametervalues.get(2));
						break;
					case 4:
						stmt.setString(1, adding_parametervalues.get(0));
						stmt.setString(2, adding_parametervalues.get(1));
						stmt.setString(3, adding_parametervalues.get(2));
						stmt.setString(4, adding_parametervalues.get(3));
						break;
					case 5:
						stmt.setString(1, adding_parametervalues.get(0));
						stmt.setString(2, adding_parametervalues.get(1));
						stmt.setString(3, adding_parametervalues.get(2));
						stmt.setString(4, adding_parametervalues.get(3));
						stmt.setString(5, adding_parametervalues.get(4));
						break;

					default:
						//System.out.println("");
					}

					stmt.executeUpdate();
					results = stmt.getGeneratedKeys();
					while (results.next()) {
						String[] str = results.toString().split(":", 2);
						if (!str[1].toString().isEmpty()) {
							query_result = "Row Updated Successfully";
						} else {
							query_result = "Unable to Update Row, please correct Query : " + query;
						}
					}
				} catch (Exception e) {
					query_result = e.getMessage();
				}
				break;
			default:
				System.out.println("No query or query_type provided");
			}
			con.close();

		} catch (SQLException e) {
			query_result = e.getMessage();
		}
		return query_result;
	}

}
