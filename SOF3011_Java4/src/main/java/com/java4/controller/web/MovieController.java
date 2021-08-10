package com.java4.controller.web;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.dto.EpisodeDTO;
import com.java4.dto.MovieDTO;
import com.java4.dto.UserDTO;
import com.java4.service.IEpisodeService;
import com.java4.service.IMovieService;
import com.java4.service.IUserService;
import com.java4.utils.SessionUtil;

@WebServlet(urlPatterns = { "/movie" })
public class MovieController extends HttpServlet {

	private static final long serialVersionUID = 1672833033433878897L;

	@Inject
	private IEpisodeService episodeService;
	@Inject
	private IMovieService movieService;
	@Inject
	private IUserService userService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String ep = request.getParameter("ep");
		MovieDTO movie = movieService.findOne(Long.valueOf(id));
		request.setAttribute("movie", movie);
		List<EpisodeDTO> episodes = episodeService.findByMovieID(Long.valueOf(id));
		request.setAttribute("episodes", episodes);
		request.setAttribute("countEpisode", episodes.size());
		if (ep != null) {
			EpisodeDTO episode = episodeService.findOne(Long.valueOf(ep));
			request.setAttribute("link", episode.getLink());
			request.setAttribute("epNumber", episode.getNumber());
		} else {
			request.setAttribute("epNumber", 0);
		}

		if (id != null) {
			UserDTO user = (UserDTO) SessionUtil.getInstance().getValue(request, "USER");
			if (user != null) {
				user = userService.findOne(user.getId());
				request.setAttribute("user", user);
				if (checkFavor(user.getMovies(), id)) {
					request.setAttribute("added", 1);
				} else {
					request.setAttribute("added", 0);
				}
			} else {
				request.setAttribute("added", 0);
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("/views/web/movieDetail.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		UserDTO user = FormUtil.toModel(UserDTO.class, request);
//		int hours = (user.getRemember() == null) ? 0 : 1;
//		CookieUtils.add("username", user.getUsername(), hours, response);
//		CookieUtils.add("password", user.getPassword(), hours, response);
//		CookieUtils.add("remember", user.getRemember(), hours, response);
//
//		user = userService.findByUserLogin(user.getUsername(), user.getPassword());
//
//		SessionUtil.getInstance().putValue(request, "USER", user);
//		if (!user.isRole()) {
//			response.sendRedirect(request.getContextPath() + "/home");
//		} else {
//			response.sendRedirect(request.getContextPath() + "/admin");
//		}
	}

	private boolean checkFavor(Set<MovieDTO> movies, String id) {
		for (MovieDTO i : movies) {
			if (i.getId().equals(Long.valueOf(id))) {
				return true;
			}
		}
		return false;
	}
}
