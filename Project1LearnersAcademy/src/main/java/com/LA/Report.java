package com.LA;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Report")
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet Report called");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
		
		if(se != null) {
			out.println("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Class Report</title></head><body>");
			out.println("<div align=\"center\"><h3>Please choose how would like to see the report:</h3>");
			out.println("<table><tr><b><th><form method=\"post\" action=\"ClassWise\"><button type=\"submit\">Class Wise Report</button></form></th><th><----------OR---------></th>");
			out.println("<th><form method=\"post\" action=\"FullReport\"><button type=\"submit\">Complete Report of All Classes</button></form></th></b></tr>");
			out.println("</table><h5 align=\"center\"><form method=\"post\" action=\"home\"><button type=\"submit\">Home</button></form></h5>");
			out.println("</form></div></body></html>");
					 
		}else {
			out.println("<html><body><center><span style='color:red'><h2>Invalid session!!!</h2></Span><center>");
			out.println("<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}   
