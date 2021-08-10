package com.java4.api;

import java.io.IOException;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java4.dto.CategoryDTO;
import com.java4.dto.MovieDTO;
import com.java4.service.ICategoryService;
import com.java4.service.IMovieService;
import com.java4.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api/movie", "/api/movie/like", "/api/movie/view" })
public class MovieAPI extends HttpServlet {

	@Inject
	private IMovieService movieService;
	@Inject
	private ICategoryService categoryService;

	private static final long serialVersionUID = -4163323890724430012L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		MovieDTO dto = HttpUtil.of(request.getReader()).toDTO(MovieDTO.class);

		// add categories to movie by Manual
		if (dto.getIdsCategory() != null) {
			Long[] idsCategory = new Long[dto.getIdsCategory().length];
			for (int i = 0; i < dto.getIdsCategory().length; i++) {
				idsCategory[i] = Long.parseLong(dto.getIdsCategory()[i]);
			}
			Set<CategoryDTO> categories = categoryService.findByIds(idsCategory);
			dto.setCategories(categories);
			dto.setLikeCount(0);
			dto.setViewCount(0);
		}
		dto = movieService.save(dto);
		mapper.writeValue(response.getOutputStream(), dto);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper dùng để đọc outputstream dto qua json
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		String uri = request.getRequestURI();
		MovieDTO dto = HttpUtil.of(request.getReader()).toDTO(MovieDTO.class);
		MovieDTO old = movieService.findOne(dto.getId());
		
		if (dto.getIdsCategory() != null) {
			Long[] idsCategory = new Long[dto.getIdsCategory().length];
			for (int i = 0; i < dto.getIdsCategory().length; i++) {
				idsCategory[i] = Long.parseLong(dto.getIdsCategory()[i]);
			}
			Set<CategoryDTO> categories = categoryService.findByIds(idsCategory);
			dto.setCategories(categories);
			dto.setLikeCount(old.getLikeCount());
			dto.setViewCount(old.getViewCount());
		}

		if (uri.contains("like")) {
			dto.setActors(old.getActors());
			dto.setBanner(old.getBanner());
			dto.setCategories(old.getCategories());
			dto.setCountry(old.getCountry());
			dto.setDescription(old.getDescription());
			dto.setDirector(old.getDirector());
			dto.setViewCount(old.getViewCount());
			dto.setPoster(old.getPoster());
			dto.setProducer(old.getProducer());
			dto.setReleaseYear(old.getReleaseYear());
			dto.setRuntime(old.getRuntime());
			dto.setTitle(old.getTitle());
			dto.setTrailer(old.getTrailer());
		}
		
		if (uri.contains("view")) {
			dto.setActors(old.getActors());
			dto.setBanner(old.getBanner());
			dto.setCategories(old.getCategories());
			dto.setCountry(old.getCountry());
			dto.setDescription(old.getDescription());
			dto.setDirector(old.getDirector());
			dto.setLikeCount(old.getLikeCount());
			dto.setPoster(old.getPoster());
			dto.setProducer(old.getProducer());
			dto.setReleaseYear(old.getReleaseYear());
			dto.setRuntime(old.getRuntime());
			dto.setTitle(old.getTitle());
			dto.setTrailer(old.getTrailer());
		}
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
