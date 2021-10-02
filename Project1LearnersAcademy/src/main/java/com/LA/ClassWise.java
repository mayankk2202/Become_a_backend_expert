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

@WebServlet("/ClassWise")
public class ClassWise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet ClassWize called");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
		MastersDAO dao = new MasterDAOImpl();

		if(se != null) {
			List<LAClass> listClasses = dao.listClassMaster();
			
			out.println("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Class Wise Report</title>"
					+ "<style>table, th, td {border: 1px solid black;border-collapse: collapse;}</style></head><body>");
			out.println("<div align=\"center\"><form method=\"post\" action=\"ClassWiseReport\">");
			out.println("<br><br><h3>Please choose the class to see the report:<select name=\"Cldesc\" id=\"Cldesc\">");
			
			for(int i=0;i<listClasses.size();i++) {
				out.println("<option value=\""+listClasses.get(i).getCldesc()+"\">"+listClasses.get(i).getCldesc()+"</option>");
			}
			
			out.println("</select></h3><button type=\"submit\">View Report</button>");
			out.println("</form><h5 align=\"center\"><form method=\"post\" action=\"Report\"><button type=\"submit\">Back to Report Selection</button></form></h5>");
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
