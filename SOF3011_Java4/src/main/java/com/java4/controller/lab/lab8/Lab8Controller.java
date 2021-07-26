package com.java4.controller.lab.lab8;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.controller.lab.lab3.CookieUtils;
import com.java4.controller.lab.lab5.UserDTO;
import com.java4.controller.lab.lab5.UserService;
import com.java4.utils.FormUtil;

@WebServlet(urlPatterns = { "/lab/8/*" })
public class Lab8Controller extends HttpServlet {

	private static final long serialVersionUID = 8396094896188612102L;

	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("home")) {
			request.setAttribute("view", "/views/lab/lab8/index.jsp");
		} else if (uri.contains("about")) {
			request.setAttribute("view", "/views/lab/lab8/about.jsp");
		} else if (uri.contains("contact")) {
			request.setAttribute("view", "/views/lab/lab8/contact.jsp");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab8/lab8.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String remember = request.getParameter("remember");
		UserDTO user = FormUtil.toModel(UserDTO.class, request);
		String uri = request.getRequestURI();
		if (uri.contains("change-password")) {
			userService.update(user);
			request.setAttribute("model", user);

			int hours = (remember == null) ? 0 : 1;
			CookieUtils.add("username", user.getId(), hours, response);
			CookieUtils.add("password", user.getPassword(), hours, response);
			CookieUtils.add("remember", remember, hours, response);
		} else if (uri.contains("edit-profile")) {
			try {
				userService.update(user);
				request.setAttribute("model", user);

				int hours = (remember == null) ? 0 : 1;
				CookieUtils.add("username", user.getId(), hours, response);
				CookieUtils.add("password", user.getPassword(), hours, response);
				CookieUtils.add("remember", remember, hours, response);
			} catch (Exception e) {
				request.setAttribute("message", "Failed! Username was exists!");
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab8/lab8.jsp");
		rd.forward(request, response);
	}
}
