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

import com.java4.dto.EpisodeDTO;
import com.java4.dto.MovieDTO;
import com.java4.service.IEpisodeService;
import com.java4.service.IMovieService;

@WebServlet(urlPatterns = { "/admin/episode", "/admin/episode/edit" })
public class EpisodeController extends HttpServlet {

	private static final long serialVersionUID = 1672833033433878897L;

	@Inject
	private IMovieService movieService;
	@Inject
	private IEpisodeService episodeService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MovieDTO> movies = movieService.findAll();
		String uri = request.getRequestURI();
		String id = request.getParameter("id");
		String movieId = request.getParameter("movieid");
		String view = "";
		
		if (uri.contains("edit")) {
			MovieDTO movie = movieService.findOne(Long.valueOf(movieId));
			if (id != null) {
				EpisodeDTO episode = episodeService.findOne(Long.valueOf(id));
				request.setAttribute("episode", episode);
			}
			request.setAttribute("movie", movie);
			view = "/views/admin/episode/edit.jsp";
		} else {
			request.setAttribute("movies", movies);
			view = "/views/admin/episode/list.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
