package com.razorthink.webdesign.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.razorthink.webdesign.dao.CreatePost;

/**
 * Servlet implementation class CreatePostServlet.This servlet adds the new post
 * details and insert those details to database
 * 
 * @author umesh
 * 
 * @since 01-08-2016
 */

@WebServlet("/newPost")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user=(String) request.getSession().getAttribute("user");
		String result = CreatePost.insertPostDetails(request.getParameter("description"),
				user, request.getParameter("price"));
		PrintWriter out = response.getWriter();
		out.println(result);
	}
}
