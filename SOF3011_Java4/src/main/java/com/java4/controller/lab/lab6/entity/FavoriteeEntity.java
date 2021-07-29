package com.java4.controller.lab.lab6.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "favorites", uniqueConstraints = { @UniqueConstraint(columnNames = { "videoid", "userid" }) })
public class FavoriteeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "videoid")
	private VideoEntity video;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private UserrEntity user;

	@Temporal(TemporalType.DATE)
	private Date likeDate = new Date();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public VideoEntity getVideo() {
		return video;
	}

	public void setVideo(VideoEntity video) {
		this.video = video;
	}

	public UserrEntity getUser() {
		return user;
	}

	public void setUser(UserrEntity user) {
		this.user = user;
	}

	public Date getLikedate() {
		return likeDate;
	}

	public void setLikedate(Date likedate) {
		this.likeDate = likedate;
	}
}
