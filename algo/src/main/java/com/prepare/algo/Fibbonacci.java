package com.prepare.algo;

import com.algo.test.ITest;

public class Fibbonacci implements ITest {

	int generate(int n){
		int f=0, s=0, t=1, sum=0;
		
		if(n ==1 || n==2){
			return 1;
		}
		for(int i =0; i<n; i++){
			f = s;
			s=t;
			System.out.println(t);
			sum = sum+t;
			t = f+s;
		}
		
		return sum;
	}
	@Override
	public void PerformTest() {
		// TODO Auto-generated method stub
		System.out.println(generate(8));
		

	}

}
