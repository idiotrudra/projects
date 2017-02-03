package com.mt.countdown;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import com.algo.test.ITest;

public class CountDownTest implements ITest {

	CountDownLatch latch = new CountDownLatch(5);
	
	
	class Waiter implements Runnable{
		
		public void run(){
		System.out.println("Starting to wait for 5 threads.");
			try {
				latch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("waiter Released");
		}
	}
	
	class Worker implements Runnable{
		public void run(){
			System.out.println("doing Work thread ");
			latch.countDown();
			System.out.println("Completed Work");
		}
	}
	
	@Override
	public void PerformTest() {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Waiter());
		
		t1.start();
		
		for(int i =0; i<6;i++){
			new Thread(new Worker()).start();;
		}

	}

	
}
