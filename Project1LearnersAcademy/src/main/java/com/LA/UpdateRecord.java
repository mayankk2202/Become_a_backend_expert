package com.LA;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateRecord")
public class UpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet updateRecord called");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
				
		if (se != null) {
			String master = (String) se.getAttribute("master");
			out.println("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Update Record</title></head><body>");
			out.println("<div align=\"center\"><h3>Please enter Values for the record to be Updated/Modified:</h3>");
			out.println("<form method=\"post\" action=\"UpdateRecordInDB\">");
			switch (master) {
			case ("class"):{
				out.println("<table><tr><td>Class Code:</td><td><input type=\"text\" name=\"code\"></td></tr></table>");
				out.println("<h3>Please enter New Values for the Class master:</h3>");
				out.println("<table><tr><td>New Name:</td><td><input type=\"text\" name=\"name\"></td>");
				out.println("</tr><tr><td>New Description:</td><td><input type=\"text\" name=\"desc\"></td>");
				break;
				}
			case ("student"):{
				out.println("<table><tr><td>Roll Number:</td><td><input type=\"text\" name=\"code\"></td></tr></table>");
				out.println("<h3>Please enter New Values for the Student master:</h3>");
				out.println("<table><tr><td>New First Name:</td><td><input type=\"text\" name=\"name\"></td>");
				out.println("</tr><tr><td>New Last Name:</td><td><input type=\"text\" name=\"desc\"></td>");
				break;
				}
			case ("teacher"):{
				out.println("<table><tr><td>Teacher ID:</td><td><input type=\"text\" name=\"code\"></td></tr></table>");
				out.println("<h3>Please enter New Values for the Teacher master:</h3>");
				out.println("<table><tr><td>New First Name:</td><td><input type=\"text\" name=\"name\"></td>");
				out.println("</tr><tr><td>New Last Name:</td><td><input type=\"text\" name=\"desc\"></td>");
				break;
				}
			case ("subject"):{
				out.println("<table><tr><td>Subject Code:</td><td><input type=\"text\" name=\"code\"></td></tr></table>");
				out.println("<h3>Please enter New Values for the Subject master:</h3>");
				out.println("<table><tr><td>New Subject Name:</td><td><input type=\"text\" name=\"name\"></td>");
				out.println("</tr><tr><td>New Subject Description:</td><td><input type=\"text\" name=\"desc\"></td>");
				break;
				}
			case ("Su2CMap"):{
				out.println("<table><tr><td>Subject to Class Mapping Code:</td><td><input type=\"text\" name=\"code\"></td></tr></table>");
				out.println("<h3>Please enter New Values for Subject to Class Mapping:</h3>");
				out.println("<table><tr><td>Subject Code:</td><td><input type=\"text\" name=\"name\"></td>");
				out.println("</tr><tr><td>Class Code:</td><td><input type=\"text\" name=\"desc\"></td>");
				break;
				}
			case ("T2SMap"):{
				out.println("<table><tr><td>Teacher to Subject Mapping Code:</td><td><input type=\"text\" name=\"code\"></td></tr></table>");
				out.println("<h3>Please enter New Values for Teacher to Subject Mapping:</h3>");
				out.println("<table><tr><td>Teacher ID:</td><td><input type=\"text\" name=\"name\"></td>");
				out.println("</tr><tr><td>Subject Code:</td><td><input type=\"text\" name=\"desc\"></td>");
				break;
				}
			case ("T2CMap"):{
				out.println("<table><tr><td>Teacher to Class Mapping Code:</td><td><input type=\"text\" name=\"code\"></td></tr></table>");
				out.println("<h3>Please enter New Values for Teacher to Class Mapping:</h3>");
				out.println("<table><tr><td>Teacher ID:</td><td><input type=\"text\" name=\"name\"></td>");
				out.println("</tr><tr><td>Class Code:</td><td><input type=\"text\" name=\"desc\"></td>");
				break;
				}
			case ("St2CMap"):{
				out.println("<table><tr><td>Student to Class Mapping Code:</td><td><input type=\"text\" name=\"code\"></td></tr></table>");
				out.println("<h3>Please enter New Values for Student to Class Mapping:</h3>");
				out.println("<table></tr><tr><td>Roll Number:</td><td><input type=\"text\" name=\"name\"></td>");
				out.println("</tr><tr><td>Class Code:</td><td><input type=\"text\" name=\"desc\"></td>");
				break;
				}
			case ("St2SuMap"):{
				out.println("<table><tr><td>Student to Subject Mapping Code:</td><td><input type=\"text\" name=\"code\"></td></tr></table>");
				out.println("<h3>Please enter New Values for Student to Subject Mapping:</h3>");
				out.println("<table><tr><td>Roll Number:</td><td><input type=\"text\" name=\"name\"></td>");
				out.println("</tr><tr><td>Subject Code:</td><td><input type=\"text\" name=\"desc\"></td>");
				break;
				}
			}
			out.println("</tr><tr align=\"right\"><td></td><td><input type=\"submit\" value=\"Submit\"></td></tr>");
			out.println("</table></form></div></body></html>");
		}else {
			out.println("<html><body><center><span style='color:red'><h2>Invalid session!!!</h2><span><center>");
			out.println("<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
