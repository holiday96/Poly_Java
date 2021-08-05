package com.java4.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThemeDTO extends AbstractDTO<ThemeDTO> {

	private String name;
	private List<MovieDTO> movies = new ArrayList<>();
	private String[] idsMovie;

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

	public String[] getIdsMovie() {
		return idsMovie;
	}

	public void setIdsMovie(String[] idsMovie) {
		this.idsMovie = idsMovie;
	}

	@Override
	public String toString() {
		return "ThemeDTO [name=" + name + ", movies=" + movies + ", idsMovie=" + Arrays.toString(idsMovie) + "]";
	}

}
