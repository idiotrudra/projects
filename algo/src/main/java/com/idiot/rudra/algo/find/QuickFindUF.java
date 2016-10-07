package com.idiot.rudra.algo.find;

public class QuickFindUF {

	private int[] i;
	
	public QuickFindUF(int n){
		i= new int[n];
		for(int j=0; j<i.length;j++){
			i[j]=j;
		}		
	}
	
	public boolean connected(int p, int q){
		
		return i[p]==i[q];
	}
	
	public void union(int p, int q){
		int pid= i[p];
		int qid = i[q];
		for(int j=0;j<i.length;j++){
			if(i[j]==pid) i[j]=qid;
		}
	}
	
}
