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

@WebServlet("/RemoveRecordOfDB")
public class RemoveRecordOfDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet implementation class removeRecordOfDB");
		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
		MastersDAO dao = new MasterDAOImpl();
		System.out.println("Values recorded: code=" + request.getParameter("code"));
		
		if(se != null) {
			String master = (String) se.getAttribute("master");
			String Key = request.getParameter("code");
			dao.deleteMaster(master, Key);
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
