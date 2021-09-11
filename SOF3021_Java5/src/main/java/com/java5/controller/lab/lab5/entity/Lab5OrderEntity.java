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

@Getter
@Setter
@Entity
@Table(name = "Lab5Order")
public class Lab5OrderEntity extends Lab5BaseEntity{

	private String address;

	@CreatedDate
	private Date createDate;

	@ManyToOne
	@JoinColumn(name = "username")
	private Lab5AccountEntity account;

	@OneToMany(mappedBy = "order")
	private List<Lab5OrderDetailEntity> orderDetails;
}
