package com.java5.controller.lab.lab3;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	private String image;

	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	@Min(0)
	@Max(10)
	private Double marks;
	
	@NotNull
	private Boolean gender;

	@NotBlank
	private String faculty;
	
	@NotEmpty
	private List<String> hobbies;
}
