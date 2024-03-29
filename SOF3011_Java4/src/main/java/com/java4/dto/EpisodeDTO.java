package com.java4.dto;

public class EpisodeDTO extends AbstractDTO<EpisodeDTO> {

	private String number;
	private Long movieid;
	private String link;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
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

	@Override
	public String toString() {
		return "EpisodeDTO [number=" + number + ", movieid=" + movieid + ", link=" + link + "]";
	}

}
