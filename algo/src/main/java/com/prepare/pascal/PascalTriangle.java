package com.prepare.pascal;

public class PascalTriangle {

	public static void main(String[] args){
		printPascal(5);
	}
	
	static int pascal(int i , int j){
		if(j==0 || j==i){
			return 1;
		}
		
		return pascal((i-1),(j-1) )+pascal((i-1), j);
	}
	
	static void printPascal(int level ){
		for(int i =0; i<level; i++){
			for(int j=0; j<=i;j++){
				System.out.print(pascal(i, j)+" ");
			}
			System.out.println();
		}
		return;
	}
}
