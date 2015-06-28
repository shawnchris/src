package com.leetcode.oj;

public class SearchRotatedArray {

	public int search(int[] A, int target) {
		int len = A.length;
		int lo = 0;
		int hi = len - 1;
		boolean at_left = false;
		int mid = 0;
		while (lo <= hi) { // Binary search
			mid = lo + (hi - lo) / 2;
			if (target == A[mid]) return mid;
			
			if (A[lo]<A[hi]) // increase only
				if (target < A[mid]) at_left=true;
				else at_left=false;
			else { 
				if (A[mid]>=A[lo]) {
					if (target < A[mid] && target >= A[lo]) at_left=true;
					else at_left=false;
				}
				else {
					if (target > A[mid] && target <= A[hi]) at_left=false;
					else at_left=true;
				}
			}
			
			if (at_left) hi=mid-1;
			else lo=mid+1;
		}
		return -1;
	}

	public static void main(String[] args) {

		int[][] a = {
				{3,1},
				{1,3,5},
				{9, 10, 11, 12, 13, 3, 4, 5, 6},
				{4,5,6,7,0,1,2},
				{4,5,6,7,8,1,2,3}
		};
		int[] t = {
				1,
				1,
				5,
				0,
				8,
		};

		SearchRotatedArray sra = new SearchRotatedArray();

		for (int i=0; i<a.length; i++)
			System.out.println(sra.search(a[i], t[i]));

	}

}
