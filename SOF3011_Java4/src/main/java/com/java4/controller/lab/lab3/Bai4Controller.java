package com.java4.controller.lab.lab3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lab/3/bai4" })
public class Bai4Controller extends HttpServlet {

	private static final long serialVersionUID = -6939678285731249702L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab3/bai4.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");

		if (!username.equalsIgnoreCase("admin")) {
			request.setAttribute("iconMessage", "danger");
			request.setAttribute("message", "Sai tên đăng nhập!");
		} else if (password.length() < 6) {
			request.setAttribute("iconMessage", "danger");
			request.setAttribute("message", "Mật khẩu bắt buộc >= 6 ký tự!");
		} else {
			request.setAttribute("iconMessage", "success");
			request.setAttribute("message", "Đăng nhập thành công");
			int hours = (remember == null) ? 0 : 1;
			CookieUtils.add("username", username, hours, response);
			CookieUtils.add("password", password, hours, response);
			CookieUtils.add("remember", remember, hours, response);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab3/bai4.jsp");
		rd.forward(request, response);
	}
}
