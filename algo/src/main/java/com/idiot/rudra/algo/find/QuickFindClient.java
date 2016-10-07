package com.idiot.rudra.algo.find;

public class QuickFindClient {

	public static void main(String[] args){
		QuickFindUF quickfind = new QuickFindUF(10);
		quickfind.union(3, 4);
		quickfind.union(5, 7);
		quickfind.connected(3, 4);
		System.out.println("the connected element :"+quickfind.connected(3, 4));
		System.out.println("the connected element :"+quickfind.connected(3, 7));
		quickfind.union(4, 7);
		System.out.println("the connected element :"+quickfind.connected(3, 7));
	}
}
