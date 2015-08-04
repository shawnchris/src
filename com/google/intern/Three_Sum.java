package com.google.intern;

import java.util.*;

public class Three_Sum {
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0; i <= num.length - 2; i++) {
        	if (i > 0 && num[i] == num[i-1])
        		continue;
        	
        	int j = i + 1, k = num.length - 1;
        	while (j < k) {
        		if (num[i] + num[j] + num[k] <= 0) {
        			if (num[i] + num[j] + num[k] == 0) {
        				result.add(Arrays.asList(num[i], num[j], num[k]));
        			}
        			j++;
        			while (j < k && num[j] == num[j-1])
                		j++;
        		}
        		else if (num[i] + num[j] + num[k] > 0) {
        			k--;
        			while (k > j && num[k] == num[k+1])
        				k--;
        		}
        	}
        }

        return result;
    }
	
	public static void main(String[] args) {
		Three_Sum ts = new Three_Sum();
		int[] num = {-8, 0, 7, -2, 10, -7};
		List<List<Integer>> res = ts.threeSum(num);
		for (int i=0; i<res.size(); i++)
			System.out.println(res.get(i));
	}

}
