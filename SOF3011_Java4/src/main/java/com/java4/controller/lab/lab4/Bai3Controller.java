package com.java4.controller.lab.lab4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lab/4/bai3" })
public class Bai3Controller extends HttpServlet {

	private static final long serialVersionUID = -5121834079327355960L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Item item = new Item("Nokia 2020", "https://picsum.photos/500/500", 500, 0.1);
		request.setAttribute("item", item);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab4/bai3.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab4/bai3.jsp");
		rd.forward(request, response);
	}
}
