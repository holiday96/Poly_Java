package com.java5.controller.lab.lab4.part2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

	private Integer id;
	private String name;
	double price;
	int quantity;
}
