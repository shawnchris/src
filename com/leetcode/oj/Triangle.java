package com.leetcode.oj;

import java.util.*;

/* 'Bottom-up' DP is very straightforward: 
 * we start from the nodes on the bottom row; the min pathsums for these nodes are the values 
 * of the nodes themselves. From there, the min pathsum at the ith node on the kth row would 
 * be the lesser of the pathsums of its two children plus the value of itself, i.e.:
 * minpath[k][i] = min( minpath[k+1][i], minpath[k+1][i+1]) + triangle[k][i];
 * Or even better, since the row minpath[k+1] would be useless after minpath[k] is computed, 
 * we can simply set minpath as a 1D array, and iteratively update itself:
 * For the kth level:
 * minpath[i] = min( minpath[i], minpath[i+1]) + triangle[k][i]; 
*/

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int rowNum = triangle.get(triangle.size() - 1).size();
	    int colNum = triangle.size();
	    int[][] dp = new int[rowNum][colNum];
	    int i = 0;
	    for (Integer n : triangle.get(colNum - 1)) {
	        dp[rowNum - 1][i++] = n;
	    }
	    for (int row = rowNum - 2, m = 0; row >= 0; row--, m++) {
	        for (int col = 0; col <= colNum - 2 - m; col++) {
	            dp[row][col] = Math.min(dp[row + 1][col], dp[row + 1][col + 1])
	                    + triangle.get(row).get(col);
	        }
	    }
	    return dp[0][0];
	}
	
	public int minimumTotal2(List<List<Integer>> triangle) {
		int rowNum = triangle.size();
        int[] dp = new int[rowNum];
        for (int i = 0; i < triangle.get(rowNum - 1).size(); i++) {
            dp[i] = triangle.get(rowNum - 1).get(i);
        }
        for (int row = rowNum - 2; row >= 0; row--) {// for each layer
            for (int col = 0; col <= row; col++) {
                dp[col] = Math.min(dp[col], dp[col + 1])
                    + triangle.get(row).get(col);
            }
        }
        return dp[0];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
