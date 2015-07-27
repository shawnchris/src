package com.google.intern;

public class SearchMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null)
			return false;
		int M = matrix.length;
		int N = matrix[0].length;
		if (M == 0  || N == 0)
			return false;
		
		for (int m = 0; m < M; m++)
			if (searchLine(matrix[m], 0, N-1, target))
				return true;
		return false;
	}
	
	private boolean searchLine(int[] line, int l, int r, int target) {
		if (l > r || l < 0 || r > line.length - 1)
			return false;
		if (target < line[l] || target > line[r])
			return false;
		
		int mid = (l + r) / 2;
		if (line[mid] == target)
			return true;
		else if (searchLine(line, l, mid - 1, target))
		    return true;
		else if (searchLine(line, mid + 1, r, target))
		    return true;
		
		return false;
	}
	
	// Because every time the upper-right element is the special one: 
	// all elements less than it are at its left side and all elements greater than it are behind.
	public boolean searchMatrix2 (int[][] matrix, int target) {
		
		if (matrix == null)
			return false;
		int M = matrix.length;
		int N = matrix[0].length;
		if (M == 0  || N == 0)
			return false;
	    
		int m = 0, n = N - 1;
	    while (m < M && n >= 0) {
	        if (matrix[m][n] == target)
	            return true;
	        else if (matrix[m][n] > target) {
	            n--;
	        } else 
	            m++;
	    }
	    return false;
	}

	public static void main(String[] args) {
		SearchMatrixII sm = new SearchMatrixII();
		int[][] input1 = { 
				{ 1,   4,  7, 11, 15 }, 
				{ 2,   5,  8, 12, 19 },
				{ 3,   6,  9, 16, 22 }, 
				{ 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		int[][] input2 = { { -1, 3 } };
		System.out.println(sm.searchMatrix(input2, 3));
		System.out.println(sm.searchMatrix(input1, 5));
		System.out.println(sm.searchMatrix(input1, 20));
		
		System.out.println(sm.searchMatrix2(input2, 3));
		System.out.println(sm.searchMatrix2(input1, 5));
		System.out.println(sm.searchMatrix2(input1, 20));
	}
}
