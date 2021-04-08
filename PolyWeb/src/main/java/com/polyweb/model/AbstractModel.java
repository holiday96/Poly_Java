package com.polyweb.model;

import java.util.List;

public class AbstractModel<T> {
	private Integer id;
	private List<T> listResult;

	public Integer getId() {
		return id;
	}

	public List<T> getListResult() {
		return listResult;
	}

	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
