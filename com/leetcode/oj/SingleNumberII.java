package com.leetcode.oj;

public class SingleNumberII {
	
	public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
            System.out.println(Integer.toBinaryString(ones));
            System.out.println(Integer.toBinaryString(twos));
            System.out.println();
        }
        return ones;
    }
	
	public static void main(String[] args) {
		SingleNumberII sn = new SingleNumberII();
		int[] test = new int[] {2,2,2,1,64,64,64};
		System.out.println(sn.singleNumber(test));

	}

}
