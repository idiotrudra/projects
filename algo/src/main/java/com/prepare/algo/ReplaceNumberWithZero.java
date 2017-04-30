package com.prepare.algo;

import java.util.Arrays;
import java.util.LinkedHashMap;

import com.algo.test.ITest;

public class ReplaceNumberWithZero implements ITest {

	void replace(int[] a, int num) {

		int curV;
		int count = 0;
		for (int i = 0; i < a.length; i++) {

			if (a[i] == num) {

				if (count < 2) {
					count++;
				} else {
					a[i] = 0;
				}LinkedHashMap<K, V>
			}

		}

	}

	@Override
	public void PerformTest() {
		// TODO Auto-generated method stub

		int[] a = { 1, 2, 2, 2, 2, 3, 4, 5 };
		replace(a, 2);

		Arrays.stream(a).forEach(s -> System.out.println(s));

	}

}
