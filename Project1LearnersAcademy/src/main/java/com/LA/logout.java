package com.LA;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession(false);
		PrintWriter out = response.getWriter();
		if(se != null) {
			se.invalidate();
			out.println("<html><style>.center {margin: auto;width: 20%;height: 51px;padding: 197px;}"
					+"body{background-image: url('Learners_Academy.png');background-repeat: no-repeat;background-attachment: fixed;background-size: 100% 100%;}</style>"
					+ "<body><div class=\"center\"><span style='color:green'><h2>You are Successfully Logged Out!!!</h2></span>"
					+"<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</div></body></html>");
		}else {
			out.println("<html><body><center><span style='color:red'><h2>Invalid session!!!</h2></Span><center>");
			out.println("<br><br><br><h4>click <a href = \"Login.html\">here</a> to login again.</body></html>");
		}
	}

}
