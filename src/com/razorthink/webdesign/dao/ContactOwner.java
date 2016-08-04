package com.razorthink.webdesign.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.razorthink.webdesign.database.MySqlConnection;
import com.razorthink.webdesign.pojo.OwnerDetails;

/**
 * This class is used to retrieve the details the owner of the post that user
 * had chosen
 * 
 * @author umesh
 * 
 * @since 03-08-2016
 *
 */

public class ContactOwner {

	public static OwnerDetails getOwnerDetails(Integer postId) {
		OwnerDetails owner=new OwnerDetails();
		Connection connection = MySqlConnection.getConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "select fullname, email, mobile, address from userDetails,"
					+ " postDetails where postDetails.userId=userDetails.id and postDetails.id="+postId;
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				owner.setUsername(resultSet.getString(1));
				owner.setMobile(resultSet.getString(3));
				owner.setEmail(resultSet.getString(2));
				owner.setAddress(resultSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return owner;
	}
}
