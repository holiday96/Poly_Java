package com.java4.controller.lab.lab4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.controller.lab.lab3.CookieUtils;

@WebServlet(urlPatterns = {"/lab/4/bai1"})
public class Bai1Controller extends HttpServlet{

	private static final long serialVersionUID = 8870330164050706816L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab4/bai1.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");

		if (username.isEmpty()) {
			request.setAttribute("title", "Lỗi");
			request.setAttribute("message", "Type Username!");
		} else if (password.isEmpty()) {
			request.setAttribute("title", "Lỗi");
			request.setAttribute("message", "Type Password");
		} else {
			request.setAttribute("title", "Thành công");
			request.setAttribute("message", "Login success!");
			int hours = (remember == null) ? 0 : 1;
			CookieUtils.add("username", username, hours, response);
			CookieUtils.add("password", password, hours, response);
			CookieUtils.add("remember", remember, hours, response);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab4/bai1.jsp");
		rd.forward(request, response);
	}
}
