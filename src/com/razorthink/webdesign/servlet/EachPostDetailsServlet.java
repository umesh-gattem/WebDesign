package com.razorthink.webdesign.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.razorthink.webdesign.dao.EachPostDetails;
import com.razorthink.webdesign.pojo.PostDetails;

/**
 * Servlet implementation class EachPostDetailsServlet. This servlet is used to
 * get the post details of which the user had chosen
 */
@WebServlet("/eachposts")
public class EachPostDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Integer postId = Integer.parseInt(id);
		PostDetails result = EachPostDetails.getPostDetails(postId);
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String json = gson.toJson(result);
		out.println(json);
	}
}
