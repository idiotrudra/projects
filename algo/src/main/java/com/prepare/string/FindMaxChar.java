package com.prepare.string;

import com.algo.test.ITest;

public class FindMaxChar implements ITest{

	char findMaxChar(String string){
		char[] chars = string.toCharArray();
		
		int[] charsCount = new int[128];
		int max =0;
		char maxChar=chars[0];
		for(char e:chars ){
			charsCount[e] = charsCount[e]+1;
			if(max<charsCount[e]){
				max = charsCount[e];
				maxChar = e;
			}
		}
		
		return maxChar;
	}
	
	@Override
	public void PerformTest() {
		// TODO Auto-generated method stub
		
		System.out.println(findMaxChar("aaftff"));
		
	}

}
