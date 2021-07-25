package com.java4.controller.lab.lab6.dto;

import java.util.Date;

public class ReportDTO {

	private String title;
	private Long likes;
	private Date newest;
	private Date oldest;

	public ReportDTO() {
	}

	public ReportDTO(String title, Long likes, Date newest, Date oldest) {
		this.title = title;
		this.likes = likes;
		this.newest = newest;
		this.oldest = oldest;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Date getNewest() {
		return newest;
	}

	public void setNewest(Date newest) {
		this.newest = newest;
	}

	public Date getOldest() {
		return oldest;
	}

	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}
}
