package com.p.test;

import java.util.HashSet;
import java.util.Set;

public class OrderRequirement {

	private Set<String> items = new HashSet<>();

	public OrderRequirement() {

	}

	public void setOrder(String order) {
		items.add(order);
	}

	boolean checkOrder(String item) {
		return items.contains(item);
	}

	public int getItemsNumber() {
		return items.size();
	}

	boolean checkOrderIsComplete(Order order) {
		return order.items.size() == items.size();
	}
}
