package com.razorthink.webdesign.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.razorthink.webdesign.database.MySqlConnection;

/**
 * This class is used to login to the application. When any user tries to login to
 * the account this class checks for the username and password ..if these two
 * credentials are matching then the user will be successfully logged into the
 * account.
 * 
 * @since 01-08-2016
 * 
 * @author umesh
 *
 */

public class LoginUser {

	/**
	 * 
	 * This is the method used to check whether the user is diving correct credentials
	 * or not.
	 * 
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */

	public static String loginUser(String user, String password) {

		Connection connection = MySqlConnection.getConnection();
		if (connection == null) {
			System.out.println("Connection is null");
		}
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from userDetails where username='" + user + "'");
			resultSet.next();
			if (resultSet.getString("username").equals(user) && resultSet.getString("password").equals(password)) {
				return user;
			}
		} catch (SQLException e) {
			System.out.println("SQL exception");
		}
		return null;
	}

	public void isUserPresent(String username) {
		
		
	}
}
