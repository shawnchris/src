package com.google.intern;

public class Sort_Insertion {
	public int[] insertion_sort (int[]  A) {
		for (int i=1; i<A.length; i++) {
			int key = A[i];
			int j = i - 1;
			while (j>=0 &&  A[j]>key) {
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = key;
		}
		return A;
	}

	public static void main(String[] args) {
		Sort_Insertion si = new Sort_Insertion();
		int[] test = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		int[] result = si.insertion_sort(test);
		for (int i : result) {
			System.out.print(i + " ");
		}

	}
}
