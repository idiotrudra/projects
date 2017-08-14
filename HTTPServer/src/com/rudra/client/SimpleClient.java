package com.rudra.client;

public class SimpleClient {

	public static void main(String[] args) throws Exception {
		int maxCount = 50;
		for (int i = 1; i <= maxCount; i++) {
			Worker client = new Worker(i, maxCount);
			try {
				new Thread(client::sendGet).start();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getStackTrace());
			}
		}

	}

}
