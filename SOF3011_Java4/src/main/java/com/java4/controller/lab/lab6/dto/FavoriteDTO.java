package com.java4.controller.lab.lab6.dto;

import java.util.Date;

public class FavoriteDTO {

	private long id;
	private String video;
	private String user;
	private Date likedate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getLikedate() {
		return likedate;
	}

	public void setLikedate(Date likedate) {
		this.likedate = likedate;
	}
}
