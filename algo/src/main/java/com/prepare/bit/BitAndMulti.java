package com.prepare.bit;

import com.algo.test.ITest;

public class BitAndMulti implements ITest {

	 int multiply(int i , int j){
		int a=i;
		int b=j;
		
		int result =0;
		
		while(b!=0){
			if((b&1)!=0){
				result = result+a;
			}
			a<<=1;
			b>>>=1;
		}
		 
		return result;
	}
	 
	 int add(int i, int j){
		 int result=i^j; 
		 int carry =(i&j)<<1;
		 if (carry!=0){
			 return add(result, carry);
		 }
		 return result;
	 }
	
	@Override
	public void PerformTest() {
		// TODO Auto-generated method stub
		System.out.println(multiply(101, 201));
		System.out.println(add(101, 201));
	}

}
