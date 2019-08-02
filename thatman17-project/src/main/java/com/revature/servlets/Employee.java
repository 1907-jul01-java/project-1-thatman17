package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.entities.*;
import com.revature.util.*;

/**
 * Servlet implementation class Employee
 */
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ConnectionUtil connectionUtil = new ConnectionUtil();
    OtherFunction function = new OtherFunction(connectionUtil.getConnection());
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			String name=(String)session.getAttribute("username");
			out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            out.println("<link rel = \"stylesheet\" href=\"main.css\"");
            out.println("</head>");
            out.println("<body>");
			out.println("<h1>Welcome, Employee " + name + "</h1>");
			out.println("<div class=\"block\"></div>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>Username</th>");
			out.println("<th>Cost</th>");
			out.println("<th>Reason</th>");
			out.println(function.getEmployee(name));
			out.println("</table>");
			out.println("</body>");
            out.println("</html>");
        }  
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }  
        out.close(); 
	}

}
