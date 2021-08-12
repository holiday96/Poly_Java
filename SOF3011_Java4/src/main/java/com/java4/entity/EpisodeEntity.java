package com.java4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "episodes")
public class EpisodeEntity extends BaseEntity {

	@Column(name = "number")
	private String number;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movieid")
	private MovieEntity movie;

	@Column(name = "link")
	private String link;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
