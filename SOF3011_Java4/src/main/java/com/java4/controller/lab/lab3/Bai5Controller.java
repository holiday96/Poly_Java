package com.java4.controller.lab.lab3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lab/3/bai5" })
public class Bai5Controller extends HttpServlet {

	private static final long serialVersionUID = -6939678285731249702L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab3/bai5.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String to = request.getParameter("to");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");

		String resultMessage;

		try {
			EmailUtils.sendEmail(to, subject, message);
			resultMessage = "The e-mail was sent successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			resultMessage = "There were an error: " + ex.getMessage();
		}
		request.setAttribute("message", resultMessage);
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab3/bai5.jsp");
		rd.forward(request, response);
	}
}
