package com.rudra.algo.string;

import com.algo.test.ITest;

public class PrefixStringTest implements ITest{

	public int isPrefix(String s1, String s2){
		int n = Math.min(s1.length(), s2.length());
		
		for(int i =0; i<n;i++){
			if(s1.charAt(i)!=s2.charAt(i)){
				return i;
			}
		}
		
		return n;
	}
	
	@Override
	public void PerformTest() {
		// TODO Auto-generated method stub
		
		System.out.println(isPrefix("prehemant", "prehloce"));
		
	}

}
