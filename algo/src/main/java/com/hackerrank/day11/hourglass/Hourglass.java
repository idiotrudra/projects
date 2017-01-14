package com.hackerrank.day11.hourglass;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Hourglass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        int sum = Integer.MIN_VALUE;
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        
        for(int j =0 ; j<4; j++){
        	for(int k =0; k<4 ; k++){
        		int currentSum = arr[j][k]+arr[j][k+1]+ arr[j][+2]+ 
        				arr[j+1][k+1] +
        				arr[j+2][k]+arr[j+2][k+1]+ arr[j+2][k+2];
        		
        		if(currentSum>sum){
        			sum = currentSum;
        		}
        	}
        }
        
        System.out.println(sum);
        
        
        
    }
}
