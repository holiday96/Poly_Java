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
import com.java4.service.IThemeService;
import com.java4.service.IUserService;
import com.java4.utils.SessionUtil;

@WebServlet(urlPatterns = { "/favorite" })
public class FavoriteController extends HttpServlet {

	private static final long serialVersionUID = 1672833033433878897L;

	@Inject
	private IUserService userService;
	@Inject
	private IThemeService themeService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		UserDTO user = (UserDTO) SessionUtil.getInstance().getValue(request, "USER");

		if (user == null) {
			view = "/views/web/404.jsp";
		} else {
			user = userService.findOne(user.getId());
			request.setAttribute("user", user);
			view = "/views/web/favorite.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
