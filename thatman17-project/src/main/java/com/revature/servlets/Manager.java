package com.revature.servlets;

import java.io.PrintWriter;  
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			String name=(String)session.getAttribute("username");
			out.println("<!DOCTYPE HTML>");
			out.println("<html lang=\"en-us\">");
			    out.println("<meta charset=\"UTF-8\">");
			    out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
			    out.println("<title>Management</title>");
			    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			    out.println("</head>");
			out.println("<body onload=\"getMovies()\">");
			    out.println("<h1>Welcome, " + name + "</h1>");
			    out.println("<div id=\"output\">");
			        out.println("<h2>Employee Transactions</h2>");
			        out.println("<div id=\"transactions\"></div>");
			    out.println("</div>");
			    out.println("<script src='app.js'></script>");
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
