package com.leetcode.oj;

public class MaxProduct {
	public static int maxProduct(int[] A) {
		int total = 0;
        for (int i=0; i<A.length; i++)
            if (A[i]!=1 && A[i]!=-1) total ++;
        int[] B = new int[total];
        total=0;
        for (int i=0; i<A.length; i++)
            if (A[i]!=1 && A[i]!=-1) {
                B[total] = A [i];
                total++;
            }
        int product=B[0];
        int temp = 1;
        int length=B.length;
        for (int i=1; i<=length; i++) {
            for (int j=0; j<=length-i; j++) {
                temp = 1;
                for (int k=0; k<i; k++)
                    temp = temp * B[j+k];
                if (temp > product) product = temp;
            }
        }
        return product;
    }
	public static void main(String[] arg) {
		int[] array = {-5,2,4,1,-2,2,-6,3,-1,-1,-1,-2,-3,5,1,-3,-4,2,-4,6,-1,5,-6,1,-1,-1};
		System.out.println(maxProduct(array));
	}
}
