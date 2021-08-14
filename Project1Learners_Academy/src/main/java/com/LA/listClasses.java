package com.LA;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/listClasses")
public class listClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet listClasses called");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
		
		if(se != null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","passworddb");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from class order by CLASS_NAME");
				out.println("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Update Record</title>"
						+ "<style>table, th, td {border: 1px solid black;border-collapse: collapse;}</style></head><body>");
				out.println("<div align=\"center\"><h3>The Class Master Table is as follows:</h3>");
				out.println("<table>"
						+ "<tr><b><th>CLASS_CODE</th><th>CLASS_NAME</th><th>CLASS_DESCRIPTION</th></b></tr>");
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
