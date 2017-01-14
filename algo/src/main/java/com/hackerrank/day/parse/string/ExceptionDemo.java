package com.hackerrank.day.parse.string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ExceptionDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String S = in.next();
        
        try{
        	Integer i = Integer.parseInt(S);
        	System.out.println(i);
        }catch (NumberFormatException exception){
        	System.out.println("bad String");
        }
        
        
    }
    public int power(int n, int p) throws Exception{
        if(n<0 || p<0){
            throw new Exception("n and p should be non-negative");
        }
        
       return (int)Math.pow(n, p);
    }
}