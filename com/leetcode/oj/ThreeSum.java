package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public List<List<Integer>> threeSum2(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0; i < num.length-2; ++i) {
            if(i > 0 && num[i] == num[i-1])
                continue;

            int j = i + 1, k = num.length-1;

            while(j < k) {
                int candidate = num[i] + num[j] + num[k];
                if(candidate <= 0) {
                    if(candidate == 0)
                        result.add(Arrays.asList(num[i],num[j], num[k]));
                    ++j;
                    while (j < k && num[j] == num[j-1])
                        ++j;
                }
                else if(candidate > 0) {
                    --k;
                    while (k > j && num[k] == num[k+1])
                        --k;
                }
            }
        }

        return result;
    }
	
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Arrays.sort(num);
		
		for (int i=0; i<num.length-2; i++)
			for (int j=i+1; j<num.length-1; j++)
				for (int k=j+1; k<num.length; k++)
					if (num[i]+num[j]+num[k]==0) {						
						result.add(Arrays.asList(num[i], num[j], num[k]));
					}

		return result;
	}
	
	public static void main(String[] args) {
		int[] test1 = {-1, 0, 1, 2, -1, -4};
		int[] test2 = {0,7,-4,-7,0,14,-6,-4,-12,11,4,9,7,4,-10,8,10,5,4,14,6,0,-9,5,6,6,-11,1,-8,-1,2,-1,13,5,-1,-2,4,9,9,-1,-3,-1,-7,11,10,-2,-4,5,10,-15,-4,-6,-8,2,14,13,-7,11,-9,-8,-13,0,-1,-15,-10,13,-2,1,-1,-15,7,3,-9,7,-1,-14,-10,2,6,8,-6,-12,-13,1,-3,8,-9,-2,4,-2,-3,6,5,11,6,11,10,12,-11,-14};
		
		ThreeSum ts = new ThreeSum();
		List<List<Integer>> res = ts.threeSum(test1);
		System.out.println(res);
		res = ts.threeSum(test2);
		System.out.println(res);
		res = ts.threeSum2(test2);
		System.out.println(res);

	}

}
