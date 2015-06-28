package com.leetcode.oj;

import java.util.Hashtable;

public class AtoI {
	
	public int atoi(String str) {
		long result = 0;
		String input = str.trim();
		int length = input.length();
		
		if (length<=0)	return 0;
		
		String first = input.substring(0, 1);		
		Hashtable<String, Integer> numbers = new Hashtable<String, Integer> ();
		for (int i=0; i<10; i++)
			numbers.put(i+"", i);
		
		if (!(numbers.containsKey(first) || first.equals("+") || first.equals("-")))		
			return 0;
		else {
			boolean positive = true;
			if (first.equals("-"))	positive = false;
			String s = "";
			for (int i=0; i<length; i++) {
				s = input.substring(i, i+1);
				if (numbers.containsKey(s)) {
					result = result * 10 + numbers.get(s);
					if (result > Integer.MAX_VALUE) break;
				}
				else if (i>0) break;
			}
			if (!positive) result = result * -1;
			
			if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
			return (int)result;
		}
	}
	
	public static void main(String[] args) {
		String[] a = {
				"",
				"-1",
				"1",
				"                       ",
				"     1 2 3 4 5                  ",
				"+-2",
				"  -0012a42",
				"   +0 123",
				"9223372036854775809"
		};
		
		AtoI ati = new AtoI();
		
		for (int i=0; i<a.length; i++)
			System.out.println(ati.atoi(a[i]));
	}
}
