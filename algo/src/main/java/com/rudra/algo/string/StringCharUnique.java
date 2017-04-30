package com.rudra.algo.string;

import java.util.Arrays;

import com.algo.test.ITest;

public class StringCharUnique implements ITest {

	private boolean testUniqueBoolean(String s){
		boolean[] b = new boolean[128];
		for(int i =0; i<s.length(); i++){
			if(b[s.charAt(i)]){
				return true;
			}
			b[s.charAt(i)] = true;
		}
		return false;
		
	}
	
	
	public String replaceSpace(String s ){
		StringBuilder rString = new StringBuilder();
		
		for(int i=0; i<s.length();i++){
			if(s.charAt(i)!=' '){
				rString.append(s.charAt(i));
			}else{
				rString.append("%20");
			}
		}
		
		return rString.toString();
	}
	
	public boolean testUnique(String c){
		char[] a = c.toCharArray();
		int l = c.length();
		Arrays.sort(a);
		for(int i=0;i<(l-1);i++){
			if(a[i]==a[i+1]){
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void PerformTest() {
		// TODO Auto-generated method stub
		String sfalse = "abc";
		String strue = "aabc";
		String strue2 = "abca";
		System.out.println(sfalse+" "+testUniqueBoolean(sfalse));
		System.out.println(strue+" "+testUniqueBoolean(strue));
		System.out.println(strue2+" "+testUniqueBoolean(strue2));
		
		System.out.println(sfalse+" "+testUnique(sfalse));
		System.out.println(strue+" "+testUnique(strue));
		System.out.println(strue2+" "+testUnique(strue2));
		System.out.println("hello"+replaceSpace("hello hemant how are you"));
	}

}
