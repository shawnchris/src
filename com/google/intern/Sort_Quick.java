package com.google.intern;

public class Sort_Quick {
	public void quick_sort (int[]  A, int left, int right) {
		if (left >= right)
			return;
		int pivot = partition(A, left, right);
		quick_sort(A, left, pivot-1);
		quick_sort(A, pivot+1, right);
	}
	
	int partition(int[] A, int left, int right) {
		int x = A[right];
		int i = left - 1;
		for (int j=left; j<right; j++)
			if (A[j] <= x) {
				i++;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		int temp = A[i+1];
		A[i+1] = A[right];
		A[right] = temp;
		return i+1;
	}
	
	public static void main(String[] args) {
		Sort_Quick sq = new Sort_Quick();
		int[] test = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		sq.quick_sort(test, 0, test.length-1);
		for (int i : test) {
			System.out.print(i + " ");
		}
	}

}
