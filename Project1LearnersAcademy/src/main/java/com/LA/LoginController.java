package com.LA;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = request.getParameter("username");
		String Pwd = request.getParameter("password");
		HttpSession se = request.getSession();
		se.setMaxInactiveInterval(60);
		
		if (ID.equalsIgnoreCase("Admin") && Pwd.equals("P@ssw0rd")) 
			response.sendRedirect("home"); 
		else {
			PrintWriter out = response.getWriter();
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			out.print("<center><span style='color:red'>Invalid User Name OR Password!!!</span></center>");
		}
		
	}

}
