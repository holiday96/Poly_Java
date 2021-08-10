package com.java4.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

	@Column(name = "releaseYear")
	private Integer releaseYear;

	@Column(name = "viewCount")
	private Integer viewCount;

	@Column(name = "likeCount")
	private Integer likeCount;

	@Column(name = "trailer")
	private String trailer;

	@Column(name = "banner")
	private String banner;

	@Column(name = "poster")
	private String poster;

	@OneToMany(mappedBy = "movie")
	private Set<EpisodeEntity> episodes = new HashSet<>();

	@ManyToMany(mappedBy = "movies", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Set<ThemeEntity> themes = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "categories_movies", joinColumns = @JoinColumn(name = "movieid"), inverseJoinColumns = @JoinColumn(name = "categoryid"))
	private Set<CategoryEntity> categories = new HashSet<>();

	@ManyToMany(mappedBy = "movies", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Set<UserEntity> users = new HashSet<>();

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

	public Set<EpisodeEntity> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(Set<EpisodeEntity> episodes) {
		this.episodes = episodes;
	}

	public Set<ThemeEntity> getThemes() {
		return themes;
	}

	public void setThemes(Set<ThemeEntity> themes) {
		this.themes = themes;
	}

	public Set<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryEntity> categories) {
		this.categories = categories;
	}

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "MovieEntity [title=" + title + ", description=" + description + ", director=" + director + ", actors="
				+ actors + ", producer=" + producer + ", country=" + country + ", runtime=" + runtime + ", releaseYear="
				+ releaseYear + ", viewCount=" + viewCount + ", likeCount=" + likeCount + ", trailer=" + trailer
				+ ", banner=" + banner + ", poster=" + poster + ", themes=" + themes + ", categories=" + categories
				+ ", users=" + users + "]";
	}

}
