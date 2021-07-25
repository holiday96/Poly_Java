package com.java4.controller.lab.lab6;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.controller.lab.lab6.dto.ReportDTO;
import com.java4.controller.lab.lab6.dto.UserDTO;
import com.java4.controller.lab.lab6.dto.VideoDTO;
import com.java4.controller.lab.lab6.service.ReportService;
import com.java4.controller.lab.lab6.service.UserService;
import com.java4.controller.lab.lab6.service.VideoService;

@WebServlet(urlPatterns = { "/lab/6/bai2/*" })
public class Bai2Controller extends HttpServlet {

	private static final long serialVersionUID = -9176243254299670932L;

	private UserService userService = new UserService();
	private VideoService videoService = new VideoService();
	private ReportService reportService = new ReportService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		String uri = request.getRequestURI();
		if (uri.contains("report")) {
			List<ReportDTO> movies = reportService.findAll();
			request.setAttribute("movies", movies);
			view = "/views/lab/lab6/bai2FavorCount.jsp";
		} else {
			view = "/views/lab/lab6/bai2.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		String uri = request.getRequestURI();
		if (uri.contains("user")) {
			try {
				UserDTO user = userService.findById(request.getParameter("user"));
				List<VideoDTO> videos = videoService.findByUser(user.getId());
				request.setAttribute("user", user);
				request.setAttribute("videos", videos);
				view = "/views/lab/lab6/bai2FindByUser.jsp";
			} catch (NullPointerException e) {
				request.setAttribute("message", "User not found!");
				view = "/views/lab/lab6/bai2.jsp";
			}
		} else if (uri.contains("keyword")) {
			try {
				List<VideoDTO> videos = videoService.findByKeyword(request.getParameter("keyword"));
				request.setAttribute("videos", videos);
				view = "/views/lab/lab6/bai2FindByKeyword.jsp";
			} catch (NullPointerException e) {
				request.setAttribute("message", "Movies not found!");
				view = "/views/lab/lab6/bai2.jsp";
			}
		} else if (uri.contains("movie")) {
			try {
				List<UserDTO> users = userService.findUsersLikeMovie(request.getParameter("movie"));
				request.setAttribute("users", users);
				view = "/views/lab/lab6/bai2FindUsersLikeVideo.jsp";
			} catch (NullPointerException e) {
				request.setAttribute("message", "Movies not found!");
				view = "/views/lab/lab6/bai2.jsp";
			}
		} else if (uri.contains("favor")) {
			String param = request.getParameter("favor");
			if (param.equals("true")) {
				List<VideoDTO> videos = videoService.findAllLike();
				request.setAttribute("videos", videos);
				view = "/views/lab/lab6/bai2FindByKeyword.jsp";
			} else {
				List<VideoDTO> videos = videoService.findAllNotLike();
				request.setAttribute("videos", videos);
				view = "/views/lab/lab6/bai2FindByKeyword.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}
