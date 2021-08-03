package com.java4.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java4.dto.MovieDTO;
import com.java4.dto.UserDTO;
import com.java4.service.IMovieService;
import com.java4.service.IUserService;
import com.java4.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api/user", "/api/user/status", "/api/user/changeEmail", "/api/user/addFavor",
		"/api/user/deleteFavor" })
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

		// Check unique username and email
		if (userService.findByUsername(dto.getUsername())) {
			mapper.writeValue(response.getOutputStream(), "username exist");
		} else if (userService.findByEmail(dto.getEmail())) {
			mapper.writeValue(response.getOutputStream(), "email exist");
		} else {
			dto = userService.save(dto);
			mapper.writeValue(response.getOutputStream(), dto);
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		String uri = request.getRequestURI();
		UserDTO dto = HttpUtil.of(request.getReader()).toDTO(UserDTO.class);

		if (uri.contains("status")) {
			Boolean status = dto.isStatus();
			dto = userService.findOne(dto.getId());
			dto.setStatus(status);
			dto = userService.update(dto);
			mapper.writeValue(response.getOutputStream(), dto);
		} else

		// Check unique email
		if (uri.contains("changeEmail")) {
			if (userService.findByEmail(dto.getEmail())) {
				mapper.writeValue(response.getOutputStream(), "email exist");
			} else {
				String email = dto.getEmail();
				dto = userService.findOne(dto.getId());
				dto.setEmail(email);
				dto = userService.update(dto);
				mapper.writeValue(response.getOutputStream(), dto);
			}
		} else

		// Add favor
		if (uri.contains("addFavor")) {
			Long[] oldMovie = userService.getIdsMovieByUserID(dto.getId());
			Long[] idsMovie = Arrays.copyOf(oldMovie, oldMovie.length + dto.getIdsMovie().length);
			for (int i = oldMovie.length; i < oldMovie.length + dto.getIdsMovie().length; i++) {
				int j = 0;
				idsMovie[i] = Long.parseLong(dto.getIdsMovie()[j++]);
			}
			dto = userService.findOne(dto.getId());
			Set<MovieDTO> movies = movieService.findByIds(idsMovie);
			dto.setMovies(movies);
			dto = userService.update(dto);
			mapper.writeValue(response.getOutputStream(), dto);
		} else

		// Delete favor
		if (uri.contains("deleteFavor")) {
			Long[] oldMovie = userService.getIdsMovieByUserID(dto.getId());
			List<Long> list = new ArrayList<>();
			for (int i = 0; i < oldMovie.length; i++) {
				list.add(oldMovie[i]);
			}
			list.remove(Long.parseLong(dto.getIdsMovie()[0]));
			
			Long[] idsMovie = new Long[list.size()];
			for (int i = 0; i < list.size(); i++) {
				idsMovie[i] = list.get(i);
			}

			dto = userService.findOne(dto.getId());
			Set<MovieDTO> movies = movieService.findByIds(idsMovie);
			dto.setMovies(movies);
			dto = userService.update(dto);
			mapper.writeValue(response.getOutputStream(), dto);
		} else {
			dto = userService.update(dto);
			mapper.writeValue(response.getOutputStream(), dto);
		}
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
