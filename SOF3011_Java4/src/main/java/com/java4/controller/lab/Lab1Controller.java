package com.java4.controller.lab;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lab/1" })
public class Lab1Controller extends HttpServlet{

	private static final long serialVersionUID = 5979727585524443455L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name != null) {
			request.setAttribute("name", name);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab1.jsp");
		rd.forward(request, response);
	}

}
