package com.java4.controller.lab.lab6;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.controller.lab.lab6.dto.UserDTO;
import com.java4.controller.lab.lab6.dto.VideoDTO;
import com.java4.controller.lab.lab6.service.UserService;
import com.java4.controller.lab.lab6.service.VideoService;

@WebServlet(urlPatterns = { "/lab/6/bai3*" })
public class Bai3Controller extends HttpServlet {

	private static final long serialVersionUID = -9176243254299670932L;

	private UserService userService = new UserService();
	private VideoService videoService = new VideoService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab6/bai3.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		String uri = request.getRequestURI();
		if (uri.contains("keyword")) {
			try {
				List<VideoDTO> videos = videoService.findByKeyword(request.getParameter("keyword"));
				request.setAttribute("videos", videos);
				view = "/views/lab/lab6/bai3FindByKeyword.jsp";
			} catch (NullPointerException e) {
				request.setAttribute("message", "Movies not found!");
				view = "/views/lab/lab6/bai3.jsp";
			}
		} else if (uri.contains("user")) {
			try {
				UserDTO user = userService.findById(request.getParameter("user"));
				List<VideoDTO> videos = videoService.findByUser(user.getId());
				request.setAttribute("user", user);
				request.setAttribute("videos", videos);
				view = "/views/lab/lab6/bai3FindByUser.jsp";
			} catch (NullPointerException e) {
				request.setAttribute("message", "User not found!");
				view = "/views/lab/lab6/bai3.jsp";
			}
		} else if (uri.contains("like-date")) {
			List<VideoDTO> videos = videoService.findRangeLikeDate(Date.valueOf(request.getParameter("minDate")),
					Date.valueOf(request.getParameter("maxDate")));
			request.setAttribute("videos", videos);
			view = "/views/lab/lab6/bai3LikeDate.jsp";
		} else if (uri.contains("like-month")) {
			String[] a = request.getParameterValues("month");
			List<Integer> ints = new ArrayList<Integer>();
			for (String i : a) {
				ints.add(Integer.valueOf(i));
			}
			List<VideoDTO> videos = videoService.findFavorByMonth(ints);
			request.setAttribute("months", ints);
			request.setAttribute("videos", videos);
			view = "/views/lab/lab6/bai3FindFavorByMonth.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}
