package com.java4.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java4.dto.MovieDTO;
import com.java4.dto.ThemeDTO;
import com.java4.service.IMovieService;
import com.java4.service.IThemeService;
import com.java4.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api/theme" })
public class ThemeAPI extends HttpServlet {

	@Inject
	private IThemeService themeService;
	@Inject
	private IMovieService movieService;

	private static final long serialVersionUID = -4163323890724430012L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ThemeDTO dto = HttpUtil.of(request.getReader()).toDTO(ThemeDTO.class);
		dto = themeService.save(dto);
		mapper.writeValue(response.getOutputStream(), dto);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ThemeDTO dto = HttpUtil.of(request.getReader()).toDTO(ThemeDTO.class);
		
		if (dto.getIdsMovie() != null) {
			Long[] idsMovie = new Long[dto.getIdsMovie().length];
			for (int i = 0; i < dto.getIdsMovie().length; i++) {
				idsMovie[i] = Long.parseLong(dto.getIdsMovie()[i]);
			}
			List<MovieDTO> movies = movieService.findListByIds(idsMovie);
			dto = themeService.findOne(dto.getId());
			dto.setMovies(movies);
			System.out.println(dto.toString());
		}
		dto = themeService.update(dto);
		mapper.writeValue(response.getOutputStream(), dto);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ThemeDTO dto = HttpUtil.of(request.getReader()).toDTO(ThemeDTO.class);
		themeService.delete(dto.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}
