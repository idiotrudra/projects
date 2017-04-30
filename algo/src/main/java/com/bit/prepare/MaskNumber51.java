package com.bit.prepare;

import com.algo.test.ITest;

public class MaskNumber51 implements ITest{

	public int maskNumber(int n, int m, int i, int j){
		
		int max = ~0; /* All 1’s */
		
		
		// 1’s through position j, then 0’s
			
		int left = max - ((1 << i) - 1);
			
		// 1’s after position i
			 int right = ((1 << j) - 1);
			
			 // 1’s, with 0s between i and j
		int mask = left | right;
		
		System.out.println(Integer.toBinaryString(left));
		System.out.println(Integer.toBinaryString(right));
		System.out.println(Integer.toBinaryString(mask));
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(((n&mask) | m<<i)));
		return ((n&mask) | (m<<j));
	}
	
	@Override
	public void PerformTest() {
		// TODO Auto-generated method stub
		maskNumber(1234997893, 10, 10, 16);
	}

	
}
