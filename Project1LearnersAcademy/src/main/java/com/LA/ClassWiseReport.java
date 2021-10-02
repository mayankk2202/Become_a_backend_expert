package com.LA;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MasterDAOImpl;
import com.DAO.MastersDAO;
import com.dto.Record;

@WebServlet("/ClassWiseReport")
public class ClassWiseReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet ClassWiseReport called");
		HttpSession se = request.getSession(false);
		PrintWriter out = response.getWriter();
		MastersDAO dao = new MasterDAOImpl();
				
		if(se != null) {
			System.out.println(request.getParameter("Cldesc"));
			RequestDispatcher rd = request.getRequestDispatcher("ClassWise");
			rd.include(request, response);
			Record[][] qryRes = dao.ClassWiseReport(request.getParameter("Cldesc"));
			 
			out.println("<!DOCTYPE html><html><style>table, th, td {border: 1px solid black;border-collapse: collapse;}</style></head><body>");
			out.println("<div align=\"center\"><h3>The Class Report is as follows:</h3><table>");
					 
			for (int i=0;i<qryRes.length;i++) {
				out.println("<tr>");
				for (int j = 0; j < qryRes[i].length; j++) {
					if(j==0 | j==1)
						out.println("<th>"+qryRes[i][j].getVar1()+"</th>");
					else
						out.println("<td>"+qryRes[i][j].getVar1()+"</td>");
				}
				out.println("</tr>");
			}
			out.println("</table></form></div></body></html>");
		}else {
			out.println("<html><body><center><span style='color:red'><h2>Invalid session!!!</h2></Span><center>");
			out.println("<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
