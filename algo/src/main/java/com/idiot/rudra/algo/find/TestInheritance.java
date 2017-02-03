package com.idiot.rudra.algo.find;

import com.algo.test.ITest;

public class TestInheritance implements ITest {

	class A{
		
	}
	
	class B extends A{
		
	}
	
	void check(){
		B b = new B();
		A a = (A)b;
		
		System.out.println(b.getClass());
		System.out.println(a.getClass());
	}
	
	
	@Override
	public void PerformTest() {
		// TODO Auto-generated method stub
		check();
	}

}
