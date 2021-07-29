package com.java4.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(EpisodeEntity.class)
@Table(name = "episodes")
public class EpisodeEntity implements Serializable {

	private static final long serialVersionUID = 1254642648368801692L;

	@Id
	@Column(name = "number")
	private int number;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movieid")
	private MovieEntity movie;

	@Column(name = "link")
	private String link;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
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

	@Override
	public int hashCode() {
		return Objects.hash(movie, link, number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EpisodeEntity other = (EpisodeEntity) obj;
		return Objects.equals(movie, other.movie) && Objects.equals(link, other.link) && number == other.number;
	}
}
