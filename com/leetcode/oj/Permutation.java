package com.leetcode.oj;
import java.util.*;
public class Permutation {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len = num.length;
		if (num==null || len==0) return result;

		int[] idx = new int[len];
		int level=0;
		for (int i=0; i<len; i++) idx[i]=-1;

		while(level>=0) {
			idx[level]++;
			if (idx[level]<len) { //index is in range
				if (Occupied(idx[level], level, idx)) //this position is occupied
					continue;
				else { //not occupied
					if (level<len-1) { //this is not the last level
						level++;
					}
					else { //last level, found a result
						List<Integer> res = new ArrayList<Integer>();
						for (int i=0; i<len; i++)
							res.add(num[idx[i]]);
						result.add(res);
					}
				}
			}
			else {//index is out of range
				idx[level]=-1; //reset the index
				level--; //backtrack
			}
		}

		return result;
	}
	public boolean Occupied(int num, int level, int[] array) {
		for (int i=0; i<level; i++) {
			if (array[i]==num) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Permutation p = new Permutation();
		System.out.println(p.permute(new int[]{1}));
		System.out.println(p.permute(new int[]{1,2,3,4,5,6}));
	}

}
