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
import com.dto.LAClass;
import com.dto.Record;

@WebServlet("/FullReport")
public class FullReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet FullReport called");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
		MastersDAO dao = new MasterDAOImpl();

		if(se != null) {
			List<LAClass> listClasses = dao.listClassMaster();

			out.println("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Full Report</title>"
					+ "<style>table, th, td {border: 1px solid black;border-collapse: collapse;}</style></head><body>");
			out.println("<div align=\"center\"><br><br><h3>Below is the Class Report showing all the information about the class, "
					+ "such as the list of students, subjects, and teachers:</h3>");
			
			for (int i=0; i < listClasses.size(); i++) {
				out.println("<br><h4>"+listClasses.get(i).getCldesc()+"</h4><br><table>");
				Record[][] qryRes = dao.ClassWiseReport(listClasses.get(i).getCldesc());
				for (int j=0;j<qryRes.length;j++) {
					out.println("<tr>");
					for (int k = 0; k < qryRes[j].length; k++) {
						if(k==0 | k==1)
							out.println("<th>"+qryRes[j][k].getVar1()+"</th>");
						else
							out.println("<td>"+qryRes[j][k].getVar1()+"</td>");
					}
					out.println("</tr>");
				}
				out.println("</table>");
			}
			out.println("<h5 align=\"center\"><form method=\"post\" action=\"Report\"><button type=\"submit\">Back to Report Selection</button></form></h5>");
			out.println("</div></body></html>");
		}else {
			out.println("<html><body><center><span style='color:red'><h2>Invalid session!!!</h2></Span><center>");
			out.println("<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
