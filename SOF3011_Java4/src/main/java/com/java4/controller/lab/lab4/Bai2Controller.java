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

@WebServlet(urlPatterns = { "/lab/4/bai2" })
public class Bai2Controller extends HttpServlet {

	private static final long serialVersionUID = -5121834079327355960L;

	private List<User> users = new ArrayList<User>();

	@Override
	public void init() throws ServletException {
		users.add(new User("Username 1", "Password 1", true));
		users.add(new User("Username 2", "Password 2", false));
		users.add(new User("Username 3", "Password 3", true));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("users", users);

		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab4/bai2.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("users", users);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab4/bai2.jsp");
		rd.forward(request, response);
	}
}
