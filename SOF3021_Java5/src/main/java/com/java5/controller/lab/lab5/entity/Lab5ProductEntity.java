package com.java5.controller.lab.lab5.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Lab5Products")
public class Lab5ProductEntity extends Lab5BaseEntity{

	private String name;
	
	private String image;
	
	private Double price;
	
	@CreatedDate
	private Date createDate;
	
	private Boolean available;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Lab5CategoryEntity category;
	
	@OneToMany(mappedBy = "product")
	private List<Lab5OrderDetailEntity> orderDetails;
}
