package com.mt.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.algo.test.ITest;

public class BarrierTest implements ITest{

	
	class BarrierAction implements Runnable{
		int a =0;
		
		public BarrierAction(int number) {
			// TODO Auto-generated constructor stub
			this.a=number;
		}
			public void run(){
				System.out.println("Barrier action complete"+a);
			}
	}

	@Override
	public void PerformTest() {
		// TODO Auto-generated method stub
		BarrierAction a = new BarrierAction(2);
		
		BarrierAction a2 = new BarrierAction(3);
		
		CyclicBarrier barrier = new CyclicBarrier(2,a);
		CyclicBarrier barrier2 = new CyclicBarrier(2,a2);
		new Thread(new BarrierRunnable(barrier, barrier2)).start();
		new Thread(new BarrierRunnable(barrier, barrier2)).start();
	}
	
	class BarrierRunnable implements Runnable{
		
		CyclicBarrier b1;
		CyclicBarrier b2;
		
		public BarrierRunnable(CyclicBarrier b1, CyclicBarrier b2){
			this.b1=b1;
			this.b2= b2;
		}
		
		public void run(){
			System.out.println("starting first work");
			try {
				b1.await();
				} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("starting second work");
			try {
				b2.await();
				} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("all work is complete");
		}
	}
}
