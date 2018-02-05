package com.database.user;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	
	Connection connection = null;
	
	public void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:8306/batch5_schema";
			connection = DriverManager.getConnection(url, "root", "Test@123");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			if(connection != null){
				connection.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


}
