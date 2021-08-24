package com.LA;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addrecord2db")
public class addrecord2db extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet implementation class addrecord2db");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
		System.out.println("Values recorded: code=" + request.getParameter("code") + ", name= " + request.getParameter("name") + ", Description= " + request.getParameter("desc"));
		
		if(se != null) {
			String master = (String) se.getAttribute("master");
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","passworddb");
				PreparedStatement pstmt = con.prepareStatement("insert into "+master+" Values (?,?,?)");
				pstmt.setString(1,request.getParameter("code"));
				pstmt.setString(2,request.getParameter("name"));
				pstmt.setString(3,request.getParameter("desc"));
				pstmt.executeUpdate();
				con.close();
				System.out.println("Value added Successfully in DB.");
			  } catch (SQLException | ClassNotFoundException e) {
				  e.printStackTrace(); 
				  }	
			if	(master=="class"|master=="student"|master=="teacher"|master=="subject")
				response.sendRedirect("UpdateList.html");
			else response.sendRedirect("mapping.html");
			 
		}else {
			out.println("<html><body><center><span style='color:red'><h2>Invalid session!!!</h2><span><center>");
			out.println("<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</body></html>");
		}
	}

}
