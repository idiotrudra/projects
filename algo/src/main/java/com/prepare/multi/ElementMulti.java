package com.prepare.multi;

import java.util.Arrays;

import com.algo.test.ITest;

public class ElementMulti implements ITest{

	
	public int[] findMulti(int[] a){
		int multiplication = 1;

		for(int e: a){
			multiplication = multiplication*e;
		}
		int[] sums = new int[4];
		
		for(int i =0; i<a.length; i++){
			sums[i]= multiplication/a[i];
		}
		
		return sums;
	}

	public void PerformTest() {
		// TODO Auto-generated method stub
		
		int[] a ={2, 4, 6, 1};
		Arrays.stream(a).forEach(e->System.out.print(e+" "));
		System.out.println();
		int[] s = findMulti(a);
		Arrays.stream(s).forEach(e->System.out.print(e+" "));
		
	}
}
