package com.google.intern;

public class RotateMatrix {
	public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int y=0;y<n/2;y++){
            for(int x=y;x < n-y-1;x++){
                int temp=matrix[y][x];
                temp=move(matrix,temp,(n-1)-y,x);
                temp=move(matrix,temp,(n-1)-x,(n-1)-y);
                temp=move(matrix,temp,y,(n-1)-x);
                matrix[y][x]=temp;
                printMatrix(matrix);
            }
            
        }
    }
    private int move(int[][]matrix,int val, int x, int y){
        int store = matrix[y][x];
        matrix[y][x]=val;
        return store;
    }
    private void printMatrix(int[][] matrix) {
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix.length; j++)
    			System.out.print(matrix[i][j] + " ");
    		System.out.println();
    	}
    }
    
	public static void main(String[] args) {
		RotateMatrix rm = new RotateMatrix();
		int[][] input1 = {{1,2,3},
				          {4,5,6},
				          {7,8,9}
		};
		
		rm.rotate(input1);
	}

}
