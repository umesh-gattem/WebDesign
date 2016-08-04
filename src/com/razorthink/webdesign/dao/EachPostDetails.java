package com.razorthink.webdesign.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.razorthink.webdesign.database.MySqlConnection;
import com.razorthink.webdesign.pojo.PostDetails;

/**
 * This class retrieves the post details from the database
 * 
 * @author umesh
 * 
 * @since 03-08-2016
 *
 */

public class EachPostDetails {

	public static PostDetails getPostDetails(Integer postId) {

		PostDetails result = new PostDetails();
		Connection connection = MySqlConnection.getConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "select id,description,username,price,dateofpost from postDetails where id="+postId;
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				result.setId(resultSet.getInt(1));
				result.setDescription(resultSet.getString(2));
				result.setUsername(resultSet.getString(3));
				result.setPrice(resultSet.getString(4));
				result.setDate(resultSet.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
