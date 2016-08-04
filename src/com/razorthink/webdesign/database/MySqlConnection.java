package com.razorthink.webdesign.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is used for JDBC(Java Database Connection) .Here the connection is
 * made between the java and local database.
 * 
 * @author umesh
 *
 */
public class MySqlConnection {

	public static Connection connection;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Where is your MySQL JDBC Driver?");
				e.printStackTrace();
				return null;
			}
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebDesign", "root", "root");
			} catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return null;
			}
		}
		return connection;
	}
}
