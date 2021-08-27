package com.LA;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/listTeacher")
public class listTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet listTeacher called");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
		
		if(se != null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mayank","password");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from teacher");
				out.println("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Update Record</title>"
						+ "<style>table, th, td {border: 1px solid black;border-collapse: collapse;}</style></head><body>");
				out.println("<div align=\"center\"><h3>The Teacher Master Table is as follows:</h3>");
				out.println("<table>"
						+ "<tr><b><th>TEACHER_ID</th><th>FIRST_NAME</th><th>LAST_NAME</th></b></tr>");
				while(rs.next()) {
					out.println("<tr><td>"+rs.getString(1)+"</td><td>" + rs.getString(2) + "</td><td>"+ rs.getString(3) +"</td></tr>");
				}
				out.println("</table><p align=\"center\"><a href=\"update\">Go to Update Master List menu</p>");
				out.println("</form></div></body></html>");
				con.close();
			} catch (ClassNotFoundException|SQLException e) {e.printStackTrace();}
			}else {
			out.println("<html><body><center><span style='color:red'><h2>Invalid session!!!</h2><span><center>");
			out.println("<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</body></html>");
		}
	}

}
