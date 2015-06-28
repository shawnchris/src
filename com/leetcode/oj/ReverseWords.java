package com.leetcode.oj;

public class ReverseWords {
	public static String reverseWords(String s) {
		if (s.length()>0) {
            String[] parts = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i=parts.length-1; i>=0; i--)
                if (!parts[i].equals(" ") && parts[i].length()>0)
            	    sb.append(parts[i] + " ");
            return sb.toString().trim();
        }
        else return "";
            
    }
	public static void main(String[] arg) {
		String in = "   a   b ";
		System.out.println(reverseWords(in));
	}
	
}
