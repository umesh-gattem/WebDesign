package com.razorthink.webdesign.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.razorthink.webdesign.database.MySqlConnection;

public class RegisterUser {

	public static String createUser(String fullname, String username, String password, String email, String mobile,
			String address) {
		Connection connection=MySqlConnection.getConnection();
		if (connection == null) {
			System.out.println("Connection is null");
			return null;
		}
		String query = "insert into userDetails(fullName,username, password, email, mobile, address) values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, fullname);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, mobile);
			preparedStatement.setString(6, address);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return "Success";
		
	}
}