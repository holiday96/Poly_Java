package com.java5.controller.lab.lab5.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Lab5Accounts")
public class Lab5AccountEntity extends Lab5BaseEntity{

	private String username;

	private String password;

	private String fullname;

	private String email;

	private String photo;

	private Boolean activated;

	private Boolean admin;

	@OneToMany(mappedBy = "account")
	private List<Lab5OrderEntity> orders;
}
