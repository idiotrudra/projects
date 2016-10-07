package com.idiot.rudra.algo.union;

public class QuickUnionUF {

	protected int[] id;

	public QuickUnionUF(int n) {
		id = new int[n];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	public int root(int i) {
		while (i != id[i]){
			//this is improvement in the algorithms to flatten the tree.
			id[i]=id[id[i]];
			i = id[i];
		}
		return i;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}

}
