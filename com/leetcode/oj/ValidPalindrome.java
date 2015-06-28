package com.leetcode.oj;

public class ValidPalindrome {

	public boolean valid(char c) {
		if ((c>='a'&&c<='z') || (c>='0'&&c<='9')) return true;
		return false;
	}

	public boolean isPalindrome(String s) {
		s=s.trim().toLowerCase();
		int len=s.length();
		if (len<=1) return true;

		int p1=0, p2=len-1;
		while (p1<len && p2>-1) {
			while (p1<len && !valid(s.charAt(p1))) p1++;
			while (p2>-1 && !valid(s.charAt(p2))) p2--;
			if (p1<len && p2>-1 && s.charAt(p1)!=s.charAt(p2))
				return false;
			if (p1<len) p1++;
			if (p2>-1) p2--;
		}

		while (p1<len-1) {
			p1++;
			if (valid(s.charAt(p1)))
				return false;
		}

		while (p2>0) {
			p2--;
			if (valid(s.charAt(p2)));
			return false;
		}

		return true;
	}

	public boolean isPalindrome2(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			if (Character.toLowerCase(s.charAt(i))
					!= Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			i++; j--;
		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();

		System.out.println(vp.isPalindrome2("a."));
		System.out.println(vp.isPalindrome2("1a2"));
		System.out.println(vp.isPalindrome2("Nella's simple hymn: \"I attain my help, Miss Allen.\""));
		System.out.println(vp.isPalindrome2("A man, a plan, a canal: Panama"));
		System.out.println(vp.isPalindrome2("race a car"));

	}

}
