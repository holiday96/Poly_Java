package com.java4.dto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MovieDTO extends AbstractDTO<MovieDTO> {

	private String title;
	private String description;
	private String director;
	private String actors;
	private String producer;
	private String country;
	private Integer runtime;
	private Integer releaseYear;
	private Integer viewCount;
	private Integer likeCount;
	private String trailer;
	private String banner;
	private String poster;
	private Set<CategoryDTO> categories = new HashSet<CategoryDTO>();
	private Set<UserDTO> users = new HashSet<UserDTO>();
	private Set<ThemeDTO> themes = new HashSet<ThemeDTO>();
	private String[] idsCategory;

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

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
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

	public Set<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryDTO> categories) {
		this.categories = categories;
	}

	public Set<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(Set<UserDTO> users) {
		this.users = users;
	}

	public Set<ThemeDTO> getThemes() {
		return themes;
	}

	public void setThemes(Set<ThemeDTO> themes) {
		this.themes = themes;
	}

	public String[] getIdsCategory() {
		return idsCategory;
	}

	public void setIdsCategory(String[] idsCategory) {
		this.idsCategory = idsCategory;
	}

	@Override
	public String toString() {
		return "MovieDTO [title=" + title + ", description=" + description + ", director=" + director + ", actors="
				+ actors + ", producer=" + producer + ", country=" + country + ", runtime=" + runtime + ", releaseYear="
				+ releaseYear + ", viewCount=" + viewCount + ", likeCount=" + likeCount + ", trailer=" + trailer
				+ ", banner=" + banner + ", poster=" + poster + ", categories=" + categories + ", users=" + users
				+ ", themes=" + themes + ", idsCategory=" + Arrays.toString(idsCategory) + "]";
	}

}
