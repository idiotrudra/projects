package com.algo.test;

import java.text.ParseException;

import com.idiot.rudra.algo.find.TestInheritance;
import com.jp.first.add;
import com.mt.barrier.BarrierTest;
import com.mt.countdown.CountDownTest;
import com.mt.cservice.CompletionServiceTest;
import com.oracle.test.domain.PersonEntry;
import com.oracle.test.input.InputStringParser;

public class Test {

	public static void main(String[] args){
		System.out.println("Performing test");
		
		try {
			PersonEntry person = new InputStringParser("\t", 3).parse("1011	16:12:23	Entry");
			System.out.println(person.getUid()+" "+ person.getTime()+ " "+ person.getEntryType());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ITest test = getTestObject();
		
		test.PerformTest();
		System.out.println("The test is complete for : "+ test);
		
	}
	
	public static ITest getTestObject(){
		//return new ElementMulti();
		//return new FindMaxChar();
		//return new Fibbonacci();
		return new TestInheritance();
	}
}
