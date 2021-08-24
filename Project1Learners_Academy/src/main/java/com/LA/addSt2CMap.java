package com.LA;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addSt2CMap")
public class addSt2CMap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet addSt2CMap called");
		HttpSession se = request.getSession(false);
		PrintWriter out = response.getWriter();
		if(se != null) {
			se.setAttribute("master", "St2CMap");
			response.sendRedirect("readrecord");
		}else {
			out.println("<html><body><center><span style='color:red'><h2>Invalid session!!!</h2></Span><center>");
			out.println("<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</body></html>");
		}
	}

}
