package com.leetcode.oj;

public class MaxSubArray {
	
	// Dynamic Programming Solution
	//  "We should ignore the sum of the previous n-1 elements if nth element is greater than the sum."
	public int maxSubArray1(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];
 
		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			max = Math.max(max, sum[i]);
			print_array(sum);
		}
 
		return max;
	}
	// Simplified version
	public int maxSubArray2(int[] A) {
		int newsum=A[0];
		int max=A[0];
		for(int i=1;i<A.length;i++){
			newsum=Math.max(newsum+A[i],A[i]);
			max= Math.max(max, newsum);
		}
		return max;
	}
	
	//Recursive version
	private long maxSumRec(int[] a, int low, int high) {
        long  leftSum = 0, rightSum = 0;
        long  sum = 0; 

        if (low == high) { // Base case
            return a[low]; 
        }

        int mid = (low + high)/2; // (low + high) / 2
        long maxLeftSum = maxSumRec(a, low, mid);
        long maxRightSum = maxSumRec(a, mid + 1, high);

        //max-crossing-subarray
        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += a[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        System.out.println("final left sum "+leftSum);
        System.out.println("final right sum "+rightSum);
        System.out.println("leftSum+rightSUM:"+(leftSum + rightSum));
        return max3(maxLeftSum, maxRightSum, (leftSum + rightSum));
    }

    private long max3(long a, long b, long c) {
        return a > b ? (a > c ? a : c) : (b > c ? b : c);
    }
    
	
	public void print_array(int[] a) {
		for (int i=0; i<a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		int[] a = {13, -3, -25, 20, -3 , -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		
		MaxSubArray ms = new MaxSubArray();
		System.out.println(ms.maxSubArray1(a));
		System.out.println(ms.maxSubArray2(a));
		System.out.println(ms.maxSumRec(a, 0, a.length-1));
	}

}
