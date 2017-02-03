package com.oracle.test.stest;

public class StringRotatation {

	public static void main(String[] args){
		String s = "Oracle commerece is hiring";
		
		int[] a = {2, 5, 0, 1};
		
		String[] st = s.split(" ");
		
		StringBuilder result = new StringBuilder(); 
		for(int i=0;i<a.length;i++){
			int length = st[i].length();
			String rp ="";
			if(i!=0){
			result = result.append(" ");
			}
			for(int j =0; j<a[i]; j++){
				rp = String.valueOf(st[i].charAt((length-1)-j))+rp;
			}
			result = result.append(rp+st[i].substring(0, length-a[i])).append(" ");
		}
		
		System.out.println(result);
	}
	
	
}
