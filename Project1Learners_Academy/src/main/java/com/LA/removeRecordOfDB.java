package com.LA;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/removeRecordOfDB")
public class removeRecordOfDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet implementation class removeRecordOfDB");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
		System.out.println("Values recorded: code=" + request.getParameter("code") + ", name= " + request.getParameter("name") + ", Description= " + request.getParameter("desc"));
		
		if(se != null) {
			String master = (String) se.getAttribute("master");
			String col=null;
			switch (master) {
			case ("class"):{ col="CLASS_CODE"; break;}
			case ("student"):{ col="ROLL_NUMBER"; break;}
			case ("teacher"):{ col="TEACHER_ID"; break;}
			case ("subject"):{ col="SUB_CODE"; break;}
			}
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","passworddb");
				Statement stmt = con.createStatement();
				stmt.executeUpdate("DELETE FROM "+master+" Where "+col+" = " + (String) request.getParameter("code"));
				con.close();
				System.out.println("Value Removed Successfully in DB.");
			  } catch (SQLException | ClassNotFoundException e) {
				  e.printStackTrace(); 
				  }	
			  response.sendRedirect("UpdateList.html");
			 
		}else {
			out.println("<html><body><center><span style='color:red'><h2>Invalid session!!!</h2><span><center>");
			out.println("<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</body></html>");
		}
	}

}
