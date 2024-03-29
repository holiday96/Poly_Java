package com.java4.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO extends AbstractDTO<CategoryDTO> {

	private String name;
	private List<MovieDTO> movies = new ArrayList<>();

	public CategoryDTO() {
	}

	public CategoryDTO(String name, List<MovieDTO> movies) {
		this.name = name;
		this.movies = movies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovieDTO> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieDTO> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "CategoryDTO [name=" + name + ", movies=" + movies + "]";
	}

}
