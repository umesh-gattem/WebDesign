package com.razorthink.webdesign.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.razorthink.webdesign.database.MySqlConnection;

/**
 * This class is used to insert details of the new post into the database.
 * 
 * @author umesh
 *
 * @since 01-08-2016
 */

public class CreatePost {

	public static String insertPostDetails(String description, String username, String price) {
		Connection connection = MySqlConnection.getConnection();
		try {
			Integer user = null;
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String dateofPost=dateFormat.format(date);
			String getUserId = "select id from userDetails where username='" + username + "'";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(getUserId);
			while (rs.next()) {
				String userId = rs.getString(1);
				user = Integer.parseInt(userId);
			}
			String query = "insert into postDetails(userId,description, username, price,dateofpost) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, price);
			preparedStatement.setString(2, description);
			preparedStatement.setString(5, dateofPost);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL exception");
			return null;
		}
		return "Success";
	}
}
