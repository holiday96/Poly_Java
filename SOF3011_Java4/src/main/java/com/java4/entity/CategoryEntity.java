package com.java4.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "categories")
	private List<MovieEntity> movies = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovieEntity> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieEntity> movies) {
		this.movies = movies;
	}

}
