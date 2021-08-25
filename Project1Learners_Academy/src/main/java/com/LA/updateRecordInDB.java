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

@WebServlet("/updateRecordInDB")
public class updateRecordInDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet implementation class updateRecordInDB");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
		System.out.println("Values recorded: "
				+ "code for record identification=" + request.getParameter("code") 
				+ ", New code=" + request.getParameter("ncode") +", name= " + request.getParameter("name")
				+ ", Description= " + request.getParameter("desc"));
		
		if(se != null) {
			String master = (String) se.getAttribute("master");
			String[] classcol={"CLASS_CODE","CLASS_NAME","CLASS_DESCRIPTION"};
			String[] studentcol={"ROLL_NUMBER","FIRST_NAME","LAST_NAME"};
			String[] teachercol={"TEACHER_ID","FIRST_NAME","LAST_NAME"};
			String[] subjectcol={"SUB_CODE","SUBJECT","SUBJECT_DES"};
			String[] Su2CMapcol={"SU2C_CODE","SUBJECT_CODE","CLASS_CODE"};
			String[] T2SMapcol={"T2SU_CODE","TEACHER_CODE","SUBJECT_CODE"};
			String[] St2CMapcol={"ST2CMAP_CODE","ROLL_NUMBER","CLASS_CODE"};
			String[] St2SuMapcol={"ST2SUMAP_CODE","ROLL_NUMBER","SUBJECT_CODE"};
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mayank","password");
				Statement stmt = con.createStatement();
				switch (master) {
				case ("class"):{
					stmt.executeUpdate("update " + master + " set "+classcol[0]+"='"+request.getParameter("ncode")+"', "+classcol[1]
							+"='"+request.getParameter("name")+"', "+classcol[2]+"='"+request.getParameter("desc")
							+"' where "+classcol[0]+"='" + request.getParameter("code")+"'");
					break;}
				case ("student"):{
					stmt.executeUpdate("update " + master + " set "+studentcol[0]+"='"+request.getParameter("ncode")+"', "+studentcol[1]
							+"='"+request.getParameter("name")+"', "+studentcol[2]+"='"+request.getParameter("desc")
							+"' where "+studentcol[0]+"='" + request.getParameter("code")+"'");
					break;}
				case ("teacher"):{
					stmt.executeUpdate("update "+master+ " set "+teachercol[0]+"='"+ request.getParameter("ncode")+"', "+teachercol[1]
							+"='"+request.getParameter("name")+"', "+teachercol[2]+"='"+request.getParameter("desc")
							+"' where "+teachercol[0]+"='" + request.getParameter("code")+"'");
					break;}
				case ("subject"):{
					stmt.executeUpdate("update "+master+ " set "+subjectcol[0]+"='"+request.getParameter("ncode")+"', "+subjectcol[1]
							+"='"+request.getParameter("name")+"', "+subjectcol[2]+"='"+request.getParameter("desc")
							+"' where "+subjectcol[0]+"='" + request.getParameter("code")+"'");
					break;}
				case ("Su2CMap"):{
					stmt.executeUpdate("update "+master+ " set "+Su2CMapcol[0]+"='"+request.getParameter("ncode")+"', "+Su2CMapcol[1]
						+"='"+request.getParameter("name")+"', "+Su2CMapcol[2]+"='"+request.getParameter("desc")
						+"' where "+Su2CMapcol[0]+"='" + request.getParameter("code")+"'");
					break;}
				case ("T2SMap"):{
					stmt.executeUpdate("update "+master+ " set "+T2SMapcol[0]+"='"+request.getParameter("ncode")+"', "+T2SMapcol[1]
						+"='"+request.getParameter("name")+"', "+T2SMapcol[2]+"='"+request.getParameter("desc")
						+"' where "+T2SMapcol[0]+"='" + request.getParameter("code")+"'");
					break;}
				case ("St2CMap"):{
					stmt.executeUpdate("update "+master+ " set "+St2CMapcol[0]+"='"+request.getParameter("ncode")+"', "+St2CMapcol[1]
							+"='"+request.getParameter("name")+"', "+St2CMapcol[2]+"='"+request.getParameter("desc")
							+"' where "+St2CMapcol[0]+"='" + request.getParameter("code")+"'");
					break;}
				case ("St2SuMap"):{
					stmt.executeUpdate("update "+master+ " set "+St2SuMapcol[0]+"='"+request.getParameter("ncode")+"', "+St2SuMapcol[1]
							+"='"+request.getParameter("name")+"', "+St2SuMapcol[2]+"='"+request.getParameter("desc")
							+"' where "+St2SuMapcol[0]+"='" + request.getParameter("code")+"'");
					break;}}
				con.close();
				System.out.println("Value updated Successfully in DB.");
			  } catch (SQLException | ClassNotFoundException e) {
				  e.printStackTrace(); 
				  }	
			  response.sendRedirect("update");
			 
		}else {
			out.println("<html><body><center><span style='color:red'><h2>Invalid session!!!</h2><span><center>");
			out.println("<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</body></html>");
		}
	}

}
