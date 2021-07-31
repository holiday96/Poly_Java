package com.java4.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java4.dto.EpisodeDTO;
import com.java4.service.IEpisodeService;
import com.java4.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api/episode" })
public class EpisodeAPI extends HttpServlet {

	@Inject
	private IEpisodeService episodeService;

	private static final long serialVersionUID = -4163323890724430012L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		EpisodeDTO dto = HttpUtil.of(request.getReader()).toDTO(EpisodeDTO.class);
		dto = episodeService.save(dto);
		mapper.writeValue(response.getOutputStream(), dto);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		EpisodeDTO dto = HttpUtil.of(request.getReader()).toDTO(EpisodeDTO.class);
		dto = episodeService.update(dto);
		mapper.writeValue(response.getOutputStream(), dto);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		EpisodeDTO dto = HttpUtil.of(request.getReader()).toDTO(EpisodeDTO.class);
		episodeService.delete(dto.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}
