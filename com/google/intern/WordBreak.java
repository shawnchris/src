package com.google.intern;
import java.util.*;
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length()==0 || dict == null) return false;
        else if (dict.contains(s)) return true;

        return wordBreakRec(s, dict, 0, s.length());
    }
    
    private boolean wordBreakRec(String s, Set<String> dict, int start, int end) {
        if (start >= end) return false;
        for (int i = start + 1; i <= end; i++) { //from left to right
            if (dict.contains(s.substring(start, i))) {
                if (i == end) { // find a solution
                    return true;
                }
                if (wordBreakRec(s, dict, i, end))
                    return true;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		Set<String> dict = new HashSet<String>();
		String[] d = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		for (String s : d)
			dict.add(s);
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		System.out.println(wb.wordBreak(s, dict));

	}
}