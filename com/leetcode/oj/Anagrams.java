package com.leetcode.oj;

import java.util.*;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
		if(strs==null || strs.length==0) return null;
		ArrayList<String> ret = new ArrayList<String>();
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(String s:strs)
		{
			char[] temp = s.toCharArray();
			Arrays.sort(temp); // Use sorted string as the key!
			ArrayList<String> array = map.get(new String(temp));
			if(array==null)
			{
				array = new ArrayList<String>();
				array.add(s);
				map.put(new String(temp), array);
			}
			else array.add(s);
		}
		for(String s:map.keySet())
		{
			ArrayList<String> array = map.get(s);
			if(array.size()!=1) ret.addAll(array);
		}
		return ret;
	}
	public static void main(String[] args) {
		Anagrams ag = new Anagrams();
		String[] test = {
				"arrigo boito", "tobia gorrio",
				"edward gorey", "ogdred weary", "regera dowdy", "e. g. deadworry",
				
		};
		List<String> result = ag.anagrams(test);
		System.out.println(result);

	}

}
