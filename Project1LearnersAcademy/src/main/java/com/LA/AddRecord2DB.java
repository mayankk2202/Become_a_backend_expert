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

@WebServlet("/AddRecord2DB")
public class AddRecord2DB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet implementation class AddRecord2DB");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
		MastersDAO dao = new MasterDAOImpl();
		Record rec = new Record();
		System.out.println("Values recorded: code=" + request.getParameter("code") + ", Col2= " + request.getParameter("name") + ", col3= " + request.getParameter("desc"));

		if(se != null) {
			String master = (String) se.getAttribute("master");
			rec.setVar1(request.getParameter("code"));
			rec.setVar2(request.getParameter("name"));
			rec.setVar3(request.getParameter("desc"));
			dao.addMaster(master, rec);
			if	(master=="class"|master=="student"|master=="teacher"|master=="subject")
				response.sendRedirect("Masters");
			else response.sendRedirect("Mapping");
		}else {
			out.println("<html><body><center><span style='color:red'><h2>Invalid session!!!</h2><span><center>");
			out.println("<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</body></html>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
