package com.p.test;

import java.util.HashSet;
import java.util.Set;

public class Order {
	int restaurantId;
	Set<String> items = new HashSet<>();
	float bill;

	public void addItem(String item) {
		items.add(item);
	}

	public void addPrize(float prize){
		bill=bill+prize;
	}
	public Order(int rid) {
		this.restaurantId = rid;
	}
}