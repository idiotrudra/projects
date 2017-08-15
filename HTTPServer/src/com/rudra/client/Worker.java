package com.rudra.client;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Worker {

	private int count;

	private static AtomicInteger currentCount = new AtomicInteger(1);

	private boolean sleept = false;

	private Caller caller = CallerFactory.newCaller();

	private int maxCount;

	public Worker(int count, int maxCount) {
		this.count = count;
		this.maxCount = maxCount;
	}

	public void sendGet() {
		String response = "";
		while (true) {

			try {
				if (!sleept) {
					TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(0, 5));
					response = caller.getRemoteResponse();
					sleept = true;
				}

				callServer(response);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
			}
		}
	}

	private void callServer(String response) {
		int partyCount = 1000;
		try {
			while (!currentCount.compareAndSet(count, count + partyCount)) {

			}

			System.out.println(response + "the thread number is : " + count);
			while (!currentCount.compareAndSet(count + partyCount, count + 1)) {

			}
		} catch (Exception cause) {
			cause.printStackTrace();
			System.out.println("Error while running thread" + cause.getMessage());
		} finally {
			currentCount.compareAndSet(maxCount + 1, 1);
			sleept = false;
		}

	}

}
