package com.hackerrank.day.pal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckSym {
	
	Stack<String> Stack = new Stack<String>();
	Queue<String> queue = new LinkedList<String>();
	
	void pushCharacter(char a ){
		Stack.push(String.valueOf(a));
	}
	
	void enqueueCharcter(char b){
		queue.add(String.valueOf(b));
	}

	char popCharacter(){
		return Stack.pop().charAt(0);
	}
	
	char dequeueCharacter(){
		return queue.poll().charAt(0);
	}
	
	
}
