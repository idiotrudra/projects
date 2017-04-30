package com.oracle.test.stest;

public class SumTest {

	public static int findMaxSum(int[] a){
		
		int include=a[0];
		int exclude=0;
		for(int i=1;i<a.length;i++){
			int e=Math.max(include, exclude);
			include = Math.max(exclude+a[i], Math.max(include, a[i]));
			exclude=e;
		}
		
		return Math.max(include, exclude);
	}
	
	public static void main(String[] args){
		
		int[] a = {-9,6,-9,8, 10, 3};
		
		System.out.println(findMaxSum(a));
		
	}
	
}
