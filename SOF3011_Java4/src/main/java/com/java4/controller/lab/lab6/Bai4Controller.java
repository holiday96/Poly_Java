package com.java4.controller.lab.lab6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.controller.lab.lab6.dto.FavoriteDTO;
import com.java4.controller.lab.lab6.dto.ReportDTO;
import com.java4.controller.lab.lab6.dto.VideoDTO;
import com.java4.controller.lab.lab6.service.FavoriteService;
import com.java4.controller.lab.lab6.service.ReportService;
import com.java4.controller.lab.lab6.service.VideoService;

@WebServlet(urlPatterns = { "/lab/6/bai4/*" })
public class Bai4Controller extends HttpServlet {

	private static final long serialVersionUID = -9176243254299670932L;

	private VideoService videoService = new VideoService();
	private FavoriteService favoriteService = new FavoriteService();
	private ReportService reportService = new ReportService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<FavoriteDTO> videos = favoriteService.findAll();
		List<Integer> years = new ArrayList<Integer>();
		videos.forEach(i -> {
			Calendar cal = Calendar.getInstance();
			cal.setTime(i.getLikedate());
			Integer year = cal.get(Calendar.YEAR);
			if (!years.contains(year)) {
				years.add(year);
			}
		});
		request.setAttribute("years", years);

		String view = "";
		String uri = request.getRequestURI();
		if (uri.contains("random")) {
			List<VideoDTO> randoms = videoService.random10();
			request.setAttribute("videos", randoms);
			view = "/views/lab/lab6/bai4Random.jsp";
		} else if (uri.contains("year")) {
			List<ReportDTO> randoms = reportService.findFavorByYear(Integer.valueOf(request.getParameter("year")));
			request.setAttribute("videos", randoms);
			view = "/views/lab/lab6/bai4FavorByYear.jsp";
		} else {
			view = "/views/lab/lab6/bai4.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}
