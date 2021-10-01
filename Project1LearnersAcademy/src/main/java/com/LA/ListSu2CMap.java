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

@WebServlet("/ListSu2CMap")
public class ListSu2CMap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet ListSu2CMap called");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
		MastersDAO dao = new MasterDAOImpl();

		if (se != null) {
			Record[] qryRes = dao.ListMappings("Su2CMap");
			
			out.println("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Subject to Class Mapping</title>"
					 +"<style>table, th, td {border: 1px solid black;border-collapse: collapse;}</style></head><body>");
			out.println("<div align=\"center\"><h3>The Subject to Class Mapping Table is as follows:</h3>");
			out.println("<table><tr><b><th>Subject Code</th><th>Subject name</th><th>Subject Description</th><th> <-- Mapped to --> </th>"
					+ "<th>Class Code</th><th>Class Name</th><th>Class Description</th></b></tr>");
			
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
