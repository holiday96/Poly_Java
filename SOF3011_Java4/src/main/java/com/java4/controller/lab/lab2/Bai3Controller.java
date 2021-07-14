package com.java4.controller.lab.lab2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lab/2/bai3" })
public class Bai3Controller extends HttpServlet {

	private static final long serialVersionUID = 5979727585524443455L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab2/bai3.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("result", "oke");

		String married = request.getParameter("married");
		String[] hobbies = request.getParameterValues("hobbies");

		if (married != null) {
			request.setAttribute("married", "Đã kết hôn");
		} else {
			request.setAttribute("married", "Chưa kết hôn");
		}
		if (hobbies != null) {
			StringBuilder listHobby = new StringBuilder();
			for (String i : hobbies) {
				listHobby.append(i + ", ");
			}
			request.setAttribute("hobbies", listHobby.substring(0, listHobby.length() - 2));
		} else {
			request.setAttribute("hobbies", "Trống");
		}

		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab2/bai3.jsp");
		rd.forward(request, response);
	}
}
