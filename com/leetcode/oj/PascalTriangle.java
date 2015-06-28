package com.leetcode.oj;

import java.util.*;

public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> newList = new ArrayList<Integer>();
		List<Integer> lastList;

		if (numRows<=0) return result;
		
		newList.add(1);
		result.add(newList);
		lastList = newList;
		
		for(int i=2; i<=numRows; i++) {
			newList = new ArrayList<Integer>();
			for (int j=0; j<lastList.size(); j++) {
				if (j==0)
					newList.add(1);
				else
					newList.add(lastList.get(j)+lastList.get(j-1));
			}
			newList.add(1);
			result.add(newList);
			lastList = newList;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		
		List<List<Integer>> result = pt.generate(5);
		
		for (int i=0; i<result.size(); i++)
			System.out.println(result.get(i));

	}

}
