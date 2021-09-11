package com.java5.controller.lab.lab5.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Lab5Categories")
public class Lab5CategoryEntity extends Lab5BaseEntity{
	
	@NotBlank(message = "Category code is empty")
	private String code;
	
	@NotBlank(message = "Category name is empty")
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Lab5ProductEntity> products;
}
