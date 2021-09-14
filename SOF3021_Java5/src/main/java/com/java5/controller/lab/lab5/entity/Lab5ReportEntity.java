package com.java5.controller.lab.lab5.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lab5ReportEntity{

	@Id
	private Serializable group;
	private Double sum;
	private Long count;
}
