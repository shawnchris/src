package com.google.intern;

public class Sort_Merge {
	public int[] merge_sort (int[]  A, int left, int right) {
		if (left == right)
			return A;
		int middle = (right + left) / 2;
		merge_sort (A, left, middle);
		merge_sort (A, middle+1, right);
		merge(A, left, middle, right);
		return A;
	}
	
	void merge(int[] A, int left, int middle, int right) {
		int n1 = middle - left + 1;
		int n2 = right - middle;
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		for (int i=0; i<n1; i++)
			L[i] = A[left+i];
		for (int i=0; i<n2; i++)
			R[i] = A[middle+1+i];
		
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		int l=0, r=0;
		for (int i=left; i<=right; i++) {
			if (L[l] <= R[r]) {
				A[i] = L[l];
				l++;
			}
			else {
				A[i] = R[r];
				r++;
			}
		}
	}
	
	public static void main(String[] args) {
		Sort_Merge sm = new Sort_Merge();
		int[] test = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		int[] result = sm.merge_sort(test, 0, test.length-1);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
