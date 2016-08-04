package com.razorthink.webdesign.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.razorthink.webdesign.dao.RegisterUser;

/**
 * This is the RegisterServlet used to register with the new account. When the
 * user wants to create new account then this servlet will be called and the
 * user details will be stored in the database using this servlet
 * 
 * @author umesh
 * 
 * @since 30-07-2016
 *
 */
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullname=request.getParameter("fullname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("emailId");
		String mobile = request.getParameter("mobileNo");
		String address = request.getParameter("address");
		String result=RegisterUser.createUser(fullname,username,password,email,mobile,address);
		if(result!=null){
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("Success");
		}else{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("UnSucessful!!");
		}
	}
}
