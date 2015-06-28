package com.leetcode.oj;

import java.util.*;

public class MinWindowSubstring {

	public String minWindow(String S, String T) {

		if (S.length()==0||T.length()==0||S.length()<T.length()) return "";
		
		//left -> the number of chars in T haven't been seen
		//start, end -> indexes of current sub-string which contains T.
		int left=T.length(),start=-1,end=S.length();
		
		//The queue has the indexes which T's char been seen in S.
		Deque<Integer> queue= new LinkedList<Integer>();

		//The map stores times a char in T - seen in S
		Map<Character,Integer> map= new HashMap<Character,Integer>();

		//Put times a char in T into map
		for (int i=0;i<T.length();i++){
			char c= T.charAt(i);
			map.put(c,map.containsKey(c)?map.get(c)+1:1);
		}

		//Go through S
		for (int i=0; i<S.length(); i++){
			char c = S.charAt(i);
			if (!map.containsKey(c))
				continue;

			int n = map.get(c);
			map.put(c,n-1); //Seen once
			queue.add(i); //Put the index into queue
			if (n>0) left--; //The number of chars in T haven't been seen

			char head = S.charAt(queue.peek());
			while(map.get(head)<0){ //Seen more times than in T. Remove the previous one and put in the new one
				queue.poll();
				map.put(head,map.get(head)+1);
				head=S.charAt(queue.peek());
			}

			if (left==0){ //Seen all, calculate the length.
				int new_length=queue.peekLast()-queue.peek()+1;
				if (new_length<end-start) {
					start=queue.peek();
					end=queue.peekLast()+1;
				} 
			}
		}
		if (left==0)  return S.substring(start,end);
		else return "";
	}
	
	public static void main(String[] args) {
		
		MinWindowSubstring mws = new MinWindowSubstring();
		
		System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));

	}

}
