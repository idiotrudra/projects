package com.algo.test;

import com.prepare.multi.ElementMulti;

public class Test {

	public static void main(String[] args){
		System.out.println("Performing test");
		
		ITest test = getTestObject();
		
		test.PerformTest();
		System.out.println("The test is complete for : "+ test);
		
	}
	
	public static ITest getTestObject(){
		return new ElementMulti();
	}
}
