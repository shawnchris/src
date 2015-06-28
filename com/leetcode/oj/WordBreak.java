package com.leetcode.oj;
import java.util.*;
public class WordBreak {
	/*
	The idea is pretty similar to other DP solution. 
	1)Keep all positions which could form substring contained in the set in a linkedlist 
	2)Iterate the target string, check substring between current position and stored positions. 
	If new sub string hits the dictionary, add it to the front of linkedlist.
	3)After iteration, check if the front element of linkedlist equals to the length of string.

	It consumes 296ms

	This solution is still a time O(n^2) and space O(n) one. It is better if dictionary contains long words. 
	 */
	public boolean wordBreak(String s, Set<String> dict) {
		if (s==null||s.length()==0) return false;
		else if (dict.contains(s)) return true;

		List<Integer> starts = new LinkedList<Integer>();
		starts.add(0);

		for (int end=1;end<=s.length();end++){
			boolean found=false;
			for (Integer start:starts)
				if (dict.contains(s.substring(start,end))){
					found=true;
					break;
				}
			if(found) {
				starts.add(0,end);
				System.out.println(starts);
			}
		}

		return (starts.get(0)==s.length());
	}
	
	/*
    1. Scan the the string from the tail
    2. Build possible solution for the current index based on DP results
    3. Return the solution when index==0
	*/
	public List<String> wordBreakII(String s, Set<String> dict) {
        Map<Integer, List<String>> validMap = new HashMap<Integer, List<String>>();

        // initialize the valid values
        List<String> l = new ArrayList<String>();
        l.add("");
        validMap.put(s.length(), l);

        // generate solutions from the end
        for(int i = s.length() - 1; i >= 0; i--) {
            List<String> values = new ArrayList<String>();
            for(int j = i + 1; j <= s.length(); j++) {
                if (dict.contains(s.substring(i, j))) {
                    for(String word : validMap.get(j)) {
                        values.add(s.substring(i, j) + (word.isEmpty() ? "" : " ") + word);
                    }
                }
            }
            validMap.put(i, values);
        }
        return validMap.get(0);
    }
	
	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		String s = "leetcode";
		Set<String> dict= new HashSet();
		dict.add("leet");
		dict.add("code");
		System.out.println(wb.wordBreak(s, dict));
		
		s = "catsanddog";
		dict.removeAll(dict);
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(wb.wordBreakII(s, dict));
	}

}
