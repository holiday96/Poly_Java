package com.java4.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.dto.UserDTO;
import com.java4.service.IUserService;
import com.java4.utils.CookieUtils;
import com.java4.utils.FormUtil;
import com.java4.utils.SessionUtil;

@WebServlet(urlPatterns = { "/home", "/login", "/logout" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1672833033433878897L;

	@Inject
	private IUserService userService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("login")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		} else if (uri.contains("logout")) {
			SessionUtil.getInstance().removeValue(request, "USER");
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO user = FormUtil.toModel(UserDTO.class, request);
		int hours = (user.getRemember() == null) ? 0 : 1;
		CookieUtils.add("username", user.getUsername(), hours, response);
		CookieUtils.add("password", user.getPassword(), hours, response);
		CookieUtils.add("remember", user.getRemember(), hours, response);

		user = userService.findByUserLogin(user.getUsername(), user.getPassword());

		SessionUtil.getInstance().putValue(request, "USER", user);
		if (!user.isRole()) {
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			response.sendRedirect(request.getContextPath() + "/admin");
		}
	}
}
