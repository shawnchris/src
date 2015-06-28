package com.leetcode.oj;

import java.util.Hashtable;

public class TwoSum {
	
	public int[] twoSum(int[] numbers, int target) {
        int len=numbers.length;
        int[] result = {0, 0};
        for (int i=0; i<len-1; i++)
            for (int j=i+1; j<len; j++) {
            	if (numbers[j]>target) j=len;
                if (numbers[i]+numbers[j]==target) {
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        return result;
    }
	
	public int[] twoSum2(int[] numbers, int target) {
        int len=numbers.length;
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        for (int i=0; i<len-1; i++) {
        	Integer index1 = ht.get(target-numbers[i]);
        	if (index1 != null)
        		return new int[]{index1, i};
        	ht.put(numbers[i], i);
        }
        return null;
    }
	
	public static void main(String[] args) {
		int[] test = new int[20000];
		for (int i=0; i<20000; i++)
			test[i] = i;
		
		TwoSum ts = new TwoSum();
		System.out.println("....");
		int[] result1 = ts.twoSum(test, 39900);
		System.out.println(result1[0]+"+"+result1[1]);
		System.out.println("....");
		int[] result2 = ts.twoSum(new int[]{3,2,4}, 6);
		System.out.println(result2[0]+"+"+result2[1]);

	}

}
