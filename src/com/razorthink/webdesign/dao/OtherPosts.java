package com.razorthink.webdesign.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.razorthink.webdesign.database.MySqlConnection;
import com.razorthink.webdesign.pojo.PostDetails;

/**
 * This class is used to collect all posts of users .
 * 
 * @author umesh
 * 
 * @since 02-08-2016
 *
 */

public class OtherPosts {
	
	public static ArrayList<PostDetails> getAllPosts() {
		
		ArrayList<PostDetails> result= new ArrayList<>();
		Connection connection=MySqlConnection.getConnection();
		try {
			Statement statement= connection.createStatement();
			String query="select * from postDetails";
			ResultSet resultSet=statement.executeQuery(query);
			while(resultSet.next()){
				PostDetails pd=new PostDetails();
				pd.setId(resultSet.getInt(1));
				pd.setDescription(resultSet.getString(3));
				pd.setUsername(resultSet.getString(4));
				pd.setPrice(resultSet.getString(5));
				pd.setDate(resultSet.getString(6));
				result.add(pd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
