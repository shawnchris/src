package com.google.intern;

import java.util.*;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates == null) return result;
		int len = candidates.length;
		if (len == 0) return result;
		
		Arrays.sort(candidates);
		int plevel = 0;
		int[] pointers = new int[target];
		pointers[0] = -1;
		while (plevel >= 0) {
			pointers[plevel]++;
			if (pointers[plevel] > len - 1 || candidates[pointers[plevel]] > target) { // backtrack
				plevel--;
				continue;
			}
			int sum = getSum(candidates, pointers, plevel);
			if (sum == target) { // find a result;
				List<Integer> r = new ArrayList<Integer>();
				for (int i = 0; i <= plevel; i++)
					r.add(candidates[pointers[i]]);
				result.add(r);
			}
			else if (sum > target) { // backtrack
				plevel--;
			}
			else { // add another level
				plevel++;
				pointers[plevel] = pointers[plevel - 1] - 1;
			}
		}
		
		return result;
	}
	
	int getSum(int[] candidates, int[] pointers, int plevel) {
		int sum = 0;
		for (int i = 0; i <= plevel; i++)
			sum += candidates[pointers[i]];
		return sum;
	}

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] input1 = {2,3,6,7};
		List<List<Integer>> result =  cs.combinationSum(input1, 7);
		for (List<Integer> i : result) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

}
