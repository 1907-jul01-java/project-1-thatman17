package com.revature.servlets;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.Transaction;
import com.revature.entities.TransactionDao;
import com.revature.util.*;

/**
 * Servlet implementation class Approve
 */
public class Approve extends HttpServlet {
	ConnectionUtil connectionUtil = new ConnectionUtil();
    TransactionDao function = new TransactionDao(connectionUtil.getConnection());
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		request.getRequestDispatcher("link.html").include(request, response);
		HttpSession session = request.getSession(false);
		if(session!=null) {
		int id = Integer.parseInt(request.getParameter("id"));
		int validate = 0;
		String approval = request.getParameter("approval");
		String name=(String)session.getAttribute("username");
		if (id == 0) {
			out.print("Please try again");
		} else if (approval.equals("Approve")) {
			validate = 1;
			function.approve(id, validate, name);
			out.print("Request approved!");
		} else if (approval.equals("Deny")) {
			validate = 2;
			function.approve(id, validate, name);
			out.print("Request Denied!");
		}
		} else {
			out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request,response);  
		}
	}

}

