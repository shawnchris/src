package com.leetcode.oj;

public class ReversePolish {
	public int evalRPN(String[] tokens) {
		int length = tokens.length;
		if (length > 1 ) {
			int first_op = 0;
			for (int i=0; i< length; i++)
				if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
					first_op=i;
					break;
				}
			String[] rep = new String[length-2];
			int c = 0;
			for (int i=0; i<=first_op-3; i++) {
				rep[c] = tokens[i];
				c++;
			}
			rep[c]=calc(Integer.valueOf(tokens[first_op-2]), tokens[first_op], Integer.valueOf(tokens[first_op-1]))+"";
			c++;
			for (int i=first_op+1; i<length; i++) {
				rep[c] = tokens[i];
				c++;
			}
			return evalRPN(rep);
		}
		else
			return Integer.valueOf(tokens[0]);
	}
	public int calc (int val1, String op, int val2) {
		if (op.equals("+"))
			return val1+val2;
		else if (op.equals("-"))
			return val1-val2;
		else if (op.equals("*"))
			return val1*val2;
		else if (op.equals("/"))
			return val1/val2;
		return 0;
	}
	
	public int evalRPN2(String[] tokens) {
		int lp = 0;
		int rp = tokens.length-1;
		while (rp > 0 ) {
			for (int i=lp; i<=rp; i++)
				if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
					lp = i;
					break;
				}
			tokens[lp-2] = calc2(tokens[lp-2], tokens[lp-1], tokens[lp]);
			for (int i=lp-1; i<rp-1; i++) tokens[i] = tokens[i+2];
			lp=lp-2;
			rp=rp-2;
		}
		return Integer.valueOf(tokens[0]);
		
	}
	
	public String calc2 (String left, String right, String op) {
		int val1 = Integer.valueOf(left);
		int val2 = Integer.valueOf(right);
		int result=0;
		if (op.equals("+"))
			result = val1+val2;
		else if (op.equals("-"))
			result = val1-val2;
		else if (op.equals("*"))
			result = val1*val2;
		else if (op.equals("/"))
			result = val1/val2;
		return result+"";
	}

	public static void main(String[] args) {
		String[] a1 = {"4","-2","/","2","-3","-","-"};
		String[] a2 = {"4","-2","/","2","-3","-","-"};
		ReversePolish rp = new ReversePolish();
		System.out.println(rp.evalRPN(a1));
		System.out.println(rp.evalRPN2(a2));
	}

}
