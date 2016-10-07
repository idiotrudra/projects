package com.idiot.rudra.algo.union;

public class QuickUnionUFImpro extends QuickUnionUF {

	int sz[];

	public QuickUnionUFImpro(int n) {
		super(n);
		sz=new int[n];
		for (int i = 0; i < sz.length; i++) {
			sz[i] = 1;
		}

	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}

	}

}
