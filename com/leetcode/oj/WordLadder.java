package com.leetcode.oj;

import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] arg) {

		WordLadder wl = new WordLadder();

		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("cog");

		System.out.println(wl.ladderLength("hit", "cog", dict));

	}
	
	public static final char[] LETTERS = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public int ladderLength(String start, String end, Set<String> dict) {
		Queue<Node> fringe = new PriorityQueue<Node>();

		// enqueue start node
		fringe.add(new Node(start, 1));

		Set<String> visited = new HashSet<String>();

		// keep going while we have possibilities to search
		while (fringe.peek() != null) {
			Node current = fringe.peek();
			fringe.remove(current);

			// skip if we have already seen this
			if (visited.contains(current.value)) {
				continue;
			}

			// record visit
			visited.add(current.value);

			// we are done
			if (current.value.equals(end)) {
				return current.cost;
			} else {
				// permutate word, get candidates
				List<String> candidates = permutateWord(current.value, dict);
				for (String candidate : candidates) {
					// enqueue candidates, increment cost
					fringe.add(new Node(candidate, current.cost + 1));
				}
			}
		}

		return 0;
	}

	// Permutates a word by changing each letter in the word
	// and checking validity against a dictionary
	public List<String> permutateWord(String word, Set<String> dict) {
		List<String> result = new LinkedList<String>();

		char[] word_chars = new char[word.length()];
		word.getChars(0, word.length(), word_chars, 0);

		for (int i = 0; i < word.length(); i++) {
			// save original so we can reset it
			char original = word_chars[i];

			for (char letter : LETTERS) {
				// skip the originals, prevents backtracking
				if (letter == original) {
					continue;
				}

				word_chars[i] = letter;
				String candidate = new String(word_chars); 

				// only return valid words
				if (dict.contains(candidate)) {
					result.add(candidate);            
				}
			}

			// change one letter at a time
			// reset this one back to the original
			word_chars[i] = original;
		}

		return result;
	}

	// hold a possible node for the search
	public class Node implements Comparable<Node> {
		public String value;
		public int cost;

		public Node(String value, int cost) {
			this.value = value;
			this.cost = cost;
		}

		// orders based on current cost, natural ordering for PriorityQueue
		@Override
		public int compareTo(Node other) {
			if (other == null) {
				throw new NullPointerException("other is null");
			}

			if (this.cost == other.cost) {
				return 0;
			}

			return (this.cost > other.cost) ? 1 : -1;
		}
	}
	
}


