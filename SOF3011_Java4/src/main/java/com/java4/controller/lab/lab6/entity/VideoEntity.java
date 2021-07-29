package com.java4.controller.lab.lab6.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedNativeQueries({
		@NamedNativeQuery(
				name = "Report.random10", 
				query = "SELECT * FROM videos ORDER BY uuid() LIMIT 10", 
				resultClass = VideoEntity.class) })

@Entity
@Table(name = "videos")
public class VideoEntity {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "title")
	private String title;

	@Column(name = "poster")
	private String poster;

	@Column(name = "description")
	private String description;

	@Column(name = "active")
	private boolean active;

	@Column(name = "views")
	private int views;

	@OneToMany(mappedBy = "video")
	private List<FavoriteeEntity> favorites = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
}
