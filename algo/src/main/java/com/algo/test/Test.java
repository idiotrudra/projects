package com.algo.test;

import java.text.ParseException;

import com.bit.prepare.MaskNumber51;
import com.idiot.rudra.algo.find.TestInheritance;
import com.jp.first.add;
import com.mt.barrier.BarrierTest;
import com.mt.countdown.CountDownTest;
import com.mt.cservice.CompletionServiceTest;
import com.oracle.test.domain.PersonEntry;
import com.oracle.test.input.InputStringParser;
import com.prepare.algo.ReplaceNumberWithZero;

public class Test {

	public static void main(String[] args){
		System.out.println("Performing test");
		ITest test = getTestObject();
		
		test.PerformTest();
		System.out.println("The test is complete for : "+ test);
		
	}
	
	public static ITest getTestObject(){
		//return new ElementMulti();
		//return new FindMaxChar();
		//return new Fibbonacci();
		return new ReplaceNumberWithZero();
	}
}
