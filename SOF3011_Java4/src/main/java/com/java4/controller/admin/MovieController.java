package com.java4.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.dto.CategoryDTO;
import com.java4.dto.MovieDTO;
import com.java4.service.ICategoryService;
import com.java4.service.IMovieService;

@WebServlet(urlPatterns = { "/admin/movie", "/admin/movie/edit" })
public class MovieController extends HttpServlet {

	private static final long serialVersionUID = 1672833033433878897L;

	@Inject
	private IMovieService movieService;
	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MovieDTO> movies = movieService.findAll();
		MovieDTO movie = new MovieDTO();
		String uri = request.getRequestURI();
		String id = request.getParameter("id");
		String view = "";
		if (uri.contains("edit")) {
			List<CategoryDTO> categories = categoryService.findAll();
			if (id != null) {
				movie = movieService.findOne(Long.valueOf(id));
				request.setAttribute("movie", movie);
			}
			request.setAttribute("categories", categories);
			view = "/views/admin/movie/edit.jsp";
		} else {
			request.setAttribute("movies", movies);
			view = "/views/admin/movie/list.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
