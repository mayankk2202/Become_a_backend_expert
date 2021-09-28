package com.LA;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MasterDAOImpl;
import com.DAO.MastersDAO;
import com.dto.LASubject;

@WebServlet("/ListSubjects")
public class ListSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servlet ListSubjects called");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
		MastersDAO dao = new MasterDAOImpl();

		if (se != null) {
			List<LASubject> masterlist = dao.listSubjectMaster();
			 
			 out.println("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Update Record</title>"
			 +"<style>table, th, td {border: 1px solid black;border-collapse: collapse;}</style></head><body>");
			 out.println("<div align=\"center\"><h3>The Class Master Table is as follows:</h3>");
			 out.println("<table><tr><b><th>CLASS_CODE</th><th>CLASS_NAME</th><th>CLASS_DESCRIPTION</th></b></tr>");
			 
			 for (int i=0;i<masterlist.size();i++) {
				out.println("<tr><td>"+masterlist.get(i).getSucode()+"</td><td>"+masterlist.get(i).getSub()+"</td><td>"+masterlist.get(i).getSuDes()+"</td></tr>");
			 }
			 
			 out.println("</table><p align=\"center\"><a href=\"Masters\">Go to Update Master List menu</p>");
			 out.println("</form></div></body></html>");
		} else {
			out.println("<html><body><center><span style='color:red'><h2>Invalid session!!!</h2><span><center>");
			out.println("<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
