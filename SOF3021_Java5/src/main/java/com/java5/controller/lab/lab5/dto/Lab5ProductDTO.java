package com.java5.controller.lab.lab5.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.java5.controller.lab.lab5.entity.Lab5CategoryEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Lab5ProductDTO extends Lab5AbstractDTO<Lab5ProductDTO>{

	private String name;
	private MultipartFile image;
	private Double price;
	private Date createDate = new Date();
	private Boolean available;
	private String categoryCode;
	private String imageURL;
	private Lab5CategoryEntity category;
}
