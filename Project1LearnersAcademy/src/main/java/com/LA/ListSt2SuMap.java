package com.LA;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MasterDAOImpl;
import com.DAO.MastersDAO;
import com.dto.Record;

@WebServlet("/ListSt2SuMap")
public class ListSt2SuMap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet ListSt2SuMap called");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
		MastersDAO dao = new MasterDAOImpl();

		if (se != null) {
			Record[] qryRes = dao.ListMappings("St2SuMap");
			
			out.println("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Student to Subject Mapping</title>"
					 +"<style>table, th, td {border: 1px solid black;border-collapse: collapse;}</style></head><body>");
			out.println("<div align=\"center\"><h3>The Student to Subject Mapping Table is as follows:</h3>");
			out.println("<table><tr><b><th>Roll Number</th><th>First Name</th><th>Last Name</th><th> <-- Mapped to --> </th>"
					+ "<th>Subject Code</th><th>Subject name</th><th>Subject Description</th></b></tr>");
			
			for (int i=0;i<qryRes.length;i++) {
				out.println("<tr><td>"+qryRes[i].getVar1()+"</td><td>"+qryRes[i].getVar2()+"</td><td>"+qryRes[i].getVar3()+"</td><td> <-- Mapped to --> </td><td>"
									  +qryRes[i].getVar4()+"</td><td>"+qryRes[i].getVar5()+"</td><td>"+qryRes[i].getVar6()+"</td><td></tr>");
			}
			
			out.println("</table><p align=\"center\"><a href=\"Mapping\">Go to Update Master List menu</p>");
			out.println("</form></div></body></html>");
		} else {
			out.println("<html><body><center><span style='color:red'><h2>Invalid session!!!</h2><span><center>");
			out.println("<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</body></html>");
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
