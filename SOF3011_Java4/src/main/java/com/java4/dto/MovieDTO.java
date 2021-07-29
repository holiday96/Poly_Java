package com.java4.dto;

public class MovieDTO extends AbstractDTO<MovieDTO>{
	
	private String title;
	private String description;
	private String director;
	private String actors;
	private String producer;
	private String country;
	private Integer runtime;
	private Integer release;
	private Integer view;
	private Integer like;
	private String trailer;
	private String banner;
	private String poster;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public Integer getRelease() {
		return release;
	}

	public void setRelease(Integer release) {
		this.release = release;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public Integer getLike() {
		return like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
}
