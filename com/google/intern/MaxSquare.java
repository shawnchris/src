package com.google.intern;

public class MaxSquare {
	int getMax(char[][] matrix, int y, int x, int Y, int X) {
        int s = 1;
        boolean nozero = true;
        while (y + s < Y && x + s < X && nozero) {
            for (int i = 0; i <= s; i++) {
                if (matrix[y + i][x + s] == '0') {
                    nozero = false;
                    break;
                }
            }
            if (nozero)
	            for (int j = 0; j <= s; j++) {
	                if (matrix[y + s][x + j] == '0') {
	                    nozero = false;
	                    break;
	                }
	            }
            if (nozero)
            	s++;
        }
        return s;
    }
    
    public int maximalSquare(char[][] matrix) {
        int Y = matrix.length;
        if (Y == 0) return 0;
        int X = matrix[0].length;
        int max = 0;
        
        for (int y = 0; y < Y; y++) {
            if (Y - y <= max) break;
            for (int x = 0; x < X; x++) {
                if (X - x <= max) break;
                if (matrix[y][x] == '1') {
                    int m = getMax(matrix, y, x, Y, X);
                    max = Math.max(max, m);
                }
            }
        }
        
        return max * max;
    }
    
    public int maximalSquareDP(char[][] matrix) {
        int Y = matrix.length;
        if (Y == 0) return 0;
        int X = matrix[0].length;
        int[][] dp = new int[Y][X];
        
        for (int i = 0; i < Y; i++) dp[i][0] = matrix[i][0] - '0';
        for (int i = 1; i < X; i++) dp[0][i] = matrix[0][i] - '0';
        int max = dp[0][0];
                
        for (int y = 1; y < Y; y++) {
            for (int x = 1; x < X; x++) {
                if (matrix[y][x] == '1') {
                    dp[y][x] = Math.min(dp[y-1][x-1], Math.min(dp[y-1][x], dp[y][x-1])) + 1;
                    max = Math.max(max, dp[y][x]);
                }
                else
                    dp[y][x] = 0;
            }
        }
        
        return max * max;
    }
    
	public static void main(String[] args) {
		MaxSquare ms = new MaxSquare();
		char[][] matrix1 = { {'1', '0'}, {'1', '0'}};
		char[][] matrix2 = { {'1', '1'}, {'1', '1'}};
		System.out.println(ms.maximalSquare(matrix1));
		System.out.println(ms.maximalSquare(matrix2));
		System.out.println(ms.maximalSquareDP(matrix1));
		System.out.println(ms.maximalSquareDP(matrix2));
	}

}
