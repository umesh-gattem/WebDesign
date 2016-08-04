package com.razorthink.webdesign.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.razorthink.webdesign.dao.LoginUser;

/**
 * 
 * This LoginServlet used to login to the application. When any user tries to login
 * to the account this servlet checks for the username and password ..if these
 * two credentials are matching then the user will be successfully logged into
 * the account
 * 
 * @author umesh
 * 
 * @since 30-07-2016
 *
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user;
		try {
			user = LoginUser.loginUser(request.getParameter("username")
					,request.getParameter("password"));
			if(user!=null){
				request.getSession().setAttribute("user", user);
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("Successful!!");
			}else{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("UnSucessful!!");
			}
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
}
