package com.google.intern;

import java.util.Arrays;

public class Facebook {
	
	// Find the greatest N in an array that there are at least N elements are greater than or equal to N.
	public int findGreatestN(int[] a) {
		int len = a.length;
		if (len == 0) return 0;
		Arrays.sort(a);
		for (int i = 0; i < len; i++) {
			if (a[i] >= len - i) // There are (len - i) elements greater than or equal to a[i]
				return len - i;
		}
		return 0;
	}

	public static void main(String[] args) {
		Facebook fb = new Facebook();
		int[] input1 = {1, 7, 6, 9, 8, 2, 4, 3};
		int[] input2 = {1, 7, 4, 9, 8, 2, 4, 3};
		int[] input3 = {1, 7, 4, 9, 8, 2, 4, 3, 6, 6, 10};
		
		
		System.out.println(fb.findGreatestN(input1));
		System.out.println(fb.findGreatestN(input2));
		System.out.println(fb.findGreatestN(input3));

	}

}
// 1, 2, 3, 4, 6, 7, 8, 9 " a[i]
// 8, 7, 6, 5, 4, 3, 2, 1 " len-i