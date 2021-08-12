package com.java4.controller.web;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.dto.MovieDTO;
import com.java4.dto.ThemeDTO;
import com.java4.dto.UserDTO;
import com.java4.service.IMovieService;
import com.java4.service.IThemeService;
import com.java4.service.IUserService;
import com.java4.utils.CookieUtils;
import com.java4.utils.FormUtil;
import com.java4.utils.SessionUtil;

@WebServlet(urlPatterns = { "/home", "/info", "/login", "/logout", "/search", "/block" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1672833033433878897L;

	@Inject
	private IUserService userService;
	@Inject
	private IThemeService themeService;
	@Inject
	private IMovieService movieService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		String uri = request.getRequestURI();
		if (uri.contains("block")) {
			view = "/views/web/block.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		} else if (uri.contains("login")) {
			view = "/views/login.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		} else if (uri.contains("logout")) {
			SessionUtil.getInstance().removeValue(request, "USER");
			response.sendRedirect(request.getContextPath() + "/home");
		} else if (uri.contains("info")) {
			UserDTO user = (UserDTO) SessionUtil.getInstance().getValue(request, "USER");
			if (user == null) {
				view = "/views/web/404.jsp";
			} else {
				user = userService.findOne(user.getId());
				request.setAttribute("user", user);
				view = "/views/web/infoUser.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		} else if (uri.contains("search")) {
			String key = request.getParameter("key");
			UserDTO user = (UserDTO) SessionUtil.getInstance().getValue(request, "USER");
			if (user != null) {
				user = userService.findOne(user.getId());
				request.setAttribute("user", user);
			}
			List<MovieDTO> movies = movieService.findByTitle(key);
			if (movies.isEmpty()) {
				view = "/views/web/404.jsp";
			} else {
				request.setAttribute("movies", movies);
				view = "/views/web/search.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		} else {
			List<MovieDTO> movies = movieService.findAll();
			Collections.reverse(movies);
			request.setAttribute("movies", movies);
			UserDTO user = (UserDTO) SessionUtil.getInstance().getValue(request, "USER");
			if (user != null) {
				user = userService.findOne(user.getId());
				request.setAttribute("user", user);
			}
			List<ThemeDTO> themes = themeService.findAll();
			request.setAttribute("themes", themes);

			view = "/views/web/home.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
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
