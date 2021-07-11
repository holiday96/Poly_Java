package com.java4.controller.lab.lab2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lab/2/bai2" })
public class Bai2Controller extends HttpServlet {

	private static final long serialVersionUID = 5979727585524443455L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab2/bai2.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("result", "oke");
		String username = request.getParameter("username");
		boolean gender = Boolean.valueOf(request.getParameter("gender"));
		boolean married = request.getParameter("married") != null;
		String country = request.getParameter("nationality");

		System.out.println(">>Username: " + username);
		System.out.println(">>Gender: " + gender);
		System.out.println(">>Married: " + married);
		System.out.println(">>Country: " + country);

		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab2/bai2.jsp");
		rd.forward(request, response);
	}
}
