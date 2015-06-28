package com.leetcode.oj;

import java.util.*;

public class PhoneNumberLetterCombinations {

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
        if (digits==null) return null;
        int len = digits.length();
        if (len==0) return Arrays.asList("");
		String[] map = new String[]
				{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		int[] max = new int[len];
		int[] idx = new int[len];
		for (int i=0; i<len; i++) {
			max[i]=map[digits.charAt(i)-'0'].length();
			idx[i]=-1;
			//System.out.println(max[i]);
		}
		int level=0;
		
		while (level>=0) {
			//1 if it is not the last level: idx++
			//1.1 if idx within range: level++
			//1.2 else idx=-1, level--
			//2. if it is the last level
			//2.1 if idx within range: c++, add a new result
			//2.1 else idx=-1, level--
			if (level<len-1) {
				idx[level] ++;
				if (idx[level]<max[level])
					level++;
				else {
					idx[level]=-1;
					level--;
				}
			}
			else {
				idx[level]++;
				if (idx[level]<max[level]) {
					String temp="";
					for (int i=0; i<len; i++)
						temp=temp+map[digits.charAt(i)-'0'].substring(idx[i],idx[i]+1);
					result.add(temp);
					//System.out.println(result);
				}
				else {
					idx[level]=-1;
					level--;
				}
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		PhoneNumberLetterCombinations lc = new PhoneNumberLetterCombinations();
		String test = "99";
		System.out.println(lc.letterCombinations(test));

	}

}
