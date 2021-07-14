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
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("result", "oke");

		try {
			request.getParameter("married");
			request.setAttribute("married", "Đã kết hôn");
		} catch (Exception e) {
			request.setAttribute("married", "Chưa kết hôn");
		}

		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab2/bai2.jsp");
		rd.forward(request, response);
	}
}
