package com.java4.controller.lab.lab4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lab/4/bai4" })
public class Bai4Controller extends HttpServlet {

	private static final long serialVersionUID = -5121834079327355960L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("Nokia 2020", "https://picsum.photos/500/500", 500, 0.1));
		items.add(new Item("Samsung J2", "https://picsum.photos/500/500", 700, 0.15));
		items.add(new Item("iPhone 12", "https://picsum.photos/500/500", 900, 0.25));
		items.add(new Item("Sony Ericson", "https://picsum.photos/500/500", 55, 0.3));
		items.add(new Item("One Plus", "https://picsum.photos/500/500", 70, 0.5));
		items.add(new Item("Xiaomi Note 8", "https://picsum.photos/500/500", 200, 0.2));

		request.setAttribute("items", items);

		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab4/bai4.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab4/bai4.jsp");
		rd.forward(request, response);
	}
}
