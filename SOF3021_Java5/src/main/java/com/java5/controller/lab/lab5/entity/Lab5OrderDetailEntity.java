package com.java5.controller.lab.lab5.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Lab5OrderDetails")
public class Lab5OrderDetailEntity extends Lab5BaseEntity{

	private Double price;

	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Lab5ProductEntity product;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Lab5OrderEntity order;
}
