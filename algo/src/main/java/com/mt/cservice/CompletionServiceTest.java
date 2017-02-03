package com.mt.cservice;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.algo.test.ITest;

public class CompletionServiceTest implements ITest {

	ExecutorService service = Executors.newFixedThreadPool(5);
	CompletionService<String> completionService = new ExecutorCompletionService<>(service);
	 
	@Override
	public void PerformTest() {
		completionService.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("started Service");
				Thread.sleep(5000);
				return "First";
			}
		});
		completionService.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				Thread.sleep(1000);
				System.out.println("started Service");
				return "Second";
			}
		});
		completionService.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("started Service");
				Thread.sleep(3000);
				return "Third";
			}
		});
		// TODO Auto-generated method stub
		
		try {
			System.out.println(completionService.take().get());
			System.out.println(completionService.take().get());
			System.out.println(completionService.take().get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
