package com.java4.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java4.dto.MovieDTO;
import com.java4.service.IMovieService;
import com.java4.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api/movie" })
public class MovieAPI extends HttpServlet {

	@Inject
	private IMovieService movieService;

	private static final long serialVersionUID = -4163323890724430012L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		MovieDTO dto = HttpUtil.of(request.getReader()).toDTO(MovieDTO.class);
		dto = movieService.save(dto);
		mapper.writeValue(response.getOutputStream(), dto);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		MovieDTO dto = HttpUtil.of(request.getReader()).toDTO(MovieDTO.class);
		dto = movieService.update(dto);
		mapper.writeValue(response.getOutputStream(), dto);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		MovieDTO dto = HttpUtil.of(request.getReader()).toDTO(MovieDTO.class);
		movieService.delete(dto.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}
