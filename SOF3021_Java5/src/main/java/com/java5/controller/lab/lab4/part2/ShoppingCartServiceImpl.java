package com.java5.controller.lab.lab4.part2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private Map<Integer, Item> map = new HashMap<>();

	@Override
	public Item add(Integer id) {
		if (map.containsKey(id)) {
			Item item = map.get(id);
			item.setQuantity(item.getQuantity() + 1);
			return map.replace(id, item);
		} else {
			return map.put(id, DB.items.get(id));
		}
	}

	@Override
	public void remove(Integer id) {
		update(id, 1);
		map.remove(id);
	}

	@Override
	public Item update(Integer id, int quantity) {
		Item item = map.get(id);
		item.setQuantity(quantity);
		return map.replace(id, item);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Collection<Item> getItems() {
		return map.values();
	}

	@Override
	public int getCount() {
		int count = 0;
		for (Item item : map.values()) {
			count += item.getQuantity();
		}
		return count;
	}

	@Override
	public double getAmount() {
		double amount = 0;
		for (Item item : map.values()) {
			amount += item.getPrice() * item.getQuantity();
		}
		return amount;
	}
}
