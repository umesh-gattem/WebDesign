package com.razorthink.webdesign.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.razorthink.webdesign.dao.ContactOwner;
import com.razorthink.webdesign.pojo.OwnerDetails;

/**
 * Servlet implementation class ContactOwnerServlet. This servlet is used to get
 * the owner details
 * 
 * @author umesh
 * 
 * @since 01-08-2016
 */
@WebServlet("/contactowner")
public class ContactOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id=request.getParameter("id");
		Integer postId=Integer.parseInt(id);
		OwnerDetails result=ContactOwner.getOwnerDetails(postId);
		Gson gson=new Gson();
		String json=gson.toJson(result);
		PrintWriter out=response.getWriter();
		out.println(json);
	}
}
