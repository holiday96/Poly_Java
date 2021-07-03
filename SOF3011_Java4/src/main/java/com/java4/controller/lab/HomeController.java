package com.java4.controller.lab;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lab" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1672833033433878897L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String lab = request.getParameter("id");
		String view = "";
		if (lab != null) {
			switch (lab) {
			case "1":
				view = "/views/lab/lab1.jsp";
				break;
			case "2":
				view = "/views/lab/lab2.jsp";
				break;
			case "3":
				view = "/views/lab/lab3.jsp";
				break;
			case "4":
				view = "/views/lab/lab4.jsp";
				break;
			case "5":
				view = "/views/lab/lab5.jsp";
				break;
			case "6":
				view = "/views/lab/lab6.jsp";
				break;
			case "7":
				view = "/views/lab/lab7.jsp";
				break;
			case "8":
				view = "/views/lab/lab8.jsp";
				break;
			}
		}else {
			view = "/views/lab/home.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
