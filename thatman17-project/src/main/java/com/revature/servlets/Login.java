package com.revature.servlets;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.entities.*;
import com.revature.util.*;

import com.revature.models.*;

public class Login extends HttpServlet {  
/**
	 * 
	 */
	ConnectionUtil connectionUtil = new ConnectionUtil();
    Function function = new Function(connectionUtil.getConnection());

public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException { 
	
	
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("username");  
    String p=request.getParameter("password");  
          
    if(function.validate(n, p) == 2){  
        RequestDispatcher rd=request.getRequestDispatcher("Manager");
        HttpSession session = request.getSession();
        session.setAttribute("username", n);
        rd.forward(request,response);  
    }  else if (function.validate(n, p) == 1) {
    	RequestDispatcher rd=request.getRequestDispatcher("Employee");
        HttpSession session = request.getSession();
        session.setAttribute("username", n);
        rd.forward(request,response); 
    }
    else{  
        out.print("Sorry username or password error");  
        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.include(request,response);  
    }  
          
    out.close(); 
    }  
}  