package com.tests.a.string.stack;

import java.io.IOException;
import java.util.Stack;

public class StringStacks {

	static char[] all = {'a', 'b', 'c','d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	public static void main(String[] args) throws IOException{
		System.out.println("Performing test");
		String src = "amezon";
		String trg = "amezoiion";
		
		int n =6;
		char[] asrc = src.toCharArray();
		char[] atrg = src.toCharArray();
		Stack<Character> sStack = new Stack<>();
		for(char sc : asrc){
			sStack.push(sc);
		}
		
		Stack<Character> tStack = new Stack<>();
		for(char tc : atrg){
			tStack.push(tc);
		}
		
		boolean result = pop(src, trg, n)||push(src, trg, n);
		
		if(result){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}
	
	static boolean pop(String s, String t, int n){
		if(n==0){
			if(s.equals(t)){
				return true;
			}
			return false;
		}
		
		if(Math.abs(s.length()-t.length())>n){
			return false;
		}
		if(t.contains(s)){
			if(s.length()==1|| s.isEmpty()){
				s="";
			}else{
				s=s.substring(0, s.length()-2);
			}
			n = n-1;
			return push(s, t, n);
		}else{
			if(s.length()==1|| s.isEmpty()){
				s="";
			}else{
				s=s.substring(0, s.length()-2);
			}
			n = n-1;
System.out.println(s);
			return pop(s, t, n)||push(s, t, n);
		}

	}
	

	static boolean push(String s, String t, int n){
		
		if(n==0){
			if(s.equals(t)){
				return true;
			}
			return false;
		}
		
		if(Math.abs(s.length()-t.length())>n){
			return false;
		}
		
		n = n-1;
		boolean result = false;
		for(char c: all){
			if(t.contains(s+c))
				result = result||pop(s+c, t, n)||push(s+c, t, n);
		}
		
		return result;
	}
	
}
