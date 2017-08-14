package com.rudra.client;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Worker {

	private int count;

	private static AtomicInteger currentCount = new AtomicInteger(1);

	private boolean sleept = false;

	private static Object lock = new Object();

	private Caller caller = CallerFactory.newCaller();

	private int maxCount;

	public Worker(int count, int maxCount) {
		this.count = count;
		this.maxCount = maxCount;
	}

	public void sendGet() {

		while (true) {
			try {
				if (!sleept) {
					TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(0, 5));
					sleept = true;
				}

				callServer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
			}
		}
	}

	private void callServer() {
		if (currentCount.get() == count) {
			synchronized (lock) {
				try {
					while (!currentCount.compareAndSet(count, count + 1)) {
						lock.wait();
					}

					System.out.println(caller.getRemoteResponse() + "the thread number is : " + count);

				} catch (Exception cause) {
					cause.printStackTrace();
					System.out.println("Error while running thread" + cause.getMessage());
				} finally {
					currentCount.compareAndSet(maxCount + 1, 1);
					lock.notifyAll();
					sleept = false;
				}

			}
		}
	}
}
