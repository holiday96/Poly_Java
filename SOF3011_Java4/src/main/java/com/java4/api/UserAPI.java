package com.java4.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java4.dto.UserDTO;
import com.java4.service.IMovieService;
import com.java4.service.IUserService;
import com.java4.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api/user" })
public class UserAPI extends HttpServlet {

	@Inject
	private IUserService userService;
	@Inject
	private IMovieService movieService;

	private static final long serialVersionUID = -4163323890724430012L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		UserDTO dto = HttpUtil.of(request.getReader()).toDTO(UserDTO.class);
		dto = userService.save(dto);
		mapper.writeValue(response.getOutputStream(), dto);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		UserDTO dto = HttpUtil.of(request.getReader()).toDTO(UserDTO.class);
		//test api add favor
		dto.setMovies(userService.findOne(dto.getId()).getMovies());
		dto.getMovies().add(movieService.findOne(23l));
		dto.getMovies().add(movieService.findOne(24l));
		dto = userService.update(dto);
		mapper.writeValue(response.getOutputStream(), dto);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		UserDTO dto = HttpUtil.of(request.getReader()).toDTO(UserDTO.class);
		userService.delete(dto.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}
