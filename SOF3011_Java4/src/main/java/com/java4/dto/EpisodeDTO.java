package com.java4.dto;

public class EpisodeDTO extends AbstractDTO<EpisodeDTO> {

	private Integer number;
	private Long movieid;
	private String link;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Long getMovieid() {
		return movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
