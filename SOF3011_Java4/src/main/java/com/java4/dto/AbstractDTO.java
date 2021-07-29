package com.java4.dto;

import java.util.ArrayList;
import java.util.List;

public class AbstractDTO<T> {

	private Long id;
	private Long[] ids;
	private List<T> listResult = new ArrayList<>();
	private String alert;
	private String message;
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public List<T> getListResult() {
		return listResult;
	}

	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
