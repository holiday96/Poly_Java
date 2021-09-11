package com.java5.controller.lab.lab5.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lab5AbstractDTO<T> {

	private Long id;
	private Integer page;
	private Integer totalPage;
	private List<T> listResult;
}
