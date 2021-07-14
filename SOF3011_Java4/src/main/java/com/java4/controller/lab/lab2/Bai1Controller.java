package com.java4.controller.lab.lab2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lab/2", "/lab/2/bai1" })
public class Bai1Controller extends HttpServlet {

	private static final long serialVersionUID = 5979727585524443455L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab2/bai1.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Double a = Double.valueOf(request.getParameter("a"));
			Double b = Double.valueOf(request.getParameter("b"));
			Double c = Double.valueOf(request.getParameter("c"));
			if ((a + b > c) && (a + c > b) && (c + b > a)) {
				String action = request.getParameter("action");
				Double chuVi = a + b + c;
				if (action.equals("chu-vi")) {
					request.setAttribute("message", "Chu vi: " + chuVi);
				} else if (action.equals("dien-tich")) {
					Double dienTich = Math.sqrt(chuVi * (a + b - c) * (a + c - b) * (b + c - a)) / 4;
					request.setAttribute("message", "Diện tích: " + dienTich);
				}
			} else {
				request.setAttribute("message", "Giá trị các cạnh không thoả mãn điều kiện tổng 2 cạnh > cạnh còn lại");
			}
		} catch (NumberFormatException e) {
			request.setAttribute("message", "Vui lòng chỉ nhập ký tự số!");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab2/bai1.jsp");
		rd.forward(request, response);
	}
}
