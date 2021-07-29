package com.java4.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class MovieEntity extends BaseEntity {

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "director")
	private String director;

	@Column(name = "actors")
	private String actors;

	@Column(name = "producer")
	private String producer;

	@Column(name = "country")
	private String country;

	@Column(name = "runtime")
	private Integer runtime;

	@Column(name = "release")
	private Integer release;

	@Column(name = "view")
	private Integer view;

	@Column(name = "like")
	private Integer like;

	@Column(name = "trailer")
	private String trailer;

	@Column(name = "banner")
	private String banner;

	@Column(name = "poster")
	private String poster;

	@OneToMany(mappedBy = "movie")
	private List<EpisodeEntity> episodes = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "movies_themes", joinColumns = @JoinColumn(name = "movieid"), inverseJoinColumns = @JoinColumn(name = "themeid"))
	private List<ThemeEntity> themes = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "categories_movies", joinColumns = @JoinColumn(name = "movieid"), inverseJoinColumns = @JoinColumn(name = "categoryid"))
	private List<CategoryEntity> categories = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "favorites", joinColumns = @JoinColumn(name = "movieid"), inverseJoinColumns = @JoinColumn(name = "userid"))
	private List<UserEntity> users = new ArrayList<>();

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

	public List<EpisodeEntity> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<EpisodeEntity> episodes) {
		this.episodes = episodes;
	}

	public List<ThemeEntity> getThemes() {
		return themes;
	}

	public void setThemes(List<ThemeEntity> themes) {
		this.themes = themes;
	}

	public List<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

}
