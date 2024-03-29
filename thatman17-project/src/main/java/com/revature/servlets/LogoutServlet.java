package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;  
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

/**
 * Servlet implementation class Logout
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		request.getRequestDispatcher("redo.html").include(request, response);
		
		HttpSession session=request.getSession();
		session.invalidate();
		
		out.print("You are successfully logged out!");
		
		out.close();
	}

}