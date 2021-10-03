package com.LA;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/readrecord")
public class readrecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet readrecord called");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
				
		if (se != null) {
			String master = (String) se.getAttribute("master");
			
			out.println("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Read Record</title></head><body>");
			out.println("<div align=\"center\"><h3>Please enter Values :</h3>");
			switch (master) {
				case("class"):{
					out.println("<div class=\"center\"><h3>Please enter Values for the Class master:</h3>");
					out.println("<form method=\"post\" action=\"AddRecord2DB\"><table><tr><td>");
					out.println("Class Code:</td><td><input type=\"text\" name=\"code\"></td>");
					out.println("</tr><tr><td>Class Name:</td><td><input type=\"text\" name=\"name\"></td>");
					out.println("</tr><tr><td>Class Description:</td><td><input type=\"text\" name=\"desc\"></td>");
					break;}
				case("student"):{
					out.println("<div class=\"center\"><h3>Please enter Values for the Student master:</h3>");
					out.println("<form method=\"post\" action=\"AddRecord2DB\"><table><tr><td>");
					out.println("Roll Number:</td><td><input type=\"text\" name=\"code\"></td>");
					out.println("</tr><tr><td>First Name:</td><td><input type=\"text\" name=\"name\"></td>");
					out.println("</tr><tr><td>Last Name:</td><td><input type=\"text\" name=\"desc\"></td>");
					break;}
				case ("teacher"):{
					out.println("<div class=\"center\"><h3>Please enter Values for the Teacher master:</h3>");
					out.println("<form method=\"post\" action=\"AddRecord2DB\"><table><tr><td>");
					out.println("Teacher ID:</td><td><input type=\"text\" name=\"code\"></td>");
					out.println("</tr><tr><td>First Name:</td><td><input type=\"text\" name=\"name\"></td>");
					out.println("</tr><tr><td>Last Name:</td><td><input type=\"text\" name=\"desc\"></td>");
					break;}
				case ("subject"):{
					out.println("<div class=\"center\"><h3>Please enter Values for the Subject master:</h3>");
					out.println("<form method=\"post\" action=\"AddRecord2DB\"><table><tr><td>");
					out.println("Subject Code:</td><td><input type=\"text\" name=\"code\"></td>");
					out.println("</tr><tr><td>Subject:</td><td><input type=\"text\" name=\"name\"></td>");
					out.println("</tr><tr><td>Subject Description:</td><td><input type=\"text\" name=\"desc\"></td>");
					break;}
				case ("Su2CMap"):{
					out.println("<div class=\"center\"><h3>Please enter Values for the Subject to Class mapping:</h3>");
					out.println("<form method=\"post\" action=\"AddRecord2DB\"><table><tr><td>");
					out.println("Subject to Class Mapping Code:</td><td><input type=\"text\" name=\"code\"></td>");
					out.println("</tr><tr><td>Subject Code:</td><td><input type=\"text\" name=\"name\"></td>");
					out.println("</tr><tr><td>Class Code:</td><td><input type=\"text\" name=\"desc\"></td>");
					break;}
				case ("T2SMap"):{
					out.println("<div class=\"center\"><h3>Please enter Values for the Teacher to Subject mapping:</h3>");
					out.println("<form method=\"post\" action=\"AddRecord2DB\"><table><tr><td>");
					out.println("Teacher to Subject Mapping Code:</td><td><input type=\"text\" name=\"code\"></td>");
					out.println("</tr><tr><td>Teacher Code:</td><td><input type=\"text\" name=\"name\"></td>");
					out.println("</tr><tr><td>Subject Code:</td><td><input type=\"text\" name=\"desc\"></td>");
					break;}
				case ("T2CMap"):{
					out.println("<div class=\"center\"><h3>Please enter Values for the Teacher to Class mapping:</h3>");
					out.println("<form method=\"post\" action=\"AddRecord2DB\"><table><tr><td>");
					out.println("Teacher to Class Mapping Code:</td><td><input type=\"text\" name=\"code\"></td>");
					out.println("</tr><tr><td>Teacher Code:</td><td><input type=\"text\" name=\"name\"></td>");
					out.println("</tr><tr><td>Class Code:</td><td><input type=\"text\" name=\"desc\"></td>");
					break;}
				case ("St2CMap"):{
					out.println("<div class=\"center\"><h3>Please enter Values for the Student to Class mapping:</h3>");
					out.println("<form method=\"post\" action=\"AddRecord2DB\"><table><tr><td>");
					out.println("Student to Class Mapping Code:</td><td><input type=\"text\" name=\"code\"></td>");
					out.println("</tr><tr><td>Roll Number:</td><td><input type=\"text\" name=\"name\"></td>");
					out.println("</tr><tr><td>Class Code:</td><td><input type=\"text\" name=\"desc\"></td>");
					break;}
				case ("St2SuMap"):{
					out.println("<div class=\"center\"><h3>Please enter Values for the Student to Subject mapping:</h3>");
					out.println("<form method=\"post\" action=\"AddRecord2DB\"><table><tr><td>");
					out.println("Student to Subject Mapping Code:</td><td><input type=\"text\" name=\"code\"></td>");
					out.println("</tr><tr><td>Roll Number:</td><td><input type=\"text\" name=\"name\"></td>");
					out.println("</tr><tr><td>Subject Code:</td><td><input type=\"text\" name=\"desc\"></td>");
					break;}
			}
			out.println("</tr><tr align=\"right\"><td></td><td><input type=\"submit\" value=\"Submit\"></td></tr>");
			out.println("</table></form></div></div></body></html>");
		}
		else {
			out.println("<html><body><center><span style='color:red'><h2>Invalid session!!!</h2><span><center>");
			out.println("<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
