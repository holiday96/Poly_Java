package com.java5.controller.lab.lab4.part2;

import java.util.Collection;

public interface ShoppingCartService {

	Item add(Integer id);
	void remove(Integer id);
	Item update(Integer id, int quantity);
	void clear();
	Collection<Item> getItems();
	int getCount();
	double getAmount();
}
