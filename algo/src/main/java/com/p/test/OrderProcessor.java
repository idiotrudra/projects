package com.p.test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class OrderProcessor implements Processor<String> {

	Map<Integer, Order> mayBeOrder = new HashMap<>();
	Order minOrder;

	OrderRequirement orderRequirement = new OrderRequirement();

	public OrderProcessor(String[] orders) {
		for (int i = 1; i < orders.length; i++) {
			orderRequirement.setOrder(orders[i]);
		}

	}

	private void checkOrder(int rid, float prize, String[] items) {
		Order order = mayBeOrder.get(rid);
		boolean orderHasItem = false;
		if (null == order) {
			order = new Order(rid);
		}
		for (int i = 2; i < items.length; i++) {
			if (orderRequirement.checkOrder(items[i])) {
				order.addItem(items[i]);
				orderHasItem = true;
			}
		}
		if (orderHasItem) {
			order.addPrize(prize);
			mayBeOrder.put(rid, order);
		}

		if (orderRequirement.checkOrderIsComplete(order)) {
			considerOrder(order);
		}
	}

	public void considerOrder(Order o) {
		if (minOrder == null || minOrder.bill > o.bill) {
			minOrder = o;
		}
	}

	@Override
	public void complete() {
		if (minOrder == null) {
			System.out.println("Nil");
		} else {
			System.out.println(minOrder.restaurantId + " " + minOrder.bill);
		}
	}

	@Override
	public void process(String input) throws ParseException {
		String[] values = input.split(",");
		int rid = Integer.valueOf(values[0]);
		float prize = Float.valueOf(values[1]);
		checkOrder(rid, prize, values);
	}

}
