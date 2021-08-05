package com.java4.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
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
import com.java4.service.IMovieService;
import com.java4.service.IThemeService;

@WebServlet(urlPatterns = { "/admin/theme", "/admin/theme/edit" })
public class ThemeController extends HttpServlet {

	private static final long serialVersionUID = 1672833033433878897L;

	@Inject
	private IMovieService movieService;
	@Inject
	private IThemeService themeService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ThemeDTO> themes = themeService.findAll();
		String uri = request.getRequestURI();
		String view = "";
		if (uri.contains("edit")) {
			String id = request.getParameter("id");
			List<MovieDTO> movies = movieService.findAll();
			List<Long> moviesId = new ArrayList<>();
			movies.forEach(i -> moviesId.add(i.getId()));

			List<MovieDTO> moviesAdded = themeService.findOne(Long.valueOf(id)).getMovies();
			List<Long> moviesIdAdded = new ArrayList<>();
			moviesAdded.forEach(i -> moviesIdAdded.add(i.getId()));

			moviesId.removeAll(moviesIdAdded);
			movies.clear();
			moviesId.forEach(i -> movies.add(movieService.findOne(i)));

			request.setAttribute("movies", movies);
			request.setAttribute("moviesAdded", moviesAdded);
			view = "/views/admin/theme/edit.jsp";
		} else {
			request.setAttribute("themes", themes);
			view = "/views/admin/theme/list.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
