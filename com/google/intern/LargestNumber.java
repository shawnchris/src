package com.google.intern;

import java.util.*;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		String result = "";
		if (nums == null || nums.length == 0)
			return result;
		
		Comparator<String> c = new Comparator<String>() {
			public int compare(String s1, String s2) {
				/*
				if (Integer.parseInt(s1) == Integer.parseInt(s2))
					return 0;
				int l1 = s1.length(), l2 = s2.length();
				int ls = Math.min(l1, l2);
				for (int i = 0; i < ls; i++)
					if (s1.charAt(i) > s2.charAt(i)) // Larger one in front
						return -1;
					else if (s1.charAt(i) < s2.charAt(i)) // Smaller one in behind
						return 1;
				// Compare the rest of the longer string with the last char of the shorter string
				if (l1 != l2)  {
					if (l1 > l2) {
						int j = 0;
						for (int i = l2; i < l1; i++) {
							if (s1.charAt(i) > s2.charAt(j))
								return -1;
							else if (s1.charAt(i) < s2.charAt(j))
								return 1;
							j++;
							if (j >= l2)
								j = 0;
						}
					}
					else {
						int i = 0;
						for (int j = l1; j < l2; j++) {
							if (s1.charAt(i) > s2.charAt(j))
								return -1;
							else if (s1.charAt(i) < s2.charAt(j))
								return 1;
							i++;
							if (i >= l1)
								i = 0;
						}
					}
				}
				return 0; */
				
				String t1 = s1 + s2;
				String t2 = s2 + s1;
				if (t1 == t2)
					return 0;
				else
					if (t1.compareTo(t2) > 0)
						return -1;
					else
						return 1;
			}
				
		};
		
		Queue<String> queue = new PriorityQueue<String>(nums.length, c);
		
		for (int i = 0; i < nums.length; i++)
			queue.add(nums[i]+"");
		while (!queue.isEmpty())
			result += queue.poll() + " ";
		
		return result;
	}

	public static void main(String[] args) {
		int[] input1 = {3, 30, 34, 5, 9};
		int[] input2 = {824,938,1399,5607,6973,5703,9609,4398,8247};
		int[] input3 = {121,12};
		LargestNumber ln = new LargestNumber();
		System.out.println(ln.largestNumber(input1));
		System.out.println(ln.largestNumber(input2));
		System.out.println(ln.largestNumber(input3));
	}

}
