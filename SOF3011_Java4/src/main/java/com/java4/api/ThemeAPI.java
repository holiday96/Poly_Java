package com.java4.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java4.dto.ThemeDTO;
import com.java4.service.IThemeService;
import com.java4.utils.HttpUtil;
import com.test.model.NewModel;
import com.test.model.UserModel;
import com.test.utils.SessionUtil;

@WebServlet(urlPatterns = { "/api/theme" })
public class ThemeAPI extends HttpServlet {

	@Inject
	private IThemeService themeService;

	private static final long serialVersionUID = -4163323890724430012L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ThemeDTO dto = HttpUtil.of(request.getReader()).toDTO(ThemeDTO.class);
		dto = themeService.save(dto);
		mapper.writeValue(response.getOutputStream(), dto);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream newModel qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ThemeDTO dto = HttpUtil.of(request.getReader()).toDTO(ThemeDTO.class);
		dto = themeService.update(dto);
		mapper.writeValue(response.getOutputStream(), dto);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream newModel qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ThemeDTO dto = HttpUtil.of(request.getReader()).toDTO(ThemeDTO.class);
		dto = themeService.delete(dto.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}
