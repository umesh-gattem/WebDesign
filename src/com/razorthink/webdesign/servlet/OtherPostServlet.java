package com.razorthink.webdesign.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.razorthink.webdesign.dao.OtherPosts;
import com.razorthink.webdesign.pojo.PostDetails;

/**
 * Servlet implementation class OtherPosts. This servlet is used to collect all
 * posts of users except the user who logged in.
 * 
 */

@WebServlet("/otherPosts")

public class OtherPostServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    ArrayList<PostDetails> result = OtherPosts.getAllPosts();
	    PrintWriter out=response.getWriter();
	    Gson gson = new Gson();
	    String json = gson.toJson(result);
	    out.println(json);
	}
}
