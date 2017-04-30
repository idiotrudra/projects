package com.rudra.algo.string.substring;

import com.algo.test.ITest;

public class BruteSubSearch implements ITest {

	private int findSubString(String part, String text){
		int n = part.length();
		int m= text.length();
		
		for(int i=0; i<m-n;i++){
			int j=0;
			for(j = 0; j<n;j++){
				if(part.charAt(j)!=text.charAt(i+j)){
					 break;
				}
			}
			if(j==n){
				return i;
			}
		}
		
		return -1;
	}
	
	@Override
	public void PerformTest() {
		// TODO Auto-generated method stub
		int index = findSubString("hello", "manish, hello how are  you");
		if(-1!=index){
			System.out.println("sub string found at index"+index);
		}

	}

}
