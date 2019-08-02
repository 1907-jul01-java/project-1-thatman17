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
 * Servlet implementation class Insert
 */
public class Insert extends HttpServlet {
       
	ConnectionUtil connectionUtil = new ConnectionUtil();
    TransactionDao function = new TransactionDao(connectionUtil.getConnection());
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		request.getRequestDispatcher("link.html").include(request, response);
		HttpSession session = request.getSession(false);
		if(session!=null) {
		String name=(String)session.getAttribute("username");
		
		double c = Double.parseDouble(request.getParameter("cost"));
		String p = request.getParameter("picture");
		function.insert(new Transaction(name, c, p));
		
		out.println("<h3> Your ticket has been added!</h3");
		} else {
			out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request,response);  
		}
	}

}
